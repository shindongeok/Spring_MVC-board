<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
</head>
<body>

    <form:form action="test_proc" method="post" modelAttribute="data">
        num1 : <form:input path="num1" type="text"/><br>
               <form:errors path="num1"/><br>

        num2 : <form:input path="num2" type="text"/><br>
               <form:errors path="num2"/><br>

        num3 : <form:input path="num3" type="text"/><br>
              <form:errors path="num3"/><br>

        <form:button type="submit">체크</form:button>
    </form:form>


</body>
</html>