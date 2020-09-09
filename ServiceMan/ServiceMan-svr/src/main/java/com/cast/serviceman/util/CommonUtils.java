package com.cast.serviceman.util;


import java.math.BigDecimal;
import java.util.UUID;

public class CommonUtils {


    /**
     * 生成 uuid
     *
     * @return
     */
    public static String generateUUID() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid;
    }

    /**
     * 获取分页开始查询的，起始值
     *
     * @return
     */
    public static int getPageStart(int pageNum,int pageSize) {
//        if (pageNum <= 0 || pageSize <= 0){
//            throw new PlatException("页目非法");
//        }
        return (pageNum - 1) * pageSize;
    }

    /**
     * 处理返回几个小数
     * @param d
     * @param newScale
     * @return
     */
    public static Double roundValue(Double d, int newScale) {
        Double retValue = null;
        if (d != null) {
            BigDecimal bd = new BigDecimal(d);
            retValue = bd.setScale(newScale,BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        return retValue;
    }

}
