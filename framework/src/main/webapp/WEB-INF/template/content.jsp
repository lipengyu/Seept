<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<html>
<head>
    <title><sitemesh:title/></title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
    <meta http-equiv="Cache-Control" content="no-store" />
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="Expires" content="0" />

    <!-- 引入样式文件 -->
    <link href="${ctx}/tools/bootstrap/3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
    <link href="${ctx}/tools/jquery-validation/1.11.1/validate.css" type="text/css" rel="stylesheet" />
    <link href="${ctx}/tools/styles/default/content.css" type="text/css" rel="stylesheet" />

    <!-- 引入脚本文件 -->
    <script src="${ctx}/tools/jquery/jquery-1.9.1.min.js" type="text/javascript"></script>
    <script src="${ctx}/tools/jquery-validation/1.11.1/jquery.validate.min.js" type="text/javascript"></script>
    <script src="${ctx}/tools/jquery-validation/1.11.1/messages_bs_zh.js" type="text/javascript"></script>

    <sitemesh:head/>
</head>
<body>
   <%@ include file="/WEB-INF/template/header.jsp"%>
      <sitemesh:body/>
   <%@ include file="/WEB-INF/template/footer.jsp"%>
</body>
</html>