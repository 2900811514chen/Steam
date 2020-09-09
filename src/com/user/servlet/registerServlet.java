package com.user.servlet;

import com.user.entity.User;
import com.user.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");//设置response使用的码表，控制response以UTF-8码表向浏览器写入数据
        String account = req.getParameter("account");
        String password = req.getParameter("passWord");
        User user = new User(account, password);
        //System.out.println("registerServlet用户注册："+user.toString());
        if (UserService.addUser(user)) {
            resp.sendRedirect("Login.jsp");//注册成功跳转至登录页面
        } else if (!UserService.addUser(user)) {
            req.setAttribute("UserExit", "该用户已存在，请重新注册！");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }
    }
}
