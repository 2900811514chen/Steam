package com.user.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCUtil {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/steam?useSSL=false&serverTimezone=GMT";
    private static final String USER = "root";
    private static final String PASS = "mysql";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static Connection connection = null;
    public static PreparedStatement preparedStatement = null;
    public static ResultSet resultSet = null;

    //通用增删改
    public static boolean executeUpdate(String sql, Object[] parameters) {
        try {
            preparedStatement=createPrepareStatement(sql, parameters);
            int count = preparedStatement.executeUpdate();//executeUpdate方法执行后影响的行数
            if (count > 0) {//操作成功
                closeAll();
                return true;
            } else {//操作失败
                closeAll();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //通用查询
    public static ResultSet executeQuery(String sql, Object[] parameters) {
//        Object object = null;
//        List<Object> objects = new ArrayList<>();
        preparedStatement = createPrepareStatement(sql, parameters);
        try {
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
        //ResultSet close方法在service
    }

    //连接数据库
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);//加载驱动
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    //创建PrepareStatemnt
    public static PreparedStatement createPrepareStatement(String sql, Object[] parameters) {
        try {
            preparedStatement = getConnection().prepareStatement(sql);
            if (parameters != null) {
                //如果没有参数传进则不进行操作
                //setXXXX方法的个数与parameter的长度一致
                for (int i = 0; i < parameters.length; i++) {
                    preparedStatement.setObject(i + 1, parameters[i]);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    //关闭链接
    public static void closeAll(){
        try {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
