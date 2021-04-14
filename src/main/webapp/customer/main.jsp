<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <div class="d-flex col-sm-2" style="float: right">
            ${message1}
            <c:if test="${sessionScope.acc ==null}">
                <button onclick="window.location.href='/customer?action=loginForm'">Đăng nhập</button>
            </c:if>
            <c:if test="${sessionScope.acc !=null}">
                <a>Hello ${sessionScope.acc.account  }</a>
                <button onclick="window.location.href='/customer?action=logOut'">Đăng xuất</button>
            </c:if>
        </div>
        <form class="d-flex col-sm-2" style="margin-left: auto; margin-top: 10px; margin-bottom: 10px">
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
    <div class="row">
        <div id="carouselExampleCaptions" class="carousel slide col-lg-10 col-12" data-bs-ride="carousel"
             style="margin: auto">
            <div class="carousel-inner">
                <div class="carousel-item active" data-bs-interval="2000">
                    <img style="height: 500px"
                         src="https://cellphones.com.vn/sforum/wp-content/uploads/2020/05/ngay-ra-mat-iPhone-12-2.jpg"
                         class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item" data-bs-interval="2000">
                    <img style="height: 500px"
                         src="https://namtienmobile.vn/wp-content/uploads/2020/10/iphone-12-banner-1400x633.png"
                         class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item" data-bs-interval="2000">
                    <img style="height: 500px"
                         src="https://www.xtmobile.vn/vnt_upload/news/08_2019/19/iphone-12-xtmoibile-banner.jpg"
                         class="d-block w-100" alt="...">
                </div>
            </div>
            <span aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
            <span aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </div>
    </div>
    </div>
</header>
<!--<&#45;&#45;!end header&ndash;&gt;-->


<div class="container">
    <div class="row">
        <div id="carouselExampleIndicators" class="carousel slide col-lg-3" data-bs-ride="carousel"
             style="position: relative">
            <div class="carousel-indicators" style="position: absolute; bottom: 100px">
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active"
                        aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
                        aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"
                        aria-label="Slide 3"></button>
            </div>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <div>
                        <img src="https://cdn.tgdd.vn/Products/Images/42/228736/iphone-12-trang-new-600x600-600x600.jpg"
                             class="d-block w-100" alt="...">
                    </div>
                    <div>
                        <a class="nav-link active" aria-current="page" style="color: black" href="/iphone12">Iphone
                            12</a>
                        <p>Giá: Liên Hệ</p>
                    </div>
                </div>
                <div class="carousel-item">
                    <div>
                        <img src="https://cdn.tgdd.vn/Products/Images/42/228736/iphone-12-den-new-600x600-200x200.jpg"
                             class="d-block w-100" alt="...">
                    </div>
                    <div>
                        <a class="nav-link active" aria-current="page" style="color: black" href="/iphone12">Iphone
                            12</a>
                        <p>Giá: Liên Hệ</p>
                    </div>
                </div>
                <div class="carousel-item">

                    <div>
                        <img src="https://cdn.tgdd.vn/Products/Images/42/228736/iphone-12-xanh-duong-new-600x600-200x200.jpg"
                             class="d-block w-100" alt="...">
                    </div>
                    <div>
                        <a class="nav-link active" aria-current="page" style="color: black" href="/iphone12">Iphone
                            12</a>
                        <p>Giá: Liên Hệ</p>
                    </div>
                </div>
            </div>
            <span class="" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>

            <span class="" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </div>

        <div id="carouselExampleIndicators2" class="carousel slide col-lg-3" data-bs-ride="carousel"
             style="position: relative">
            <div class="carousel-indicators" style="position: absolute; bottom: 100px">
                <button type="button" data-bs-target="#carouselExampleIndicators2" data-bs-slide-to="0" class="active"
                        aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators2" data-bs-slide-to="1"
                        aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators2" data-bs-slide-to="2"
                        aria-label="Slide 3"></button>
            </div>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <div>
                        <img src="https://cdn.tgdd.vn/Products/Images/42/153856/iphone-xi-xanhla-600x600-200x200.jpg"
                             class="d-block w-100" alt="...">
                    </div>
                    <div>
                        <a class="nav-link active" aria-current="page" style="color: black" href="/iphone11">Iphone
                            11</a>
                        <p>Giá: Liên Hệ</p>
                    </div>
                </div>
                <div class="carousel-item">
                    <div>
                        <img src="https://cdn.tgdd.vn/Products/Images/42/153856/iphone-11-trang-600x600-200x200.jpg"
                             class="d-block w-100" alt="...">
                    </div>
                    <div>
                        <a class="nav-link active" aria-current="page" style="color: black" href="/iphone11">Iphone
                            11</a>
                        <p>Giá: Liên Hệ</p>
                    </div>
                </div>
                <div class="carousel-item">

                    <div>
                        <img src="https://cdn.tgdd.vn/Products/Images/42/153856/iphone-xi-do-600x600-600x600.jpg"
                             class="d-block w-100" alt="...">
                    </div>
                    <div>
                        <a class="nav-link active" aria-current="page" style="color: black" href="/iphone11">Iphone
                            11</a>
                        <p>Giá: Liên Hệ</p>
                    </div>
                </div>
            </div>
            <span class="" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
            <span class="" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </div>

        <div id="carouselExampleIndicators3" class="carousel slide col-lg-3" data-bs-ride="carousel"
             style="position: relative">
            <div class="carousel-indicators" style="position: absolute; bottom: 100px">
                <button type="button" data-bs-target="#carouselExampleIndicators3" data-bs-slide-to="0" class="active"
                        aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators3" data-bs-slide-to="1"
                        aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators3" data-bs-slide-to="2"
                        aria-label="Slide 3"></button>
            </div>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <div>
                        <img src="https://bachlongmobile.com/media/catalog/product/cache/2/image/040ec09b1e35df139433887a97daa66f/6/3/636483223586180190_3_13_5.jpg"
                             class="d-block w-100" alt="...">
                    </div>
                    <div>
                        <a class="nav-link active" aria-current="page" style="color: black" href="/iphoneX">Iphone
                            X</a>
                        <p>Giá: Liên Hệ</p>
                    </div>
                </div>
                <div class="carousel-item">
                    <div>
                        <img src="https://www.xtmobile.vn/vnt_upload/product/Hinh_DT/Iphone/ip_X/thumbs/(600x600)_crop_iphone-x-64gb-gray-xtmobile.jpg"
                             class="d-block w-100" alt="...">
                    </div>
                    <div>
                        <a class="nav-link active" aria-current="page" style="color: black" href="/iphoneX">Iphone
                            X</a>
                        <p>Giá: Liên Hệ</p>
                    </div>
                </div>
                <div class="carousel-item">

                    <div>
                        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTsiEdqlWAmyqt6IAI_Va8DyGm-zivkt2NlFQ&usqp=CAU"
                             class="d-block w-100" alt="...">
                    </div>
                    <div>
                        <a class="nav-link active" aria-current="page" style="color: black" href="/iphoneX">Iphone
                            X</a>
                        <p>Giá: Liên Hệ</p>
                    </div>
                </div>
            </div>
            <span class="" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
            <span class="" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </div>

        <div id="carouselExampleIndicators4" class="carousel slide col-lg-3" data-bs-ride="carousel"
             style="position: relative">
            <div class="carousel-indicators" style="position: absolute; bottom: 100px">
                <button type="button" data-bs-target="#carouselExampleIndicators4" data-bs-slide-to="0" class="active"
                        aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators4" data-bs-slide-to="1"
                        aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators4" data-bs-slide-to="2"
                        aria-label="Slide 3"></button>
            </div>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <div>
                        <img src="https://didongviet.vn/pub/media/catalog/product//i/p/iphone-8-plus-quoc-te-mau-trang-didongviet.jpg"
                             class="d-block w-100" alt="...">
                    </div>
                    <div>
                        <a class="nav-link active" aria-current="page" style="color: black" href="/iphone8">Iphone
                            8</a>
                        <p>Giá: Liên Hệ</p>
                    </div>
                </div>
                <div class="carousel-item">
                    <div>
                        <img src="https://didongviet.vn/pub/media/catalog/product//8/p/8p-min_1.jpg"
                             class="d-block w-100" alt="...">
                    </div>
                    <div>
                        <a class="nav-link active" aria-current="page" style="color: black" href="/iphone8">Iphone
                            8</a>
                        <p>Giá: Liên Hệ</p>
                    </div>
                </div>
                <div class="carousel-item">

                    <div>
                        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR1mRLGqejuvPg1JJp5JmvkL5xdHqbCjjMBddKrUAgnKGg5gTNebaPI55L5fx10KevNRBc&usqp=CAU"
                             class="d-block w-100" alt="...">
                    </div>
                    <div>
                        <a class="nav-link active" aria-current="page" style="color: black" href="/iphone8">Iphone
                            8</a>
                        <p>Giá: Liên Hệ</p>
                    </div>
                </div>
            </div>
            <span class="" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
            <span class="" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </div>

        <div id="carouselExampleIndicators5" class="carousel slide col-lg-3" data-bs-ride="carousel"
             style="position: relative">
            <div class="carousel-indicators" style="position: absolute; bottom: 100px">
                <button type="button" data-bs-target="#carouselExampleIndicators5" data-bs-slide-to="0" class="active"
                        aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators5" data-bs-slide-to="1"
                        aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators5" data-bs-slide-to="2"
                        aria-label="Slide 3"></button>
            </div>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <div>
                        <img src="data:image/jpeg;base64,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"
                             class="d-block w-100" alt="...">
                    </div>
                    <div>
                        <a class="nav-link active" aria-current="page" style="color: black" href="/iphone7">Iphone
                            7</a>
                        <p>Giá: Liên Hệ</p>
                    </div>
                </div>
                <div class="carousel-item">
                    <div>
                        <img src="https://www.xtmobile.vn/vnt_upload/product/12_2018/thumbs/600_7_plus_red_800x800.jpg"
                             class="d-block w-100" alt="...">
                    </div>
                    <div>
                        <a class="nav-link active" aria-current="page" style="color: black" href="/iphone7">Iphone
                            7</a>
                        <p>Giá: Liên Hệ</p>
                    </div>
                </div>
                <div class="carousel-item">

                    <div>
                        <img src="https://storage.googleapis.com/cdn.nhanh.vn/store1/44417/ps/20201126/7_hong.jpg"
                             class="d-block w-100" alt="...">
                    </div>
                    <div>
                        <a class="nav-link active" aria-current="page" style="color: black" href="/iphone7">Iphone
                            7</a>
                        <p>Giá: Liên Hệ</p>
                    </div>
                </div>
            </div>
            <span class="" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
            <span class="" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </div>

        <div id="carouselExampleIndicators6" class="carousel slide col-lg-3" data-bs-ride="carousel"
             style="position: relative">
            <div class="carousel-indicators" style="position: absolute; bottom: 100px">
                <button type="button" data-bs-target="#carouselExampleIndicators6" data-bs-slide-to="0" class="active"
                        aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators6" data-bs-slide-to="1"
                        aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators6" data-bs-slide-to="2"
                        aria-label="Slide 3"></button>
            </div>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <div>
                        <img src="https://bachlongmobile.com/media/catalog/product/cache/2/image/040ec09b1e35df139433887a97daa66f/6/0/600_ip6_gold_800x800_1_1.jpg"
                             class="d-block w-100" alt="...">
                    </div>
                    <div>
                        <a class="nav-link active" aria-current="page" style="color: black" href="/iphone6">Iphone
                            6</a>
                        <p>Giá: Liên Hệ</p>
                    </div>
                </div>
                <div class="carousel-item">
                    <div>
                        <img src="https://padstore.vn/uploads/co-nen-mua-iphone-6s-plus-khong_1580808287.jpg"
                             class="d-block w-100" alt="...">
                    </div>
                    <div>
                        <a class="nav-link active" aria-current="page" style="color: black" href="/iphone6">Iphone
                            6</a>
                        <p>Giá: Liên Hệ</p>
                    </div>
                </div>
                <div class="carousel-item">

                    <div>
                        <img src="https://didongviet.vn/pub/media/catalog/product//i/p/iphone-6-plus-quoc-te-64gb-didongviet.jpg"
                             class="d-block w-100" alt="...">
                    </div>
                    <div>
                        <a class="nav-link active" aria-current="page" style="color: black" href="/iphone6">Iphone
                            6</a>
                        <p>Giá: Liên Hệ</p>
                    </div>
                </div>
            </div>
            <span class="" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
            <span class="" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </div>

    </div>
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
                        <li class=' level0 menu-item '>
                            <p><a target='' href='https://onewaymobile.vn/chinh-sach-bao-hanh-c3.html'>
                                Chính sách bảo hành </a>
                            </p></li>
                        <li class=' level0 menu-item '>
                            <p><a target=''
                                  href='https://onewaymobile.vn/chinh-sach-van-chuyen-c4.html'>
                                Chính sách vận chuyển </a>
                            </p></li>
                        <li class=' level0 menu-item '>
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
