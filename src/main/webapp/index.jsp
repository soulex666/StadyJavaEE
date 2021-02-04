<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="/add" method="post">
    <label>Name: </label>
    <input type="text" name="item_name">
    <label>Price: </label>
    <input type="text" name="item_price">
    <label>Amount: </label>
    <input type="text" name="item_amount">
    <button>Create item</button>
</form>

</body>
</html>