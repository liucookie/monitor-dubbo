package com.cast.serviceman.util;

import java.io.*;

public class DESConfigurationFiles {

    //文件路径
    private static String path = "F:/bootstart.ini";

    public static void main(String[] args) throws Exception {
        String str = null;
        File file = new File(path);
        if (file.isFile() && file.exists()) { //判断文件是否存在
            //对文件路径进行修改,以便新的文件使用
            String sub = path.substring(path.lastIndexOf("/") + 1, path.lastIndexOf("."));
            String cipherPath = path.replace(sub, sub + "_cipher");
            //新建密文文件
            File cipherFile = new File(cipherPath);
            if (cipherFile.isFile() && cipherFile.exists()) {
                cipherFile.delete();
            }
            cipherFile.createNewFile();
            //对密文文件写入内容
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream(cipherFile);
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            //修改密文进行加密处理
            str = DESConfigurationFiles.getRead(cipherPath);
            String password = str.substring(str.lastIndexOf("=") + 1);
            //加密
            String ciphertext = DESUtil.getEncryptString(password.trim());
            str = str.replaceAll(password, ciphertext);
            //将修改的密文文件写入文件
            DESConfigurationFiles.setWrite(str, cipherFile);

            //关闭读写通道
            fos.flush();
            fis.close();
            fos.close();
        } else {
            System.out.println("错误警告，找不到配置文件！");
        }

    }


    /**
     * 对文件内容进行读取
     *
     * @param path
     * @return
     */
    public static String getRead(String path) {
        File file = new File(path);
        StringBuffer res = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                res.append(line + "\n");
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res.toString();
    }

    /**
     * 修改文件内容
     *
     * @param cont
     * @param dist
     */
    public static void setWrite(String cont, File dist) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(dist));
            writer.write(cont);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}