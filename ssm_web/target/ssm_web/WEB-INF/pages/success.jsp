<%--
  Created by IntelliJ IDEA.
  User: A
  Date: 2020/5/1
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${students}" var="student">
    ${student.name}
</c:forEach>
</body>
</html>
