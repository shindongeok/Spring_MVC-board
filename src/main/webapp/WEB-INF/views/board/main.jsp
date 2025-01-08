<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}/"/>
<head>
    <title>게시판메인페이지입니다.</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery-3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>
    <c:import url="/WEB-INF/views/include/top_menu.jsp"/>

    <div class="container"
      <div class="card-body">
        <h3 class="card-title">게시판</h5>
        <table class="table table-dark table-striped">
          <thead>
              <tr>
              <!-- 게시판 상판 제목 -->
                <th class="d-md-table-cell">글번호</th>
                <th class="d-md-table-cell">제목</th>
                <th class="d-md-table-cell">글쓴이</th>
                <th class="d-md-table-cell">작성날짜</th>
              </tr>
          </thead>
        </table>

        <div class="text-right">
            <a href="${root}board/write?board_info_idx=${board_info_idx}" class="btn btn-primary">글쓰기</a>
        </div>
    </div>

<!-- board_info_idx -->
${board_info_idx}
    <c:import url="/WEB-INF/views/include/bottom_menu.jsp"/>


</body>
</html>