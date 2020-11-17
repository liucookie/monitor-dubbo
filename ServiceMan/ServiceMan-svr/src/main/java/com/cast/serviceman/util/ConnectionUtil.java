package com.cast.serviceman.util;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ConnectionUtil {

    /**
     * 获取ip连接
    * @param ip
     * @param port
     * @param account
     * @param password
     * @return
     * @throws IOException
     */
    public static Connection getConnect(String ip, int port, String account, String password) throws IOException {
        Connection conn = null;
        try {
            //创建连接
            conn = new Connection(ip, port);
            //启动连接
            conn.connect();
            //验证账号密码
            conn.authenticateWithPassword(account, password);
        }catch (Exception e){
            return conn;
        }
        return conn;
    }

    /**
     * 获取执行内容
     * @param conn
     * @param command
     * @return
     * @throws IOException
     */
    public static BufferedReader getSession(Connection conn,String command) throws IOException {
        Session session = conn.openSession();
        //执行指令
        session.execCommand(command);
        //获取读取对象  然后即可拿到所需内容
        InputStream in = new StreamGobbler(session.getStdout());
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
//        reader.close();
//        if (null != session) {
//            session.close();
//        }
        return reader;
    }

    public static String readBuffer(BufferedReader reader) throws  IOException{
        StringBuffer sb = new StringBuffer();
        String buf = null;
        while ((buf = reader.readLine()) != null) {
            sb.append(buf);
        }
        return sb.toString();
    }

    /**
     * 关闭连接
     * @param connection
     */
    public static void closeConnection(Connection connection){
        if (null != connection){
            connection.close();
        }
    }
}
