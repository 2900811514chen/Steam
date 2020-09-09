package com.user.entity;

import com.user.dao.UserDao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
    private String account;
    private String passWord;
    private String userName;//可随意修改
    private String steamID;//steamID，也是好友代码，系统给定唯一，用于添加好友
    private String onlineStatus;//用户的在线状态
    private Date createTime;//用户加入Steam时间

    //无参构造函数
    public User() {
    }

    public User(String account, String passWord) {
        this.account = account;
        this.passWord = passWord;
        this.userName = account;//用户名可随意更改，默认为账户名
        this.steamID = setSteamID();
    }

    public User(String account, String passWord, String userName, String steamID, Date createTime) {
        this.account = account;
        this.passWord = passWord;
        this.userName = userName;
        this.steamID = steamID;
        this.createTime = createTime;
    }

    //取一位10位随机字符串
    public static String getRandomString() {
        String randomFriendCode = "";
        String model = "0123456789";
        char[] m = model.toCharArray();
        for (int i = 0; i < 10; i++) {
            char c = m[(int) (Math.random() * 10)];//取一个0到9的随机整数
            randomFriendCode = randomFriendCode + c;
        }
        return randomFriendCode;
    }

    //生成steamID
    public String setSteamID() {
        steamID = getRandomString();//生成一个10位的steamID
        //steamID唯一且首字符不为0
        if (!steamIDIsExit(steamID) && !steamID.startsWith("0")) {
            return steamID;
        } else {
            return setSteamID();
        }
    }

    //判断生成的steamID是否存在
    public boolean steamIDIsExit(String steamID) {
        if (UserDao.queryUserBySteamID(steamID) != null) {
            return true;
        }
        return false;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSteamID() {
        return steamID;
    }

    public String getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(String onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public String toString() {
        return "steamAccount:" + account + "  " +
                "password:" + passWord + "  " +
                "userName:" + userName + "  " +
                "steamID:" + steamID + "  " +
                "createTime:" + createTime;
    }
}
