<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="root" value="${pageContext.request.contextPath}/"/>
<head>
    <title>회원가입 입니다..</title>
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
                <form:form action="${root}user/join_pro" method="post" modelAttribute="joinBean">
                    <!-- 값을 같이 넘겨주고싶어서(넣어 놔야지 서버에서 아이디가 있는지 없는지 확인가능) -->
                    <form:hidden path="existId"/>
                    <div class="form-group">
                        <form:label path="user_name">이름</form:label>
                        <form:input type="text" path="user_name" class="form-control"/>
                        <form:errors path="user_name" style='color:red'/>
                    </div>

                    <div class="form-group">
                        <form:label path="user_id">아이디</form:label>
                            <div class="input-group-append mb-3">
                                <form:input type="text" path="user_id" class="form-control" onkeypress="resetUser()"/>
                                <!-- onkeypress : 키보드에 값을 넣으면 false?? -->
                                <button class="btn btn-outline-secondary" type="button" id="button-addon2" onclick="chexistId()">중복확인</button>
                            </div>
                                <form:errors path="user_id" style='color:red'/>
                    </div>

                    <div class="form-group">
                        <form:label path="user_pw">비밀번호</form:label>
                        <form:password  path="user_pw" class="form-control"/>
                        <form:errors path="user_pw" style='color:red'/>
                    </div>

                    <div class="form-group">
                        <form:label path="user_pw2">비밀번호 확인</form:label>
                        <form:password  path="user_pw2" class="form-control"/>
                        <form:errors path="user_pw2" style='color:red'/>
                    </div>

                    <div class="form=group">
                        <div class="text-right">
                            <button type="submit" class="btn btn-outline-success">회원가입</button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
     </div>


    <c:import url="/WEB-INF/views/include/bottom_menu.jsp"/>

<!-- 아이디 중복확인 ajax를 사용해서 부분변경 가능 -->
    <script>
        // 아이디 중복확인 AJAX 함수
            function chexistId() {
                let user_id = $("#user_id").val(); // 입력한 아이디 가져옴

                if (user_id.length == 0) {
                    alert('아이디를 입력해주세요.');
                    return;
                }

                $.ajax({
                    url: '${root}/user/chexistId/' + user_id,
                    type: 'get',
                    dataType: 'text',
                    success: function(result) {
                        if (result.trim() == 'true') { // 서버에서 true를 반환하는지 확인
                            alert('사용할 수 있는 아이디 입니다 :)');
                            $('#existId').val('true'); // 아이디 중복 확인을 위한 hidden 값 설정
                        } else {
                            alert('사용할 수 없는 아이디입니다!!!');
                            $('#existId').val('false'); // 사용 불가능한 아이디라면 false로 설정
                        }
                    }
                });
            }

            // 키 입력 시 아이디 중복 확인용 hidden 필드 값 리셋
            function resetUser() {
                $("#existId").val('false');
            }
    </script>
</body>
</html>