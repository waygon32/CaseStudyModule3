<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 4/9/2021
  Time: 10:36 AM
  To change this template use File | Settings | File Templates.
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
<form action="/product?action=edit"  method="post">
    <input type="text" name="typeId" placeholder="input typeId"><br>
    <%--    <input type="text" name="color" placeholder="input color"><br>--%>
    <%--    <input type="text" name="memory" placeholder="input  memory">--%>
    <select name="color" id="">
        <option value="Red">Red</option>
        <option value="Blue">Blue</option>
        <option value="Black">Black</option>
        <option value="White">White</option>
        <option value="Gold">Gold</option>
    </select>
    <select name="memory" id="">
        <option value="64">64G</option>
        <option value="128">128G</option>
        <option value="256">256G</option>
    </select>
    <br>
    <input type="text" name="price" placeholder="input price"><br>
    <input type="text" name="quantity" placeholder=" inputquantity"><br>
    <input type="text" name="describe" placeholder="describe"><br>
    <input  type="submit" style="align-self: center" >
    <label for="img">link img</label>
    <input type="text" name="img" id="img">
</form>
</body>
</html>

