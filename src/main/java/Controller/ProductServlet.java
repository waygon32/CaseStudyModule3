package Controller;
import com.model.Product;
import com.service.ProductImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    static ProductImp productImp = new ProductImp();
    static Product product= new Product();

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
            case "delete":
                deleteProduct(request, response);
                break;
//            case "test":
//                showListProductClient(request,response);
//                break;
            default:
                showListProduct(request, response);
                break;
        }
    }

    private void editForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/editProduct.jsp");
        requestDispatcher.forward(request, response);
        int id = Integer.parseInt(request.getParameter("id"));
        product = productImp.findById(id);
    }

    private void creatForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/createProduct.jsp");
        dispatcher.forward(request, response);

    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            productImp.deleteProduct(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void showListProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("products", productImp.getAllList());
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/listProduct.jsp");
        dispatcher.forward(request, response);
    }
//    private void showListProductClient(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//
//        request.setAttribute("productsList", productImp.getListProductForClien());
//        RequestDispatcher dispatcher = request.getRequestDispatcher("product/test.jsp");
//        dispatcher.forward(request, response);
//    }

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
        }
    }


    private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            productImp.updateProduct(product);
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
            productImp.createProduct(new Product(typeID, color, memory, price, quantity, describe, img));
            response.sendRedirect("/product");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }


}