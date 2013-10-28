<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div id="header">
    <div id="title">
        <h1>
            Seept开发平台<small>--Nutch爬虫管理</small>
            <shiro:user>
                你好 , <shiro:principal property="loginName" />
            </shiro:user>
        </h1>
    </div>
</div>