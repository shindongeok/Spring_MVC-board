<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
</head>
<body>

    <form:form action="test_proc" method="post" modelAttribute="data">

        <div class="box_1">
            <div class="box_1-1 userName"><label for="userName">이름</label></div>
            <div class="box_1-">＊<form:input type="text" path="userName"/>
                <br><form:errors path="userName"/>
            </div>
        </div>


        <div class="box_1">
            <div class="box_1-1"><label for="rrNumber1">주민등록번호</label></div>
            <div>＊<form:input type="text" path="rrNumber1" placeholder="앞 6자리"/> - <form:input type="text" path="rrNumber2" placeholder="뒤 7자리"/>
                    <br><form:errors path="rrNumber1"/>
                        <form:errors path="rrNumber2"/>
            </div>
        </div>

        <div class="box_1">
            <div class="box_1-1"><label for="userId">아이디</label></div>
            <div>＊<form:input type="text" path="userId"/>
                        <br><form:errors path="userId"/>
            </div>
        </div>






        <form:button type="submit">체크</form:button>
    </form:form>


</body>
</html>