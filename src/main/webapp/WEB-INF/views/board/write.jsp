<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="root" value="${pageContext.request.contextPath}/"/>
<head>
    <title>boardWrite입니다.</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> <!-- jQuery를 먼저 로드!! -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>

        <c:import url="/WEB-INF/views/include/top_menu.jsp"/>

         <div class="container">
            <div style="width: 1000px;">
                <div class="card-body">
                    <form:form action="${root}board/write_pro" method="post" modelAttribute="writeBean">
                        <!-- 값을 같이 넘겨주고싶어서(넣어 놔야지 서버에서 board_idx 값을 확인가능) -->
                        <form:hidden path="content_board_idx"/>
                        <div class="form-group">
                            <form:label path="content_subject">제목</form:label>
                            <form:input type="text" path="content_subject" class="form-control"/>
                            <form:errors path="content_subject" style='color:red'/>
                        </div>



                        <div class="form-group">
                            <form:label path="content_text">내용</form:label>
                            <form:textarea  path="content_text" class="form-control" rows="10"/>
                            <form:errors path="content_text" style='color:red'/>
                        </div>



                        <div class="form=group">
                            <div class="text-right">
                                <button type="submit" class="btn btn-outline-success">작성하기</button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
         </div>


        <c:import url="/WEB-INF/views/include/bottom_menu.jsp"/>

</body>
</html>