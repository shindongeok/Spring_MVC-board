<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}/"/>
<script>
    alert("작성 완료!!")
    //필요한 값을 가지고 넘어간다!!(content_board_idx / content_idx / page)
    location.href="${root}board/read?board_info_idx=${writeBean.content_board_idx}&content_idx=${writeBean.content_idx}&page=1"
</script>