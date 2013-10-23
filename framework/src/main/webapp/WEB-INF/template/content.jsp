<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<html>
<head>
    <title><sitemesh:title/></title>

    <sitemesh:head/>
</head>
<body>
   <%@ include file="/WEB-INF/template/header.jsp"%>
      <sitemesh:body/>
   <%@ include file="/WEB-INF/template/footer.jsp"%>
</body>
</html>