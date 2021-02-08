<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Cookies</title>
    <%@include file="vendor/head.jsp" %>
</head>
<body>
<%@include file="vendor/navbar.jsp" %>
<div class="container">
    <div class="row mt-5">
        <div class="col-sm-12">
            <h1 class="text-center">
                <%
                    String cookieValue = (String) request.getAttribute("cookieValue");
                    out.print("Cookie data is: " + cookieValue);
                %>
            </h1>
        </div>
    </div>

    <div class="row mt-5">
        <div class="col-sm-6 offset-3">

            <form action="/setcookie" method="post">
                <div class="form-group">
                    <label>Cookie value: </label>
                    <input type="text" name="cookie_value" class="form-control">
                </div>
                <button class="btn btn-outline-primary">Set cookie</button>

            </form>
            <form action="/deletecookie" method="post">
                <button class="btn btn-outline-danger">Delete cookie</button>
            </form>
        </div>
    </div>
</div>


</body>
</html>
