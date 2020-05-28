package com.qa.tests;

import org.testng.annotations.Test;

import java.sql.*;

public class JdbcConnectionOracle {


    public  static  Connection getConnection(){
            Connection conn=null;

            try {
                String url="jdbc:oracle:thin:@172.19.188.198:1521:iimadevl";
                String user="JC_PRO";
                String password="8P2621Xct-gFLUVm-_kV";

                Class.forName("oracle.jdbc.driver.OracleDriver");//加载数据驱动
                conn = DriverManager.getConnection(url, user, password);// 连接数据库

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("加载数据库驱动失败");
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("连接数据库失败");
            }
            return conn;
        }
        public static void close(Connection conn, PreparedStatement ps, ResultSet rs){
            try {
                if(rs!=null){
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if(ps!=null){
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if(conn!=null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }


