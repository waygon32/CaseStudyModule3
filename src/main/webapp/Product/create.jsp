<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 4/9/2021
  Time: 10:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/product?action=create" method="post">
    <div style="align-content: center">
        <label for="typeID">Type ID </label>
        <input type="text" name="typeId" placeholder=" type Id" id="typeID"><br>
        <%--    <input type="text" name="color" placeholder="input color"><br>--%>
        <%--    <input type="text" name="memory" placeholder="input  memory">--%>
        <label for="color">Choose Color</label>
        <select name="color" id="color">
            <option value="Red">Red</option>
            <option value="Blue">Blue</option>
            <option value="Black">Black</option>
            <option value="White">White</option>
            <option value="Gold">Gold</option>
            <br>
        </select>
        <label for="memory">Memory</label>
        <select name="memory" id="memory">
            <option value="64">64G</option>
            <option value="128">128G</option>
            <option value="256">256G</option>
        </select><br>
        <label for="price">Prices</label>
        <input type="text" name="price" id="price" placeholder=" price"><br>
        <label for="quantity">Quantity</label>
        <input type="text" name="quantity" id="quantity" placeholder=" quantity"><br>
        <label for="describe">Describe</label>
        <input type="text" name="describe" id="describe" placeholder="describe"><br>
        <label for="img">link img</label>
        <input type="text" name="img" id="img">
        <input type="submit" style="align-self: center">
    </div>
</form>
</body>
</html>
