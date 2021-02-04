<%@ page import="java.util.List" %>
<%@ page import="com.andreev.StadyJavaEE.entity.Item" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="vendor/head.jsp"%>
</head>
<body>
<%@include file="vendor/navbar.jsp" %>
<div class="container">
    <div class="row mt-5">
        <div class="col-sm-12">
            <%
                Item item = (Item) request.getAttribute("item");
                if (item != null) {
            %>
            <div class="jumbotron">
                <h1 class="display-4">
                    <%=item.getName()%>
                </h1>
                <p class="lead">
                    Price: <%=item.getPrice()%> RU
                </p>
                <hr class="my-4">
                <p>
                    Amount: <%=item.getAmount()%> items
                </p>
                <p class="lead">
                    <a class="btn btn-outline-primary" href="#" role="button">Edit</a>
                </p>
            </div>
            <%
                }
            %>
        </div>
    </div>
</div>


</body>
</html>
