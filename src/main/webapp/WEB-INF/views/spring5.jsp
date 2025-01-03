<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
</head>
<body>

${sbean.str1}
${sbean.str2}
${sbean2.str1}
${sbean2.str2}

${requestScope.sbean.str1}
${requestScope.sbean.str2}

</body>
</html>