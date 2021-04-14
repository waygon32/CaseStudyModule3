package Controller;

import Model.Cart;
import Model.Product;
import Service.CartService;

import Service.ProductService;
import sun.util.resources.cldr.ff.CalendarData_ff_SN;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Servlet", value = "/product")
public class Servlet extends HttpServlet {
    static ProductService productData = new ProductService();
    static CartService cartService = new CartService();
    static Product product;
    static List<Product> listProductCart;
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
            case "delete":
                deleteProduct(request, response);
            default:
                showListProduct(request, response);
        }
    }

    private void deleteInCart(HttpServletRequest request, HttpServletResponse response) {
//        String name  = request.getParameter("name");
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
        listProductCart = cartService.getListProductCart(id);
//        Cart.setListProductInCart(listProductCart);
        menuForm(request, response);
    }


    private void showCartForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (listProductCart != null) {
            request.setAttribute("listCart", listProductCart);
            long total = 0;
            for (Product product : listProductCart) {
                total += Long.parseLong(product.getPrice());
            }
            request.setAttribute("total", total);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Customer/cart.jsp");
            requestDispatcher.forward(request, response);
        } else {
            menuForm(request, response);
        }

    }


    private void menuForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("products", productData.getListProductForCustomer());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Customer/menu.jsp");
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
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Customer/buyStatus.jsp");
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
        try {
            productData.createProduct(new Product(typeID, color, memory, price, quantity, describe, img));
            response.sendRedirect("/product");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
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
            request.setAttribute("products", listSearched);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Customer/menu.jsp");
            requestDispatcher.forward(request, response);
        } else {
            menuForm(request, response);
        }
    }

}
