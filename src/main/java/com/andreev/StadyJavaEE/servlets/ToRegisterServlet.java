package com.andreev.StadyJavaEE.servlets;

import com.andreev.StadyJavaEE.DBConnector.ItemsDBManager;
import com.andreev.StadyJavaEE.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/toregister")
public class ToRegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        String rePass = request.getParameter("re_password");
        String fullName = request.getParameter("full_name");

        String redirect = "/register?passworderror";

        if (pass.equals(rePass)) {
            redirect = "/register?emailerror";

            User user = ItemsDBManager.getUser(email);

            if (user == null) {
                User newUser = new User(null, email, pass, fullName);
                if (ItemsDBManager.addUser(newUser)) {
                    redirect = "/register?success";
                }
            }
        }
        response.sendRedirect(redirect);
    }
}
