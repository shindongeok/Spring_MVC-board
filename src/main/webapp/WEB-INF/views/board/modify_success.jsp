<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}/"/>
<script>
    alert("수정 완료!!")
    location.href='${root}board/read?board_info_idx=${modifyBean.content_board_idx}&content_idx=${modifyBean.content_idx}&page=${page}'
</script>