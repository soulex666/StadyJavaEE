<%@ page import="com.andreev.StadyJavaEE.entity.Item" %>
<%@ page import="com.andreev.StadyJavaEE.entity.Country" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Edit Item</title>
    <%@include file="vendor/head.jsp" %>
</head>
<body>
<%@include file="vendor/navbar.jsp" %>
<div class="container">
    <div class="row mt-5">
        <div class="col-sm-6 offset-3">
            <%
                Item item = (Item) request.getAttribute("item");
                if (item != null) {
            %>
            <%
                String success = request.getParameter("success");
                if (success != null) {

            %>
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                Item saved successfully!
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <%
                }
            %>
            <%
                String error = request.getParameter("error");
                if (error != null) {

            %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                Something went wrong!!!
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <%
                }
            %>
            <form action="/edit" method="post">
                <input type="hidden" name="id" value="<%=item.getId()%>">
                <div class="form-group">
                    <label>Name: </label>
                    <input type="text" name="name" class="form-control" value="<%=item.getName()%>">
                </div>
                <div class="form-group">
                    <label>Price: </label>
                    <input type="number" name="price" class="form-control" value="<%=item.getPrice()%>">
                </div>
                <div class="form-group">
                    <label>Amount: </label>
                    <input type="number" name="amount" class="form-control" value="<%=item.getAmount()%>">
                </div>
                <div class="form-group">
                    <label>Manufacturer: </label>
                    <select class="form-control" name="manufacturer_id">
                        <%
                            List<Country> countries = (List<Country>) request.getAttribute("countries");
                            if (countries != null) {
                                for(Country c: countries) {
                        %>
                        <option value="<%=c.getId()%>" <% if (c.getId() == item.getManufacturer().getId()) {out.print("selected");}%>>
                            <%=c.getName() + " / " + c.getShortName()%>
                        </option>
                        <%
                                }
                            }
                        %>
                    </select>
                </div>
                <div class="form-group">
                    <button class="btn btn-outline-primary">Save Item</button>
                    <button type="button" class="btn btn-outline-danger float-right" data-toggle="modal" data-target="#staticBackdrop">
                        Delete Item
                    </button>
                </div>
            </form>
            <div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1"
                 aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="/delete" method="post">
                            <input type="hidden" name="id" value="<%=item.getId()%>">
                            <div class="modal-header">
                                <h5 class="modal-title" id="staticBackdropLabel">Confirm Delete Process</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                Are you sure?
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
                                <button type="submit" class="btn btn-danger">Accept</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <%
                }
            %>
        </div>
    </div>
</div>


</body>
</html>
