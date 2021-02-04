package com.andreev.StadyJavaEE.servlets;

import com.andreev.StadyJavaEE.entity.Item;
import com.andreev.StadyJavaEE.fakeDB.ItemsDBManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/additem")
public class AddItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("additem.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int amount = Integer.parseInt(request.getParameter("amount"));

        ItemsDBManager.addItem(new Item(null, name, price, amount));

        response.sendRedirect("/additem?success");
    }
}
