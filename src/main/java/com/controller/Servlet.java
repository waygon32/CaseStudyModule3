package com.controller;


import com.model.Customer;
import com.model.Order;
import com.model.Product;
import com.service.CartService;
import com.service.OrderService;
import com.service.ProductImp;
import com.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Servlet", value = "/product")
public class Servlet extends HttpServlet {
    static ProductService productService = new ProductService();
    static CartService cartService = new CartService();
    static Product product;
    static List<Product> listProductCart;
    static ProductImp productImp = new ProductImp();
    CustomerServlet customerServlet = new CustomerServlet();
    List<Order> orderList;
    static OrderService orderService = new OrderService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = " ";
        }
        switch (action) {
            case "create":
                creatForm(request, response);
                break;
            case "edit":
                editForm(request, response);
                break;
            case "menu":
                menuForm(request, response);
                break;
            case "cart":
                showCartForm(request, response);
                break;
            case "addToCart":
                addToCart(request, response);
                break;
            case "deleteInCart":
                deleteInCart(request, response);
                break;
            case "orderManagement":
                orderManagement(request, response);
                break;
            case "statistics":
                statistics(request, response);
                break;

            case "iphone12":
                showIphoneID1(request, response);
                break;
            case "iphone11":
                showIphoneID2(request, response);
                break;
            case "iphoneX":
                showIphoneID3(request, response);
                break;
            case "iphone8":
                showIphoneID4(request, response);
                break;
            case "buy":
                buyNow(request, response);
                break;
            case "iphone7":
                showIphoneID5(request, response);
                break;
            case "iphone6":
                showIphoneID6(request, response);
                break;
            case "deleteCart":
                deleteInCart(request, response);
                break;
            case "adminManganer":
                adminManganer(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
            default:
                showListProduct(request, response);
        }
    }

    private void adminManganer(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/MainManager.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void statistics(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Admin/statistics.jsp");
        try {
            request.setAttribute("bestSeller", cartService.getBestSeller());
            request.setAttribute("badSeller", cartService.getBadSeller());
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void orderManagement(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            orderList = orderService.getAllListOrderDetail();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("orderList", orderList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Admin/orderManagement.jsp");
        requestDispatcher.forward(request, response);

    }

    private void deleteInCart(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("productId"));
        HttpSession session = request.getSession(false);
        Customer customer = (Customer) session.getAttribute("acc");
        try {
            cartService.deleteProductInCart(id, customer.getAccount());
            try {
                showCartForm(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void addToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession(false);
        Customer customer = (Customer) session.getAttribute("acc");
        if (customer != null) {
            cartService.getListProductCart(id, customer.getAccount());
//        Cart.setListProductInCart(listProductCart);
            request.setAttribute("productsList", productImp.getListProductForClien());
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/main.jsp");
            dispatcher.forward(request, response);
        } else {
            customerServlet.showLoginForm(request, response);
        }
    }


    private void showCartForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Customer customer = (Customer) session.getAttribute("acc");
        try {
            listProductCart = cartService.getCartInDataBaseByAccount(customer.getAccount());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (!listProductCart.isEmpty()) {
            request.setAttribute("listCart", listProductCart);
            long total = 0;
            for (Product product : listProductCart) {
                total += Long.parseLong(product.getPrice());
            }
            request.setAttribute("total", total);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/cart.jsp");
            requestDispatcher.forward(request, response);
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/cart.jsp");
            requestDispatcher.forward(request, response);
        }

    }


    private void menuForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("products", productService.getListProductForCustomer());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/main.jsp");
        requestDispatcher.forward(request, response);
    }

    private void editForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        product = productService.findById(id);
        request.setAttribute("product", product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Product/edit.jsp");
        requestDispatcher.forward(request, response);
    }

    private void creatForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Product/create.jsp");
        dispatcher.forward(request, response);

    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            productService.deleteProduct(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        request.setAttribute("products",productData.getAllList());
//        RequestDispatcher dispatcher = request.getRequestDispatcher("Product/list.jsp");
//        dispatcher.forward(request, response);

    }

    private void showListProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("products", productService.getAllList());
        RequestDispatcher dispatcher = request.getRequestDispatcher("Product/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showIphoneID1(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String textSearch = request.getParameter("cid");
        List<Product> list = productImp.searchProduct(textSearch);
        request.setAttribute("productsList", list);
        request.getRequestDispatcher("customer/main.jsp").forward(request, response);
    }

    private void showIphoneID2(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String textSearch = request.getParameter("cid1");
        List<Product> list = productImp.searchProduct(textSearch);
        request.setAttribute("productsList", list);
        request.getRequestDispatcher("customer/main.jsp").forward(request, response);
    }

    private void showIphoneID3(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String textSearch = request.getParameter("cid2");
        List<Product> list = productImp.searchProduct(textSearch);
        request.setAttribute("productsList", list);
        request.getRequestDispatcher("customer/main.jsp").forward(request, response);
    }

    private void showIphoneID4(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String textSearch = request.getParameter("cid3");
        List<Product> list = productImp.searchProduct(textSearch);
        request.setAttribute("productsList", list);
        request.getRequestDispatcher("customer/main.jsp").forward(request, response);
    }

    private void showIphoneID5(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String textSearch = request.getParameter("cid4");
        List<Product> list = productImp.searchProduct(textSearch);
        request.setAttribute("productsList", list);
        request.getRequestDispatcher("customer/main.jsp").forward(request, response);
    }

    private void showIphoneID6(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String textSearch = request.getParameter("cid5");
        List<Product> list = productImp.searchProduct(textSearch);
        request.setAttribute("productsList", list);
        request.getRequestDispatcher("customer/main.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "create":
                doCreate(request, response);
                break;
            case "edit":
                doUpdate(request, response);
                break;
//            case "buy":
//                buyNow(request, response);
//                break;
            case "searchMenu":
                showSearchProduct(request, response);
                break;
            case "confirmOrder":
                confirmOrder(request, response);
                break;
            case "iphone12":
                showIphoneID1(request, response);
                break;
            case "iphone11":
                showIphoneID2(request, response);
                break;
            case "iphoneX":
                showIphoneID3(request, response);
                break;
            case "iphone8":
                showIphoneID4(request, response);
                break;
            case "iphone7":
                showIphoneID5(request, response);
                break;
            case "iphone6":
                showIphoneID6(request, response);
                break;
        }
    }

    private void confirmOrder(HttpServletRequest request, HttpServletResponse response) {
        String account = request.getParameter("account");
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        String status = request.getParameter("status");
//        int quantity = Integer.parseInt(request.getParameter("quantity"));
        List<Product> productList = null;
        try {
            productList = orderService.getProductListInOrder(account, orderId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        request.setAttribute("listOrder", productList);
//        request.setAttribute("orderId", orderId);
//        request.setAttribute("account", account);
        orderService.isUpdatedListWhenBought(productList, orderId, status);
        try {
            orderManagement(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }

    }

    private void buyNow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Customer customer = (Customer) session.getAttribute("acc");
        try {
            listProductCart = cartService.getCartInDataBaseByAccount(customer.getAccount());
            orderService.insertOrderDetailView(listProductCart, customer.getAccount());
            for (Product product : listProductCart) {
                cartService.deleteProductInCart(product.getProductId(), customer.getAccount());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/buyStatus.jsp");
        requestDispatcher.forward(request, response);
//        for(Product product : listProductCart){
//            listProductCart.remove(product);
//        }
    }

    private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String price = request.getParameter("price");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String describe = request.getParameter("describe");

        product.setPrice(price);
        product.setQuantity(quantity);
        product.setDescribeProduct(describe);
//        product.setImg(img);
        try {
            productService.updateProduct(product);
            response.sendRedirect("/product");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void doCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String typeID = request.getParameter("typeId");
        String color = request.getParameter("color");
        int memory = Integer.parseInt(request.getParameter("memory"));
        String price = request.getParameter("price");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String describe = request.getParameter("describe");
        String img = request.getParameter("img");
        product = productService.isProductExist(typeID, color, memory);
        if (product == null) {
            try {
                productService.createProduct(new Product(typeID, color, memory, price, quantity, describe, img));
                response.sendRedirect("/product");
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        } else {
            product.setPrice(price);
            product.setQuantity(quantity + product.getQuantity());
            if (describe != null) {
                product.setDescribeProduct(describe);
            }
            if (img != null) {
                product.setImg(img);
            }
            try {
                productService.updateProduct(product);
                response.sendRedirect("/product");
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void showSearchProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String textSearch = request.getParameter("search");
        List<Product> list = productImp.searchProduct(textSearch);
        request.setAttribute("productsList", list);
        request.getRequestDispatcher("customer/main.jsp").forward(request, response);
    }


}
