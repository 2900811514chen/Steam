<%--
  Created by IntelliJ IDEA.
  User: YING
  Date: 2020/8/16
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>登录</title>
</head>

<body>

<%--登录--%>
<div>
  <h2>登录</h2>
  <p>到现有的 Steam 帐户</p>
  <br>
  <div style="color: red">${requestScope.UserError}</div><%--EL表达式--%>
  <form action="LoginServlet" method="POST" id="LoginForm" style="display: block;">
    <div>
      <div>Steam 帐户名称</div>
      <input type="text" name="steamAccount" value="">
    </div>
    <div>
      <div>密码</div>
      <%--autocomplete 属性规定输入字段是否应该启用自动完成功能。--%>
      <input type="password" name="passWord" autocomplete="off">
    </div>
    <div>
      <div title="如果您选中此选项，我们会在今后 30 天内自动为您登录，除非您在帐户菜单中选中“注销”。此功能只适用于启用 Steam 令牌的帐户。">
        <input type="checkbox" name="remember_login" id="remember_login">
        <label for="remember_login">在这台电脑上记住我</label>
      </div>
    </div>
    <input type="submit" value="登录">
  </form>
</div>

<%--注册--%>
<div class="loginbox_right">
  <div class="loginbox_content">
    <h2>创建</h2>
    <p>一个新的免费帐户</p>
    <br>
    <p>
      欢迎免费加入及轻松使用。继续创建 Steam 帐户并获取 Steam - 适合 PC 和 Mac 玩家的前沿数字解决方案。						</p>
    <div class="nonresponsive_hidden">
      <br>
      <p>
        <a target="_top" href="https://store.steampowered.com/about">了解更多 Steam 的相关信息</a>
      </p>
    </div>
  </div>

  <a target="_top" href="register.jsp">
    <span>加入 Steam</span>
  </a>
</div>
</body>
</html>
