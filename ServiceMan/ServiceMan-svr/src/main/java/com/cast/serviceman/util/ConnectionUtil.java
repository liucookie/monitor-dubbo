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
        //创建连接
        Connection conn = new Connection(ip, port);
        //启动连接
        conn.connect();
        //验证账号密码
        conn.authenticateWithPassword(account, password);
        //获取连接对象
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
        reader.close();
        if (null != session) {
            session.close();
        }
        return reader;
    }
}
