package com.andreev.StadyJavaEE.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/deletecookie")
public class DeleteCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("my_cookie_name")) {
                    c.setMaxAge(0); //set cookie timer to zero or delete, it's the same
                    response.addCookie(c);
                    break;
                }
            }
        }
        response.sendRedirect("/cookies");
    }
}
