<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: Dell--%>
<%--  Date: 4/9/2021--%>
<%--  Time: 10:36 AM--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h3 align="center">Product Manager</h3>--%>
<%--<a href="/Admin/MainManager.jsp">Back</a>--%>
<%--<table border="1px solid" align="center" style="text-align: center">--%>
<%--    <tr>--%>
<%--        <td>ProductID</td>--%>
<%--        <td>TypeID</td>--%>
<%--        <td>Color</td>--%>
<%--        <td>Memory</td>--%>
<%--        <td>Price</td>--%>
<%--        <td>Quantity</td>--%>
<%--        <td>Describe</td>--%>
<%--    </tr>--%>
<%--    <c:forEach var="product" items="${requestScope['products']}">--%>
<%--        <tr>--%>
<%--            <td><c:out value="${product.productId}"></c:out></td>--%>
<%--            <td><c:out value="${product.typeId}"></c:out></td>--%>
<%--            <td><c:out value="${product.color}"></c:out></td>--%>
<%--            <td><c:out value="${product.memory}"></c:out></td>--%>
<%--            <td><c:out value="${product.price}"></c:out></td>--%>
<%--            <td><c:out value="${product.quantity}"></c:out></td>--%>
<%--            <td><c:out value="${product.describeProduct}"></c:out></td>--%>

<%--            <td><a href="/product?action=edit&id=${product.productId}">Edit</a></td>--%>
<%--            <td><a href="/product?action=delete&id=${product.productId}">Delete</a></td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--    <tr>--%>
<%--        <td colspan="9"><a href="/product?action=create">Add</a>--%>
<%--    </tr>--%>
<%--    </td> <td colspan="9"><a href="/product?action=menu">menu</a></td>--%>
<%--</table>--%>
<%--</body>--%>
<%--</html>--%>





<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
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
            color: blue;
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
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
    </style>
</head>
<body>
<header>
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-2 col-6 btn btn-outline-success" style="margin: auto; text-align: center">
                <a style="margin-left: auto; margin-top: 10px; margin-bottom: 10px"
                   onclick="window.location.href='/customer?action=showMain'" method="post">Trang chu??</a>
            </div>
            <div class="col-lg-6 col-12">
                <form class="d-flex col-sm-4" style="margin-left: auto; margin-top: 10px; margin-bottom: 10px"
                      action="product?action=searchMenu" method="post">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search"
                           name="search">
                    <button class="btn btn-outline-success" type="submit"
                            style=" background: aliceblue;margin-right: 10px; color: black">Search
                    </button>
                </form>
            </div>
            <c:if test="${sessionScope.acc ==null}">
                <div class="col-lg-2 col-6 btn btn-outline-success" style="margin: auto; text-align: center">
                    <a style="margin-left: auto; margin-top: 10px; margin-bottom: 10px"
                       onclick="window.location.href='/customer?action=loginForm'" method="post">????ng nh????p</a>
                </div>
            </c:if>
            <c:if test="${sessionScope.acc !=null}">
                <div class="col-lg-2 col-6 btn" style="margin: auto; text-align: center">
                    Hello ${sessionScope.acc.account  }</div>
                <div class="col-lg-1 col-3 btn btn-outline-success" style="margin: auto; text-align: center">
                    <a style="margin-rigt: auto; margin-top: 10px; margin-bottom: 10px"
                       onclick="window.location.href='/customer?action=logOut'">????ng xu????t</a>
                </div>
            </c:if>
        </div>

    </div>
    <nav class="container-fluid" style="background:#ff743c; margin: auto; ">
        <ul class="" style="margin: auto">
            <div class="row">
                <li class="nav-item col-sm-4 col-lg-2">
                    <a class="nav-link active" aria-current="page" style="color: white"></a>
                </li>
                <li class="nav-item col-sm-4 col-lg-2">
                    <a class="nav-link active " aria-current="page" style="color: white"></a>
                </li>
                <li class="nav-item col-sm-4 col-lg-2">
                    <a class="nav-link active" aria-current="page" style="color: white" ></a>
                </li>
                <li class="nav-item col-sm-4 col-lg-2">
                    <a class="nav-link active" aria-current="page" style="color: white"></a>
                </li>
                <li class="nav-item col-sm-4 col-lg-2">
                    <a class="nav-link active" aria-current="page" style="color: white" ></a>
                </li>
                <li class="nav-item col-sm-4 col-lg-2">
                    <a class="nav-link active" aria-current="page" style="color: white" ></a>
                </li>
            </div>
        </ul>
    </nav>


</header>

<div class="container">
</div>
<div class="row" style="margin-left: 60px">
    <h1 align="center">Product Manager</h1>
    <table>
        <tr>
            <td>ProductID</td>
            <td>TypeID</td>
            <td>Color</td>
            <td>Memory</td>
            <td>Price</td>
            <td>Quantity</td>
            <td>Describe</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
        <c:forEach var="product" items="${requestScope['products']}">
            <tr>
                <td><c:out value="${product.productId}"></c:out></td>
                <td><c:out value="${product.typeId}"></c:out></td>
                <td><c:out value="${product.color}"></c:out></td>
                <td><c:out value="${product.memory}"></c:out></td>
                <td><c:out value="${product.price}"></c:out></td>
                <td><c:out value="${product.quantity}"></c:out></td>
                <td><c:out value="${product.describeProduct}"></c:out></td>

                <td><a href="/product?action=edit&id=${product.productId}">Edit</a></td>
                <td><a href="/product?action=delete&id=${product.productId}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <a href="/product?action=create" style="text-align: center"> Add</a>
    <a href="/Admin/MainManager.jsp">Back</a>
</div>
</div>
<!--end context-->
<footer style="background: black">
    <div class="footer-top" style="margin-top:20px">
        <div class="row">
            <div class="col-lg-6 col-12" style="color: white; margin: auto; padding-top: 20px ">
                <h3>Showroom 3TH mobile</h3>
                <p>C?? s??? 1: 69 ???????ng L??ng -&nbsp;Q.?????ng ??a -&nbsp;H?? N???i</p>
                <p>C?? s??? 2: 60 Ph?? Ki???u - Q.B???c T??? Li??m - H?? N???i</p>
                <p>C?? s??? 3: 24 Thanh Tr?? - H?? N???i</p>
                <p>Hotline mua h??ng:&nbsp;02466819779 - 0855203333</p>
                <p>Hotline b???o h??nh:&nbsp;0849056666 - 0824853333</p>
                <p><span style="color:#ffffff;"></span>Gi??? l??m vi???c: 8h30-22h t???t c??? c??c
                    ng??y trong tu???n (c??? ng??y l???)</p>
            </div>
            <div class="col-lg-6 col-12" style="color: white; padding-top: 20px ">
                <div class="list_menu_ft mbl">
                    <ul class="menu-bottom row-item" style="color: white">
                        <li class="level0 first-item ">
                            <div class="title-menu-ft" style="margin: auto">
                                <h3>H??? tr??? kh??ch h??ng</h3>
                            </div>
                            <p><a target='' href='https://onewaymobile.vn/chinh-sach-mua-hang-c2.html'>
                                Ch??nh s??ch mua h??ng </a>
                            </p></li>
                        <li class='  level0 menu-item '>
                            <p><a target='' href='https://onewaymobile.vn/chinh-sach-bao-hanh-c3.html'>
                                Ch??nh s??ch b???o h??nh </a>
                            </p></li>
                        <li class='  level0 menu-item '>
                            <p><a target=''
                                  href='https://onewaymobile.vn/chinh-sach-van-chuyen-c4.html'>
                                Ch??nh s??ch v???n chuy???n </a>
                            </p></li>
                        <li class='  level0 menu-item '>
                            <p><a target=''
                                  href='https://onewaymobile.vn/phuong-thuc-thanh-toan-c6.html'>
                                Ph????ng th???c thanh to??n </a></p>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
        crossorigin="anonymous"></script>
</body>
</html>