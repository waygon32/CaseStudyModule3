<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: Dell--%>
<%--  Date: 4/13/2021--%>
<%--  Time: 5:11 PM--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Manager</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<table align="center" style="width: 500px ; text-align:center ;  height: 300px " border="1px solid ">--%>
<%--    <tr>--%>
<%--        <td>Funtion</td>--%>
<%--        <td>Describe</td>--%>
<%--        <td>GOOO</td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td>CRUD</td>--%>
<%--        <td>CRUD cung cấp những tính năng như thêm , sửa , xóa sản phẩm hệ thống</td>--%>
<%--        <td><a href="/product">Go</a></td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td>Quản lý đơn hàng</td>--%>
<%--        <td>Quản lí thông tin đơn hàng , trạng thái đơn hàng , thông tin về khách hàng , sản phẩm </td>--%>
<%--        <td><a href="/product?action=orderManagement">Go</a></td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td>Thống kê </td>--%>
<%--        <td>Thống kê tổng doanh thu, top 5 sản phẩm bán chạy nhất</td>--%>
<%--        <td><a href="/product?action=statistics">Go</a></td>--%>
<%--    </tr>--%>
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
                   onclick="window.location.href='/customer?action=showMain'" method="post">Trang chủ</a>
            </div>
<%--            <div class="col-lg-6 col-12">--%>
<%--                <form class="d-flex col-sm-4" style="margin-left: auto; margin-top: 10px; margin-bottom: 10px"--%>
<%--                      action="product?action=searchMenu" method="post">--%>
<%--                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search"--%>
<%--                           name="search">--%>
<%--                    <button class="btn btn-outline-success" type="submit"--%>
<%--                            style=" background: aliceblue;margin-right: 10px; color: black">Search--%>
<%--                    </button>--%>
<%--                </form>--%>
<%--            </div>--%>
            <c:if test="${sessionScope.acc ==null}">
                <div class="col-lg-2 col-6 btn btn-outline-success" style="margin: auto; text-align: center">
                    <a style="margin-left: auto; margin-top: 10px; margin-bottom: 10px"
                       onclick="window.location.href='/customer?action=loginForm'" method="post">Đăng nhập</a>
                </div>
            </c:if>
            <c:if test="${sessionScope.acc !=null}">
                <div class="col-lg-2 col-6 btn" style="margin: auto; text-align: center">
                    Hello ${sessionScope.acc.account  }</div>
                <div class="col-lg-1 col-3 btn btn-outline-success" style="margin: auto; text-align: center">
                    <a style="margin-rigt: auto; margin-top: 10px; margin-bottom: 10px"
                       onclick="window.location.href='/customer?action=logOut'">Đăng xuất</a>
                </div>
            </c:if>
        </div>

    </div>
    <nav class="container-fluid" style="background:#ff743c; margin: auto; ">
        <ul class="" style="margin: auto">
            <div class="row">
                <li class="nav-item col-sm-4 col-lg-2">
                    <a class="nav-link active" aria-current="page" style="color: white" ></a>
                </li>
                <li class="nav-item col-sm-4 col-lg-2">
                    <a class="nav-link active " aria-current="page" style="color: white" ></a>
                </li>
                <li class="nav-item col-sm-4 col-lg-2">
                    <a class="nav-link active" aria-current="page" style="color: white" ></a>
                </li>
                <li class="nav-item col-sm-4 col-lg-2">
                    <a class="nav-link active" aria-current="page" style="color: white" ></a>
                </li>
                <li class="nav-item col-sm-4 col-lg-2">
                    <a class="nav-link active" aria-current="page" style="color: white" ></a>
                </li>
                <li class="nav-item col-sm-4 col-lg-2">
                    <a class="nav-link active" aria-current="page" style="color: white"></a>
                </li>
            </div>
        </ul>
    </nav>
</header>

<div class="row">
</div>

<table align="center" >
    <tr>
        <td colspan="3">
            <h1 style="text-align: center">Admin manganer</h1>
        </td>
    </tr>

    <tr>
        <td>Funtion</td>
        <td>Describe</td>
        <td></td>
    </tr>
    <tr>
        <td>Product Management</td>
        <td>Add,edit,delete product</td>
        <td><a href="/product">Go</a></td>
    </tr>
    <tr>
        <td>Order Management</td>
        <td>Order information, Order Status </td>
        <td><a href="/product?action=orderManagement">Go</a></td>
    </tr>
    <tr>
        <td>Statistic</td>
        <td>Top5 product selled</td>
        <td><a href="/product?action=statistics">Go</a></td>
    </tr>
</table>


</div>
<!--end context-->
<footer style="background: black">
    <div class="footer-top" style="margin-top:20px">
        <div class="row">
            <div class="col-lg-6 col-12" style="color: white; margin: auto; padding-top: 20px ">
                <h3>Showroom 3TH mobile</h3>
                <p>Cơ sở 1: 69 đường Láng -&nbsp;Q.Đống Đa -&nbsp;Hà Nội</p>
                <p>Cơ sở 2: 60 Phú Kiều - Q.Bắc Từ Liêm - Hà Nội</p>
                <p>Cơ sở 3: 24 Thanh Trì - Hà Nội</p>
                <p>Hotline mua hàng:&nbsp;02466819779 - 0855203333</p>
                <p>Hotline bảo hành:&nbsp;0849056666 - 0824853333</p>
                <p><span style="color:#ffffff;"></span>Giờ làm việc: 8h30-22h tất cả các
                    ngày trong tuần (cả ngày lễ)</p>
            </div>
            <div class="col-lg-6 col-12" style="color: white; padding-top: 20px ">
                <div class="list_menu_ft mbl">
                    <ul class="menu-bottom row-item" style="color: white">
                        <li class="level0 first-item ">
                            <div class="title-menu-ft" style="margin: auto">
                                <h3>Hỗ trợ khách hàng</h3>
                            </div>
                            <p><a target='' href='https://onewaymobile.vn/chinh-sach-mua-hang-c2.html'>
                                Chính sách mua hàng </a>
                            </p></li>
                        <li class='  level0 menu-item '>
                            <p><a target='' href='https://onewaymobile.vn/chinh-sach-bao-hanh-c3.html'>
                                Chính sách bảo hành </a>
                            </p></li>
                        <li class='  level0 menu-item '>
                            <p><a target=''
                                  href='https://onewaymobile.vn/chinh-sach-van-chuyen-c4.html'>
                                Chính sách vận chuyển </a>
                            </p></li>
                        <li class='  level0 menu-item '>
                            <p><a target=''
                                  href='https://onewaymobile.vn/phuong-thuc-thanh-toan-c6.html'>
                                Phương thức thanh toán </a></p>
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

