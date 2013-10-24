<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>登陆界面</title>
</head>
<body>
   <form id="loginForm" name="loginForm" method="post" action="${ctx}/web/login">
       <label>用户名:</label>
       <div>
           <input id="username" name="username" type="text" value="">
       </div>

       <label>密码:</label>
       <div>
           <input id="password" name="password" type="text">
       </div>

       <div class="control-group">
           <div class="controls">
               <input id="submit_btn" class="btn btn-primary" type="submit" value="登录"/>
               <a class="btn" href="${ctx}/register">注册</a>
           </div>
       </div>
   </form>
</body>
</html>