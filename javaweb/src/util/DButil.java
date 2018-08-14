package util;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DButil{

    static String CLASSFORNAME="com.mysql.jdbc.Driver";
    static String SERVANDDB="jdbc:mysql://localhost:3306/sakila";
    static String USER="root";
    static String PWD="root";

    //加载驱动
    static{
        try {
            Class.forName(CLASSFORNAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //连接数据库
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager
                    .getConnection(SERVANDDB,
                            USER, PWD);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //关闭数据库
    public static void release(Connection conn,Statement stmt ,ResultSet rs){
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}


