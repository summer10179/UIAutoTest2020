package com.qa.tests;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

public class JdbcTest {
    public static void main(String[] args) throws SQLException {
        Connection str;
        JdbcConnectionOracle jdbcConnectionOracle=new JdbcConnectionOracle();

        str=jdbcConnectionOracle.getConnection();

        //创建一个客户端的对象str。对象有他自己的方法，
        Statement statement=str.createStatement();
        ResultSet rs = statement.executeQuery("select *from P_CHECK_TASK");

    }
}
