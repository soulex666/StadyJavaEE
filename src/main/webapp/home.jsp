<%@ page import="java.util.List" %>
<%@ page import="com.andreev.StadyJavaEE.entity.Item" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Title</title>
    <%@include file="vendor/head.jsp" %>
</head>
<body>
<%@include file="vendor/navbar.jsp" %>
<div class="container">
    <div class="row mt-5">
        <div class="col-sm-12">
            <table class="table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Amount</th>
                    <th>Manufacturer</th>
                    <th>Details</th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<Item> items = (List<Item>) request.getAttribute("tovary");
                    if (items != null) {
                        for (Item item : items) {
                %>
                <tr>
                    <td>
                        <%
                            out.print(item.getId());
                        %>
                    </td>
                    <td>
                        <%=item.getName()%>
                    </td>
                    <td>
                        <%=item.getPrice()%>
                    </td>
                    <td>
                        <%=item.getAmount()%>
                    </td>
                    <td>
                        <%=item.getManufacturer().getShortName()%>
                    </td>
                    <td>
                        <a href="/details?id=<%=item.getId()%>" class="btn btn-outline-primary">Details</a>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
                </tbody>

            </table>
        </div>
    </div>
</div>


</body>
</html>
