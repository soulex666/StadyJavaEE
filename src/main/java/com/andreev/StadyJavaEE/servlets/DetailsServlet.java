package com.andreev.StadyJavaEE.servlets;

import com.andreev.StadyJavaEE.entity.Item;
import com.andreev.StadyJavaEE.fakeDB.ItemsDBManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/details")
public class DetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        Item item = ItemsDBManager.getItem(id);

        if(item != null) {
            request.setAttribute("item", item);
            request.getRequestDispatcher("/details.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/404.jsp").forward(request, response);
        }

    }
}
