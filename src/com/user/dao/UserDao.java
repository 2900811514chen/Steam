package com.user.dao;

import com.user.entity.User;
import com.user.util.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class UserDao {//数据访问层，项目中原子级的增删改查
    //判断用户是否存在
    public static boolean isExit(String steamAccount){
        User user=null;
        try {
            user=queryUserByAccount(steamAccount);
            //System.out.println("UserDao判断用户是否存在："+user.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //return user!=null?true:false;//user!=null即代表存在该用户
        return user!=null;
    }

    //用户注册
    public static void addUser(User user){
        String sql="insert into user(steam_account,steam_password,user_name,steam_id) values (?,?,?,?)";//占位符
        String[]parameters={user.getAccount(),user.getPassWord(),user.getUserName(),user.getSteamID()};//创建时间由数据库给定
        //System.out.println("UserDao用户注册："+user.getAccount()+""+user.getPassWord()+""+user.getUserName()+""+user.getSteamID());
        JDBCUtil.executeUpdate(sql,parameters);
    }

    //根据账号查询用户
    public static User queryUserByAccount(String steamAccount) throws SQLException {
        User user=null;
        String sql="select * from user where steam_account=?";
        String [] parameters={steamAccount};
        ResultSet resultSet=JDBCUtil.executeQuery(sql,parameters);
        if (resultSet.next()){
            String steamPassword=resultSet.getString("steam_password");
            String userName=resultSet.getString("user_name");//"username"是数据库的username列
            String steamID=resultSet.getString("steam_id");
            Date createTime= resultSet.getDate("create_time");
            user=new User(steamAccount,steamPassword,userName,steamID,createTime);
        }
        JDBCUtil.closeAll();
        return user;
    }

    //根据steamID查询用户
    public static User queryUserBySteamID(String steamID){
        User user=null;
        String sql="select * from user where steam_id=?";
        String [] parameters={steamID};
        ResultSet resultSet=JDBCUtil.executeQuery(sql,parameters);
        try {
            if (resultSet.next()){
                String steamAccount=resultSet.getString("steam_id");
                String steamPassword=resultSet.getString("steam_password");
                String userName=resultSet.getString("user_name");//"user_name"是数据库的username列
                Date createTime= resultSet.getDate("create_time");
                user=new User(steamAccount,steamPassword,userName,steamID,createTime);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtil.closeAll();
        return user;
    }
}
