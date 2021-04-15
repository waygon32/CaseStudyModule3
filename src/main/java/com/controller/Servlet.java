package com.controller;


import com.model.Customer;
import com.model.Order;
import com.model.Product;
import com.service.CartService;
import com.service.CustomerService;
import com.service.ProductImp;
import com.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@WebServlet(name = "Servlet", value = "/product")
public class Servlet extends HttpServlet {
    static ProductService productData = new ProductService();
    static CartService cartService = new CartService();
    static Product product;
    static List<Product> listProductCart;
    static ProductImp productImp = new ProductImp();
    CustomerServlet customerServlet = new CustomerServlet();
    List<Order> orderList;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
//        if (action == null) {
//            action = " ";
//        }
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
            case "delete":
                deleteProduct(request, response);
            default:
                showListProduct(request, response);
        }
    }

    private void orderManagement(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("orderList", orderList);
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
        if (customer != null) {
            cartService.getListProductCart(id, customer.getAccount());
//        Cart.setListProductInCart(listProductCart);
            request.setAttribute("productsList", productImp.getListProductForClien());
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/main.jsp");
            dispatcher.forward(request, response);
        } else {
            customerServlet.showLoginForm(request, response);
        }
//        có cần đặt k? xem xét sau
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
                showSearchProduct(request, response);
                break;


        }
    }

    private void buyNow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/buyStatus.jsp");
        requestDispatcher.forward(request, response);
//        for(Product product : listProductCart){
//            listProductCart.remove(product);
//        }
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

    //    private void searchMenu(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        String key = Pattern.compile(" ").matcher(request.getParameter("search")).replaceAll("");
//
//        List<Product> listSearched = new ArrayList<>();
//        for (Product product : productData.getListProductForCustomer()) {
//            if (key.equalsIgnoreCase(Pattern.compile(" ").matcher(product.getName()).replaceAll("")) || key.equalsIgnoreCase(product.getColor())) {
//                listSearched.add(product);
//            }
//        }
//        if (key.equals("")) {
//            request.setAttribute("productsList", productImp.getListProductForClien());
//            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/main.jsp");
//            dispatcher.forward(request, response);
//        } else {
//            if (!listSearched.isEmpty()) {
//                request.setAttribute("productsList", listSearched);
//                RequestDispatcher dispatcher = request.getRequestDispatcher("customer/main.jsp");
//                dispatcher.forward(request, response);
//            } else {
//                RequestDispatcher dispatcher = request.getRequestDispatcher("customer/main.jsp");
//                dispatcher.forward(request, response);
//            }
//        }
//    }
    private void showSearchProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String textSearch = request.getParameter("search").replaceAll("\\s","");
        List<Product> list = productImp.searchProduct(textSearch);
        request.setAttribute("productsList", list);
        request.getRequestDispatcher("customer/main.jsp").forward(request, response);
    }

}
