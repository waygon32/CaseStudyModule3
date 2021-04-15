package com.controller;


import com.model.Customer;
import com.model.Order;
import com.model.Product;
import com.service.CartService;
import com.service.CustomerService;
import com.service.OrderService;
import com.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Servlet", value = "/product")
public class Servlet extends HttpServlet {
    static ProductService productData = new ProductService();
    static CartService cartService = new CartService();
    static Product product;
    static List<Product> listProductCart;
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
            case "delete":
                deleteProduct(request, response);
            default:
                showListProduct(request, response);
        }
    }

    private void statistics(HttpServletRequest request, HttpServletResponse response)  {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Admin/statistics.jsp");
        try {
            request.setAttribute("bestSeller",cartService.getBestSeller());
            request.setAttribute("badSeller",cartService.getBadSeller());
            requestDispatcher.forward(request,response);
        } catch (ServletException  | IOException |SQLException e) {
            e.printStackTrace();
        }
    }

    private void orderManagement(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            orderList = orderService.getAllListOrderDetail();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("orderList",  orderList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Admin/orderManagement.jsp");
        requestDispatcher.forward(request, response);

    }

    private void deleteInCart(HttpServletRequest request, HttpServletResponse response) {
//        String name  = request.getParameter("id");
//        for(Product product : listProductCart ){
//            if(name.equals(product.getColor())){
//                listProductCart.remove(product);
//            }
//        }
//        try {
//            showCartForm(request,response);
//        } catch (ServletException | IOException e) {
//            e.printStackTrace();
//        }
    }


    private void addToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession(false);
        Customer customer = (Customer) session.getAttribute("acc");
        cartService.getListProductCart(id, customer.getAccount());
//        Cart.setListProductInCart(listProductCart);
        menuForm(request, response);
    }


    private void showCartForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Customer customer = (Customer) session.getAttribute("acc");
        try {
            listProductCart = cartService.getCartInDataBaseByAccount(customer.getAccount());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (listProductCart != null) {
            request.setAttribute("listCart", listProductCart);
            long total = 0;
            for (Product product : listProductCart) {
                total += Long.parseLong(product.getPrice());
            }
            request.setAttribute("total", total);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/cart.jsp");
            requestDispatcher.forward(request, response);
        } else {
            menuForm(request, response);
        }

    }


    private void menuForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("products", productData.getListProductForCustomer());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/menu.jsp");
        requestDispatcher.forward(request, response);
    }

    private void editForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Product/edit.jsp");
        requestDispatcher.forward(request, response);
        int id = Integer.parseInt(request.getParameter("id"));
        product = productData.findById(id);
    }

    private void creatForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Product/create.jsp");
        dispatcher.forward(request, response);

    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            productData.deleteProduct(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        request.setAttribute("products",productData.getAllList());
//        RequestDispatcher dispatcher = request.getRequestDispatcher("Product/list.jsp");
//        dispatcher.forward(request, response);

    }

    private void showListProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("products", productData.getAllList());
        RequestDispatcher dispatcher = request.getRequestDispatcher("Product/list.jsp");
        dispatcher.forward(request, response);
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
            case "buy":
                buyNow(request, response);
                break;
            case "searchMenu":
                searchMenu(request, response);
                break;


        }
    }

    private void buyNow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Customer customer = (Customer) session.getAttribute("acc");
        try {
            orderService.insertOrderDetailView(listProductCart, customer.getAccount());
            cartService.deleteProductInCart(listProductCart);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/buyStatus.jsp");
        requestDispatcher.forward(request, response);

    }

    private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
        String typeID = request.getParameter("typeId");
        String color = request.getParameter("color");
        int memory = Integer.parseInt(request.getParameter("memory"));
        String price = request.getParameter("price");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String describe = request.getParameter("describe");
        String img = request.getParameter("img");
        product.setTypeId(typeID);
        product.setColor(color);
        product.setMemory(memory);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setDescribeProduct(describe);
        product.setImg(img);
        try {
            productData.updateProduct(product);
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
        product = productData.isProductExist(typeID, color, memory);
        if (product == null) {
            try {
                productData.createProduct(new Product(typeID, color, memory, price, quantity, describe, img));
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
                productData.updateProduct(product);
                response.sendRedirect("/product");
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void searchMenu(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String key = request.getParameter("search");
        List<Product> listSearched = new ArrayList<>();
        for (Product product : productData.getListProductForCustomer()) {
            if (key.equalsIgnoreCase(product.getName()) || key.equalsIgnoreCase(product.getColor())) {
                listSearched.add(product);
            }
        }
        if (!listSearched.isEmpty()) {
            request.setAttribute("productsList", listSearched);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/main.jsp");
            dispatcher.forward(request, response);
        } else {
            menuForm(request, response);
        }
    }


}
