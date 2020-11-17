package com.cast.serviceman.server.service;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SFTPException;
import ch.ethz.ssh2.Session;
import com.cast.serviceman.api.entity.ServiceDto;
import com.cast.serviceman.api.entity.common.ResponseModel;
import com.cast.serviceman.api.entity.vo.ServiceDtoVo;
import com.cast.serviceman.api.service.ComputerServerService;
import com.cast.serviceman.server.mapper.ServiceDtoMapper;
import com.cast.serviceman.server.mapper.TGroupMapper;
import com.cast.serviceman.util.CommonUtils;
import com.cast.serviceman.util.ConnectionUtil;
import com.cast.serviceman.util.SFTPUtil;
import com.jcraft.jsch.SftpException;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 服务器管理
 */

@Component
@DubboService(version = "1.0", group = "serviceman1.0", retries = 3, timeout = 3000)
public class ComputerServiceImpl implements ComputerServerService {

    @Resource
    private TGroupMapper groupMapper;
    @Value("${group.name}")
    private String groupName;
    @Value("${system.type}")
    private String systemType;

    @Resource
    private ServiceDtoMapper serviceDtoMapper;

    @Override
    public ResponseModel<List<ServiceDto>> queryVirtualByGId(String virtualId) {
        ResponseModel<List<ServiceDto>> responseModel = new ResponseModel<>();

        List<ServiceDto> list = serviceDtoMapper.queryVirtualByGId(virtualId);
        responseModel.setData(list);
        responseModel.setSuccess(true);
        return responseModel;
    }

    /**
     * 增加服务器, 虚拟机下
     *
     * @param dto
     */
    @Override
    @Transactional
    public ResponseModel<Integer> add(ServiceDto dto) {
        ResponseModel<Integer> responseModel = new ResponseModel<>();
        dto.setGroupId(groupMapper.selectByName(groupName));
        dto.setServiceId(CommonUtils.generateUUID());
        //设置服务器名称,vm+ip后两位
        String ip = dto.getServiceIp();
        String[] s = ip.split("\\.");
        String name = "vm" + s[2] + "." + s[3];
        dto.setServiceName(name);
        //创建连接
        Connection connection = null;
        try {
            //创建连接
            connection = ConnectionUtil.getConnect(dto.getServiceIp(), 22, dto.getServiceAccount(), dto.getServicePassword());
            //判断是否获取到连接
            if (!connection.isAuthenticationComplete()) {
                responseModel.setErrorMsg("服务器连接失败");
                return responseModel;
            }
            SFTPUtil sftp = new SFTPUtil(dto.getServiceAccount(), dto.getServicePassword(), dto.getServiceIp(), 22);
            sftp.login();
            String fileName = "/opt/vela2/serviceman.sh";
            //本机磁盘上的文件,读取文件
            String diskFile = fileName.substring(fileName.lastIndexOf("/") + 1);
            File file = new File("/usr/files/" + diskFile);
            InputStream is = new FileInputStream(file);
            int n = fileName.indexOf("/", 1);
            //基础路径 例如 /usr
            String basePath = fileName.substring(0, n);
            //路径 例如  liu/test
            String directory = fileName.substring(n + 1, fileName.lastIndexOf("/"));
            // xxx.jar
            String fileName1 = fileName.substring(fileName.lastIndexOf("/") + 1);
            //上传
            sftp.upload(basePath, directory, fileName1, is);
            sftp.logout();
            is.close();
            int number = serviceDtoMapper.insert(dto);
            if (number > 0) {
                responseModel.setSuccess(true);
                responseModel.success(number);
            } else {
                responseModel.failed("增加服务失败");
            }
        } catch (IOException e) {
            responseModel.setErrorMsg("服务器连接失败");
            return responseModel;
        } catch (SftpException e) {
            responseModel.setErrorMsg("服务器连接失败");
            return responseModel;
        } finally {
            ConnectionUtil.closeConnection(connection);
        }
        return responseModel;
    }

    /**
     * 修改服务器, 虚拟机下
     *
     * @param dto
     */
    @Override
    @Transactional
    public ResponseModel<Integer> update(ServiceDto dto) {
        ResponseModel<Integer> responseModel = new ResponseModel<>();
        //设置服务器名称,vm+ip后两位
        String ip = dto.getServiceIp();
        String[] s = ip.split("\\.");
        String name = "vm" + s[2] + "." + s[3];
        dto.setServiceName(name);
        int number = serviceDtoMapper.updateByPrimaryKey(dto);

        if (number > 0) {
            responseModel.success(number);
        } else {
            //修改数据失败
            responseModel.failed("修改服务器失败");
        }
        return responseModel;
    }

    /**
     * 查询单个服务器信息
     *
     * @param id
     * @return
     */
    @Override
    public ResponseModel<ServiceDto> queryById(String id) {
        ResponseModel<ServiceDto> responseModel = new ResponseModel<>();
        ServiceDto dto = serviceDtoMapper.selectByPrimaryKey(id);
        responseModel.setData(dto);
        responseModel.setSuccess(true);
        return responseModel;
    }

    /**
     * 根据IP查询数据
     *
     * @param id
     * @return
     */
    @Override
    public ServiceDto queryByIp(String id) {
        ServiceDto dto = serviceDtoMapper.queryByIp(id);
        return dto;
    }

    /**
     * 查询所有的虚拟机
     */

    @Override
    public ResponseModel<List<ServiceDtoVo>> queryAll() {
        ResponseModel<List<ServiceDtoVo>> responseModel = new ResponseModel<>();
        List<ServiceDtoVo> list = serviceDtoMapper.queryAll(null, null, null);
        responseModel.setData(list);
        responseModel.setSuccess(true);
        return responseModel;
    }

    @Override
    public ResponseModel<Integer> delete(String id) {
        ResponseModel<Integer> responseModel = new ResponseModel<>();
        Integer count = serviceDtoMapper.deleteByPrimaryKey(id);
        if (count > 0) {
            responseModel.success(count);
        } else {
            //删除数据失败
            responseModel.failed("删除服务器失败");
        }

        return responseModel;
    }

}
