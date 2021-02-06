package com.andreev.StadyJavaEE.servlets;

import com.andreev.StadyJavaEE.entity.Item;
import com.andreev.StadyJavaEE.DBConnector.ItemsDBManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        Item item = ItemsDBManager.getItem(id);
        if (item != null) {

            if(ItemsDBManager.deleteItem(item)) {
                response.sendRedirect("/");
            } else {
                response.sendRedirect("/edit?id=" + id + "&error");
            }

        } else {
            response.sendRedirect("/");
        }

    }
}
