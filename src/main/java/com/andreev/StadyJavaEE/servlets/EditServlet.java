package com.andreev.StadyJavaEE.servlets;

import com.andreev.StadyJavaEE.entity.Country;
import com.andreev.StadyJavaEE.entity.Item;
import com.andreev.StadyJavaEE.DBConnector.ItemsDBManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/edit")
public class EditServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        long countryId = Long.parseLong(request.getParameter("manufacturer_id"));

        String redirect = "/";

        Country cnt = ItemsDBManager.getCountry(countryId);
        if (cnt != null) {
            Item item = ItemsDBManager.getItem(id);
            if (item != null) {
                item.setName(name);
                item.setPrice(price);
                item.setAmount(amount);
                item.setManufacturer(cnt);

                if(ItemsDBManager.saveItem(item)) {
                    redirect = "/edit?id=" + id + "&success";
                } else {
                    redirect = "/edit?id=" + id + "&error";
                }

            }
        }

        response.sendRedirect(redirect);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = 0L;

        try {
            id = Long.parseLong(request.getParameter("id"));
        } catch (Exception e) {

        }
        Item item = ItemsDBManager.getItem(id);

        if(item != null) {
            request.setAttribute("item", item);

            List<Country> countries = ItemsDBManager.getCountries();
            request.setAttribute("countries", countries);

            request.getRequestDispatcher("/edit.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/404.jsp").forward(request, response);
        }
    }
}
