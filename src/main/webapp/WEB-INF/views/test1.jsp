<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8"%>
<head>
</head>
<body>
<!-- 객체로 저장된 필드값 가져올 때 클래스명 맨 앞글자느 소문자 -->
id : ${data.id}<br>
name : ${data.name}<br>
pw : ${data.pw}<br>
adr1 : ${data.adr1}<br>
adr2 : ${data.adr2}<br>

<form action="final" method="post">
    <input type="text" name="id" value="${data.id}"/>
    <button type="submit">check</button>
</form>
</body><br>
</html>