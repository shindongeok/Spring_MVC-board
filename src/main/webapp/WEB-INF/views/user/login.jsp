<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="root" value="${pageContext.request.contextPath}/"/>
<head>
    <title>회원가입 입니다..</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery-3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>
    <c:import url="/WEB-INF/views/include/top_menu.jsp"/>


    <div class="container">
            <div style="width: 500px;">
                <div class="card-body">
                    <form:form action="${root}user/login_pro" method="post">
                        <div class="form-group">
                            <form:label path="user_id">아이디</form:label>
                            <form:input type="text" path="user_id" class="form-control"/>
                            <form:errors path="user_id" style='color:red'/>
                        </div>
                        <div class="form-group">
                            <form:label path="user_pw">비밀번호</form:label>
                            <form:input type="text" path="user_pw" class="form-control"/>
                            <form:errors path="user_pw" style='color:red'/>
                        </div>
                        <div class="form-group">
                            <div class="text-right">
                                <form:button class="btn btn primary">로그인</form:button>
                                <a href="${root}user/login">회원가입</a>
                            </div>
                        </div>

                    </form:form>
                </div>
            </div>
    </div>




    <c:import url="/WEB-INF/views/include/bottom_menu.jsp"/>
</body>
</html>