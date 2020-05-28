package com.qa.tests;

import java.sql.*;

public class JdbcDataTest {



    public static void main(String[] args) throws SQLException {
        JdbcConnection jdbcConnection=new JdbcConnection();
        Connection str;
        str=jdbcConnection.getConnection();
        System.out.println(str);
        //Collection类似于客户端，需要创建一个客户端的对象。对象是str.
        Statement statement=str.createStatement();
        //执行sql语句
       // ResultSet rs = statement.executeQuery("select *from P_CHECK_TASK");
        ResultSet rs = statement.executeQuery("select *from P_CHECK_CONS_DTL ");
        //解析返回结果
        System.out.println("=======");
        while(rs.next())
        {
//            int task_id = rs.getInt("TASK_ID");
            String topic_code = rs.getString("TOPIC_CODE");
//             String  sal = rs.getString("ORG_NO");
//             Date date = rs.getDate("EXEC_INIT_TIME");
//             System.out.println("任务编号："+task_id+", 主题名字："+topic_code+", 工资："+sal+", 入职日期："+date);
             System.out.println("主题名字："+topic_code);
        }
        //关闭资源，后申请的先关闭
        rs.close();
        statement.close();


    }




}
