<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 4/9/2021
  Time: 10:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <style>
        li {
            list-style-type: none;
            text-align: center
        }

        body {
            background: white;
        }

        h3 {
            text-align: center;
        }

        p {
            text-align: center;
        }

        a {
            text-decoration: none;
            color: white;
            text-align: center;
        }

        header {
            display: block;
            margin-bottom: 20px;
        }

        footer {
            text-decoration-color: white;
        }

        fixed {
            position: fixed;
            bottom: 0;
            right: 0;
            width: 300px;
            border: 3px solid #73AD21;
        }
    </style>
</head>
<body>
<header>
    <div class="container-fluid">
        <form class="d-flex col-sm-4" style="margin-left: auto; margin-top: 10px; margin-bottom: 10px">
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success" type="submit"
                    style=" background: aliceblue;margin-right: 10px; color: black">Search
            </button>
        </form>
    </div>
    <nav class="container-fluid" style="background:#ff743c; margin: auto; ">
        <ul class="" style="margin: auto">
            <div class="row">
                <li class="nav-item col-sm-4 col-lg-2">
                    <a class="nav-link active" aria-current="page" style="color: white" href="/iphone11">Iphone 12</a>
                </li>
                <li class="nav-item col-sm-4 col-lg-2">
                    <a class="nav-link active " aria-current="page" style="color: white" href="/iphone11">Iphone 11</a>
                </li>
                <li class="nav-item col-sm-4 col-lg-2">
                    <a class="nav-link active" aria-current="page" style="color: white" href="/iphoneX">Iphone X</a>
                </li>
                <li class="nav-item col-sm-4 col-lg-2">
                    <a class="nav-link active" aria-current="page" style="color: white" href="/iphone8">Iphone 8</a>
                </li>
                <li class="nav-item col-sm-4 col-lg-2">
                    <a class="nav-link active" aria-current="page" style="color: white" href="/iphone7">Iphone 7</a>
                </li>
                <li class="nav-item col-sm-4 col-lg-2">
                    <a class="nav-link active" aria-current="page" style="color: white" href="/iphone6">Iphone 6</a>
                </li>
            </div>
        </ul>
    </nav>
</header>
    <form action="/product?action=create" method="post">
        <div style="align-content: center">
            <label for="typeID">Type ID </label>
            <input type="text" name="typeId" placeholder=" type Id" id="typeID"><br>
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
        crossorigin="anonymous"></script>
</body>
</html>