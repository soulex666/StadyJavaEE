package com.andreev.StadyJavaEE.servlets;

import com.andreev.StadyJavaEE.DBConnector.ItemsDBManager;
import com.andreev.StadyJavaEE.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/auth")
public class AuthServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String pass = request.getParameter("password");

        String redirect = "/login?emailerror";

        User user = ItemsDBManager.getUser(email);

        if (user != null) {
            redirect = "/login?passworderror";
            if (user.getPassword().equals(pass)) {
                request.getSession().setAttribute("CURRENT_USER", user);
                redirect = "/";
            }
        }

        response.sendRedirect(redirect);
    }
}
