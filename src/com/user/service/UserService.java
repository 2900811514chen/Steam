package com.user.service;

import com.user.dao.UserDao;
import com.user.entity.User;

//业务逻辑层：逻辑性的增删改查，对dao层的组装
public class UserService {
    //用户注册
    public static boolean addUser(User user){
        if (!UserDao.isExit(user.getAccount())){//如果不存在该用户才注册用户
            UserDao.addUser(user);
            return true;
        }
        return false;
    }
    //用户登录
    public static boolean Login(User user){
        if (UserDao.isExit(user.getAccount())){
            return true;
        }
        return false;
    }
}
