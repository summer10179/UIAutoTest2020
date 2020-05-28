package com.qa.tests;

import java.sql.*;

public class Main {


        public static void main(String[] args) throws Exception{
            //驱动标识符
            String driver = "oracle.jdbc.OracleDriver";
            //url链接
            String url = "jdbc:oracle:thin:@172.19.188.198:1521:iimadev";
            //数据库的用户名
            String user = "JC_PRO";
            //数据库的密码
            String password = "8P2621Xct-gFLUVm-_kV";
            //加载驱动
            Class.forName("oracle.jdbc.OracleDriver");
            //创建连接
            Connection connection = DriverManager.getConnection(url,user,password);
            //创建执行引擎
            Statement statement = connection.createStatement();
            //执行sql语句
            ResultSet rs = statement.executeQuery("select *from P_CHECK_TASK");
            //解析返回结果
            System.out.println("=======");
            while(rs.next())
            {
                int task_id = rs.getInt("TASK_ID");
                String topic_code = rs.getString("TOPIC_CODE");
                String  sal = rs.getString("ORG_NO");
                Date date = rs.getDate("EXEC_INIT_TIME");
                System.out.println("任务编号："+task_id+", 主题名字："+topic_code+", 工资："+sal+", 入职日期："+date);
            }
            //关闭资源，后申请的先关闭
            rs.close();
            statement.close();
            connection.close();
        }
    }
