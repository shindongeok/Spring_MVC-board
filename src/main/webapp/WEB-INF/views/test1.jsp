<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
</head>
<body>

<form:form modelAttribute="data">
    1 : <form:hidden path="str1"/><br><!-- path이름과 설정한 필드명이 같아야함 -->
    2 : <form:input path="str2"/><br>
    3 : <form:password path="str3" showPassword="true" /><br> <!-- 무시 -->
    4 : <form:textarea path="str4"/><br>
    5 : <form:button disabled="true">체크</form:button>
</form:form>


</body>
</html>