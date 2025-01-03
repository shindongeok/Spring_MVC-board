<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
</head>
<body>
<!-- 적은 값이 Data클래스의 어노테이션 조건에 맞아야함 @size @max -->
    <form action="test1_proc" method="post">
        num1 : <input type="text" name="num1"><br>  <!-- 바인딩 대상객체 (ata 의 필드에 매핑) -->
        <spring:hasBindErrors name="data"> <!-- 에러확인 후 표시 => errors에 담겨져 있음 -->
            <c:if test="${errors.hasFieldErrors('num1')}"> <!-- num1필드에 에러가 있는지 확인 -->
                <p  style="color:red;">${errors.getFieldError('num1').defaultMessage}</p> <br> <!-- 기분 에러메세지 출력 -->
            </c:if>
        </spring:hasBindErrors>

        num2 : <input type="text" name="num2"><br>  <!-- 바인딩 대상객체 (ata 의 필드에 매핑) -->
        <spring:hasBindErrors name="data"> <!-- 에러확인 후 표시 -->
            <c:if test="${errors.hasFieldErrors('num2')}"> <!-- num1필드에 에러가 있는지 확인 -->
                ${errors.getFieldError('num2').defaultMessage} <br> <!-- 기분 에러메세지 출력 -->
            </c:if>
        </spring:hasBindErrors>

        <button type="submit">확인</button>
    </form>
</body>
</html>

