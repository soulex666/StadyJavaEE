package com.andreev.StadyJavaEE.servlets;

import com.andreev.StadyJavaEE.entity.Country;
import com.andreev.StadyJavaEE.entity.Item;
import com.andreev.StadyJavaEE.DBConnector.ItemsDBManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/additem")
public class AddItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Country> coutries = ItemsDBManager.getCountries();
        request.setAttribute("countries", coutries);
        request.getRequestDispatcher("additem.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        Long countryId = Long.parseLong(request.getParameter("manufacturer_id"));

        Country cnt = ItemsDBManager.getCountry(countryId);
        if (cnt != null) {
            ItemsDBManager.addItem(new Item(null, name, price, amount, cnt));
            response.sendRedirect("/additem?success");
        } else {
            response.sendRedirect("/additem?error");
        }
    }
}
