<%--
  Created by IntelliJ IDEA.
  User: YING
  Date: 2020/8/18
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>创建账户</title>
</head>
<body>
<div>
    <h2>创建账户</h2>
    <br>
    <form action="registerServlet" method="POST"id="registerForm" style="display: block;">
        <div>
            <div>SteamAccount</div>
            <input type="text" name="account" value="">
            <div style="color: red">${requestScope.UserExit}</div>
        </div>
        <div>
            <div>password</div>
            <%--autocomplete 属性规定输入字段是否应该启用自动完成功能。--%>
            <input type="password" name="passWord" autocomplete="off">
        </div>
        <div>
            <div>确认密码</div>
            <%--autocomplete 属性规定输入字段是否应该启用自动完成功能。--%>
            <input type="password" name="confirmPassWord" autocomplete="off">
        </div>
        <input type="submit" value="注册" onsubmit="ConfirmPassword">
    </form>
</div>
</body>

<script>//html会直接执行script，防止延迟过高，所以放在最后，而有些script会预加载，所以会放在前面
function ConfirmPassword() {
    if (registerForm.password.value==registerForm.confirmPassWord.value) {
        alert("密码一样");
    }
    if (registerForm.password.value!=registerForm.confirmPassWord.value) {
        alert("确认密码不一致，请重新输入");
    }
}
</script>

</html>
