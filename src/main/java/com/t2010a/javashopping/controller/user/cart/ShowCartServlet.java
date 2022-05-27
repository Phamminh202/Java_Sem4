package com.t2010a.javashopping.controller.user.cart;

import com.t2010a.javashopping.entity.Product;
import com.t2010a.javashopping.entity.cart.CartItem;
import com.t2010a.javashopping.entity.cart.ShoppingCart;
import com.t2010a.javashopping.model.MySqlProductModel;
import com.t2010a.javashopping.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ShowCartServlet extends HttpServlet {
    private ProductModel productModel;

    public ShowCartServlet() {
        this.productModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title","ShoppingCart");
        req.setAttribute("action",1);
        req.getRequestDispatcher("/user/cart/show.jsp").forward(req,resp);
    }
}
