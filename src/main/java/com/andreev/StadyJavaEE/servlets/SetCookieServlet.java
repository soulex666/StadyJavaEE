package com.andreev.StadyJavaEE.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/setcookie")
public class SetCookieServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cookieValue = request.getParameter("cookie_value");

        Cookie cookie = new Cookie("my_cookie_name", cookieValue);
        cookie.setMaxAge(3600); //1 hour
        response.addCookie(cookie);

        response.sendRedirect("/cookies");
    }
}
