<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Sessions</title>
    <%@include file="vendor/head.jsp" %>
</head>
<body>
<%@include file="vendor/navbar.jsp" %>
<div class="container">
    <div class="row mt-5">
        <div class="col-sm-12">
            <h1 class="text-center">
                <%
                    String sessionValue = (String) request.getAttribute("text");
                    out.print(sessionValue);
                %>
            </h1>
        </div>
    </div>

    <div class="row mt-5">
        <div class="col-sm-6 offset-3">

            <form action="/setsession" method="post">
                <div class="form-group">
                    <label>Session value: </label>
                    <input type="text" name="session_value" class="form-control">
                </div>
                <button class="btn btn-outline-primary">Set session</button>

            </form>
            <form action="/deletesession" method="post">
                <button class="btn btn-outline-danger">Delete session</button>
            </form>
        </div>
    </div>
</div>


</body>
</html>
