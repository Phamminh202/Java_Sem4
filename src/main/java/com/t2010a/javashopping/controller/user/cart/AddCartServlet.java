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

public class AddCartServlet extends HttpServlet {
    private ProductModel productModel;

    public AddCartServlet() {
        this.productModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingcart");
        if (shoppingCart == null){
            shoppingCart = new ShoppingCart();
        }
        try {
            String id = req.getParameter("id");
            int qty = Integer.parseInt(req.getParameter("qty"));
            Product product = productModel.findById(id);
            if (product == null){
                req.setAttribute("message","Error!!");
                req.getRequestDispatcher("/user/errors/404.jsp").forward(req,resp);
                return;
            }
            if (qty <= 0){
                req.setAttribute("message","Error!!");
                req.getRequestDispatcher("/user/errors/404.jsp").forward(req,resp);
                return;
            }
            shoppingCart.add(product,qty);
            session.setAttribute("shoppingcart", shoppingCart);
            resp.sendRedirect("/cart/show");
        }catch (Exception e){
            e.printStackTrace();
            req.setAttribute("message","Error!!");
            req.getRequestDispatcher("/user/errors/500.jsp").forward(req,resp);
        }
    }
}
