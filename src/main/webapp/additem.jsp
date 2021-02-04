<%@ page import="java.util.List" %>
<%@ page import="com.andreev.StadyJavaEE.entity.Item" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="vendor/head.jsp" %>
</head>
<body>
<%@include file="vendor/navbar.jsp" %>
<div class="container">
    <div class="row mt-5">
        <div class="col-sm-6 offset-3">
            <%
                String s = request.getParameter("success");
                if(s != null) {

            %>
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                Item added successfully
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <%
                }
            %>



            <form action="additem" method="post">
                <div class="form-group">
                    <label>Name: </label>
                    <input type="text" name="name" class="form-control">
                </div>
                <div class="form-group">
                    <label>Price: </label>
                    <input type="number" name="price" class="form-control">
                </div>
                <div class="form-group">
                    <label>Amount: </label>
                    <input type="number" name="amount" class="form-control">
                </div>
                <div class="form-group">
                    <button class="btn btn-outline-primary">Add Item</button>
                </div>
            </form>
        </div>
    </div>
</div>


</body>
</html>
