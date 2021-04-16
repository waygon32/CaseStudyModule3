package com.controller;

import com.model.Customer;
import com.model.Product;
import com.service.CustomerService;
import com.service.OrderService;
import com.service.ProductImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customer")
public class CustomerServlet extends HttpServlet {
    static ProductImp productImp = new ProductImp();
    CustomerService customerService = new CustomerService();
    OrderService orderService = new OrderService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        System.out.println("action" + action);
        switch (action) {
            case "loginForm":
                showLoginForm(request, response);
                break;
            case "signUpForm":
                showSignUpForm(request, response);
                break;

            case "logOut":
                logOut(request, response);
                break;
            case "showMain":
                showMain(request, response);
                break;
            case "customerInformation":
                showCustomerInfor(request, response);
                break;
            case "orderDetail":
                showOrderDetailByOrderId(request, response);
                break;

            default: {
                showMain(request, response);
                break;
            }
        }
    }

    private void showOrderDetailByOrderId(HttpServletRequest request, HttpServletResponse response) {
        String account = request.getParameter("account");
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        try {
            List<Product> productList = orderService.getProductListInOrder(account, orderId);
            request.setAttribute("listOrder", productList);
            request.setAttribute("orderId", orderId);
            request.setAttribute("account", account);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/orderDetail.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showCustomerInfor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");

        List<Product> listOldOrder = null;
        try {
            listOldOrder = orderService.getOrderHistory(account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("listOldOrder", listOldOrder);
        request.setAttribute("customer", customerService.getCustomerByAccount(account));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/customerInformation.jsp");
        requestDispatcher.forward(request, response);
    }

    private void logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        session.removeAttribute("acc");
        session.invalidate();
        showMain(request, response);
    }

    private void showSignUpForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/signUpForm.jsp");
        dispatcher.forward(request, response);
    }

    public void showLoginForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Call Login");
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/loginForm.jsp");
        dispatcher.forward(request, response);
    }

    public void showMain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Call Home");
        request.setAttribute("productsList", productImp.getListProductForClien());
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/main.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "loginForm": {
                login(request, response);
                break;
            }
            case "signUpForm": {
                signUp(request, response);
                break;
            }

        }
    }

    private void signUp(HttpServletRequest request, HttpServletResponse response) {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String rePassword = request.getParameter("rePassword");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        if (password == rePassword) {
            CustomerService customerService = new CustomerService();
            boolean check = customerService.checkAccount(account);
            if (check) {
                customerService.addCustomer(account, password, name, address, phoneNumber);
                HttpSession session = request.getSession();
                Customer customer = customerService.checkLogin(account, password);
                session.setAttribute("acc", customer);
                String message = customer.getAccount();
                request.setAttribute("message1", message);
                RequestDispatcher dispatcher = request.getRequestDispatcher("customer/main.jsp");
                try {
                    dispatcher.forward(request, response);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                String message = "T&#224;i kho&#7843;n &#273;&#227; t&#7891;n t&#7841;i";
                request.setAttribute("message", message);
                RequestDispatcher dispatcher = request.getRequestDispatcher("customer/signUpForm.jsp");
                try {
                    dispatcher.forward(request, response);
                } catch (ServletException |IOException e) {
                    e.printStackTrace();
                }
            }
        }else {
            String message = "nh&#7853;p l&#7841;i password kh&#244;ng kh&#7899;p";
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/signUpForm.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException |IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        CustomerService customerService = new CustomerService();
        Customer customer = customerService.checkLogin(account, password);
        if (customer != null) {
            if (!customer.getAccount().equals("admin")) {
                HttpSession session = request.getSession();
                session.setAttribute("acc", customer);
                showMain(request, response);
//            response.sendRedirect("customer/main.jsp");
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("acc", customer);
                RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/MainManager.jsp");
                dispatcher.forward(request, response);
            }
        } else {

            String message = "Nh&#7853;p sai r&#7891;i";
            request.setAttribute("message", message);
//            response.sendRedirect("customer/loginForm.jsp");
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/loginForm.jsp");
            dispatcher.forward(request, response);
        }


    }
}
