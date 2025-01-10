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


    <div class="container">
        <div style="width: 1000px;">
            <div class="card-body">
               <div class="form-group">
                    <label for="board_writer_name">글쓴이</label>
                    <input type="text" value="${readContent.content_writer_name}" disabled="disabled"
                    class="form-control" id="board_writer_name" name="board_writer_name"/>
               </div>

               <div class="form-group">
                   <label for="board_date">작성날짜</label>
                   <input type="text" value="${readContent.content_date}" disabled="disabled"
                   class="form-control" id="board_date" name="board_date"/>
              </div>

              <div class="form-group">
                 <label for="board_subject">제목</label>
                 <input type="text" value="${readContent.content_subject}" disabled="disabled"
                 class="form-control" id="board_subject" name="board_subject"/>
              </div>

              <div class="form-group">
                   <label for="board_content">내용</label>
                   <textarea disabled="disabled" class="form-control" id="board_content" name="board_content"/>
                   ${readContent.content_text}</textarea>
              </div>

              <div class="form-group">
                <div class="text-right">
                    <a class="btn btn-primary" href="${root}board/main?board_info_idx=${board_info_idx}&page=${page}">목록</a>

                <!-- 로그인 한 사람이 본인글을 쓰고 제목 클릭하면 목록,수정, 삭제 가 다 뜨지만 아닌경우는 목록만뜸 -->
                    <c:if test="${loginBean.user_idx == readContent.content_writer_idx}">
                        <a class="btn btn-info" href="${root}board/modify?board_info_idx=${board_info_idx}&content_idx=${content_idx}&page=${page}">수정</a>
                        <a class="btn btn-danger" href="${root}boar/delete?board_info_idx=${board_info_idx}&content_idx=${content_idx}&page=${page}">삭제</a>
                    </c:if>

                </div>
              </div>
            </div>
        </div>
    </div>


    <c:import url="/WEB-INF/views/include/bottom_menu.jsp"/>


</body>
</html>