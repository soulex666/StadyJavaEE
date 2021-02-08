<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Home</title>
    <%@include file="vendor/head.jsp" %>
</head>
<body>
<%@include file="vendor/navbar.jsp" %>
<div class="container">
    <div class="row mt-5">
        <div class="col-sm-12">
            <h2>
                This is profile of <%=(ONLINE ? currentUser.getFullName() : "no user")%>
            </h2>
        </div>
    </div>
</div>


</body>
</html>
