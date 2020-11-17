package com.cast.serviceman.api.entity;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class test {


    public static void main(String[] args) throws IOException{
        Connection connection = getConnect("192.168.3.200",22,"liu","Guanli2020");
//        Connection connection = getConnect("192.168.3.200",22,"serviceman","123456");
//        Connection connection = getConnect("47.92.225.234",22,"root","Guanli2019");
        String aa = getSession(connection,"df -h");
        System.out.println(aa);

    }

    public static Connection getConnect(String ip, int port, String account, String password) throws IOException {
        //创建连接
        Connection conn = new Connection(ip, port);
        //启动连接
        conn.connect();
        //验证账号密码
        conn.authenticateWithPassword(account, password);
        //获取连接对象
        return conn;
    }
    public static BufferedReader getSession1(Connection conn,String command) throws IOException {
        Session session = conn.openSession();
        //执行指令
        session.execCommand(command);
        //获取读取对象  然后即可拿到所需内容
        InputStream in = new StreamGobbler(session.getStdout());
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
       return reader;
    }

    public static String getSession(Connection conn,String command) throws IOException{
        Session session = conn.openSession();
        //执行指令
        session.execCommand(command);
        //获取读取对象  然后即可拿到所需内容
        InputStream in = new StreamGobbler(session.getStdout());
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String buf = null;
        StringBuffer sb = new StringBuffer();
        List<String> list = new ArrayList<>();
        Float total = new Float(0);
        while ((buf = reader.readLine()) != null) {
            sb.append(buf);
            if (!buf.contains("use%")  && !buf.contains("已用%") && !buf.contains("use%")){
                list.add(buf.toString());
                String[] st = buf.trim().split("\\s+");
                String a = st[4];
                float result=new Float(a.substring(0,a.indexOf("%")))/100;
                total +=result;
                //System.out.println(result);
            }
            //System.out.println(total);
            //System.out.println(buf);// 打印控制台输出
        }
        String aa = Math.round( total*100) + "%";
        System.out.println(Math.round( total*100) + "%");
        reader.close();
        if (null != session) {
            session.close();
        }
        return aa;
    }


}
