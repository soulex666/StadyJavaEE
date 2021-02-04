package com.andreev.StadyJavaEE.servlets;

import com.andreev.StadyJavaEE.entity.Item;
import com.andreev.StadyJavaEE.fakeDB.ItemsDBManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(value = "/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Item> items = ItemsDBManager.getItems();

        PrintWriter writer = response.getWriter();

        for (Item temp :items) {
            writer.println(temp);
        }
    }
}
