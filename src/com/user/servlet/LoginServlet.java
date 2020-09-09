package com.user.servlet;

import com.user.entity.User;
import com.user.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String password = req.getParameter("passWord");
        User user = new User(account, password);
        if (UserService.Login(user)){
            resp.sendRedirect("main.jsp");
        }else {
            req.setAttribute("UserError","用户名或密码错误，请重新输入");
            req.getRequestDispatcher("Login.jsp").forward(req,resp);
        }

    }
}
