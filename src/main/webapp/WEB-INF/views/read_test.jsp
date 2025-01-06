<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
</head>
<body>

<c:forEach var="obj" items="${li}">
    ${obj.num1}<br>
    ${obj.num2}<br>
    ${obj.num3}<br>
</c:forEach>









</body>
</html>