<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="root" value="${pageContext.request.contextPath}/"/>

<head>
    <title>게시판 메인 페이지입니다.</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>
    <c:import url="/WEB-INF/views/include/top_menu.jsp"/>

    <!-- 게시판 이름 출력 -->
    <div class="container">
        <div class="card-body">
            <h3 class="card-title">${boardName}</h3>
            <table class="table table-dark table-striped">
                <thead>
                    <tr>
                        <th class="text-center d-md-table-cell">글번호</th>
                        <th class="text-center d-md-table-cell">제목</th>
                        <th class="text-center d-md-table-cell">글쓴이</th>
                        <th class="text-center d-md-table-cell">작성날짜</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="obj" items="${contentList}">
                        <tr>
                            <td class="text-center d-md-table-cell">${obj.content_idx}</td>
                            <td class="text-center d-md-table-cell">
                                <a href="${root}board/read?board_info_idx=${board_info_idx}&content_idx=${obj.content_idx}&page=${page}">
                                    ${obj.content_subject}
                                </a>
                            </td>
                            <td class="text-center d-md-table-cell">${obj.content_writer_name}</td>
                            <td class="text-center d-md-table-cell">${obj.content_date}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>


    <!-- 페이지네이션 -->
        <div class="d-none d-md-block">
           <ul class="pagination justify-content-center">
              <c:choose>
                 <c:when test="${pBean.prePage <= 0 }">
                    <li class="page-item disabled"><a href="#"
                       class="page-link">이전</a></li>
                 </c:when>
                 <c:otherwise>
                    <li class="page-item"><a
                       href="${root }board/main?board_info_idx=${board_info_idx}&page=${pBean.prePage}"
                       class="page-link">이전</a></li>
                 </c:otherwise>
              </c:choose>


              <c:forEach var='idx' begin="${pBean.min }" end='${pBean.max }'>
                 <c:choose>
                    <c:when test="${idx == pBean.currentPage }">
                       <li class="page-item active"><a
                          href="${root }board/main?board_info_idx=${board_info_idx}&page=${idx}"
                          class="page-link">${idx }</a></li>
                    </c:when>
                    <c:otherwise>
                       <li class="page-item"><a
                          href="${root }board/main?board_info_idx=${board_info_idx}&page=${idx}"
                          class="page-link">${idx }</a></li>
                    </c:otherwise>
                 </c:choose>

              </c:forEach>

              <c:choose>
                 <c:when test="${pBean.max >= pBean.pageCnt }">
                    <li class="page-item disabled"><a href="#"
                       class="page-link">다음</a></li>
                 </c:when>
                 <c:otherwise>
                    <li class="page-item"><a
                       href="${root }board/main?board_info_idx=${board_info_idx}&page=${pBean.nextPage}"
                       class="page-link">다음</a></li>
                 </c:otherwise>
              </c:choose>

           </ul>

           <div class="text-right">
               <a href="${root}board/write?board_info_idx=${board_info_idx}" class="btn btn-primary">글쓰기</a>
           </div>
       </div>
    </div>

    <c:import url="/WEB-INF/views/include/bottom_menu.jsp"/>
</body>
</html>