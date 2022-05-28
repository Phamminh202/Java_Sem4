package com.t2010a.javashopping.controller.user.cart;

import com.t2010a.javashopping.entity.Account;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ShowCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Account account = (Account) session.getAttribute("currentLogin");
        if (account == null) {
            resp.sendRedirect("/login");
        } else {
            req.setAttribute("title", "ShoppingCart");
            req.setAttribute("action", 1);
            req.getRequestDispatcher("/user/cart/show.jsp").forward(req, resp);
        }
    }
}
