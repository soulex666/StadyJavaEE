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
        <div class="col-sm-6 offset-3">
            <h4 class="mb-4">
                Registration to system
            </h4>
            <%
                String success = request.getParameter("success");
                if (success != null) {

            %>
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                User created successfully!
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <%
                }
            %>

            <%
                String passError = request.getParameter("passworderror");
                if (passError != null) {

            %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                Passwords are not the same
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <%
                }
            %>

            <%
                String emailError = request.getParameter("emailerror");
                if (emailError != null) {

            %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                User exists
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <%
                }
            %>

            <form action="/toregister" method="post">
                <div class="form-group">
                    <label>E-Mail: </label>
                    <input type="email" required class="form-control" name="email">
                </div>
                <div class="form-group">
                    <label>Password: </label>
                    <input type="password" required class="form-control" name="password">
                </div>
                <div class="form-group">
                    <label>Retype password: </label>
                    <input type="password" required class="form-control" name="re_password">
                </div>
                <div class="form-group">
                    <label>Full name: </label>
                    <input type="text" required class="form-control" name="full_name">
                </div>
                <div class="form-group">
                    <button class="btn btn-outline-primary">Register</button>
                </div>
            </form>
        </div>
    </div>
</div>


</body>
</html>
