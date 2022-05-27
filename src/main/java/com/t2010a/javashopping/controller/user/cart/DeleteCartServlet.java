package com.t2010a.javashopping.controller.user.cart;

import com.t2010a.javashopping.entity.Product;
import com.t2010a.javashopping.entity.cart.ShoppingCart;
import com.t2010a.javashopping.model.MySqlProductModel;
import com.t2010a.javashopping.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DeleteCartServlet extends HttpServlet {
    private ProductModel productModel;

    public DeleteCartServlet() {
        this.productModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingcart");
        String id = req.getParameter("id");
        Product product = productModel.findById(id);
        if (product == null) {
            req.setAttribute("message", "Product not found!");
            req.getRequestDispatcher("/user/errors/404.jsp").forward(req, resp);
            return;
        }
        shoppingCart.remove(product);
        session.setAttribute("shoppingcart", shoppingCart);
        resp.sendRedirect("/cart/show");

    }
}