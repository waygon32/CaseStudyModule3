package com.controller;

import com.model.Customer;
import com.service.CustomerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CustomerServlet", value = "/customer")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "loginForm": {
                showLoginForm(request, response);
                break;
            }
            case "signUpForm": {
                showSignUpForm(request, response);
                break;
            }
            case "logOut": {
                logOut(request, response);
                break;
            }
            default: {
                showMain(request, response);
                break;
            }
        }
    }

    private void logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        session.removeAttribute("acc");
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/main.jsp");
        dispatcher.forward(request, response);
    }

    private void showSignUpForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/signUpForm.jsp");
        dispatcher.forward(request, response);
    }

    private void showLoginForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/loginForm.jsp");
        dispatcher.forward(request, response);
    }

    private void showMain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
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
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/signUpForm.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
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
                RequestDispatcher dispatcher = request.getRequestDispatcher("customer/main.jsp");
                dispatcher.forward(request, response);
//            response.sendRedirect("customer/main.jsp");
            }else {
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
