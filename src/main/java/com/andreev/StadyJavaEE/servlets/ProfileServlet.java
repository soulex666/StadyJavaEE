package com.andreev.StadyJavaEE.servlets;

import com.andreev.StadyJavaEE.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User currentUser = (User) request.getSession().getAttribute("CURRENT_USER");

        if (currentUser != null) {
            request.getRequestDispatcher("/profile.jsp").forward(request, response);
        } else {
            response.sendRedirect("/login");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
