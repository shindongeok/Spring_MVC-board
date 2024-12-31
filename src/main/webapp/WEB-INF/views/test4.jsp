<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
</head>
<body>
<form:form action="final" modelAttribute="modelBean">
    이름 : <form:input path="name"/><br><!-- path이름과 설정한 필드명이 같아야함 -->
    아이디 : <form:input path="id"/><br>
    비번 : <form:input path="pw"/><br>
    주소1 : <form:input path="adr1"/><br>
    주소2 : <form:input path="adr2"/><br>
</form:form>

${modelBean.id}
</body>
</html>