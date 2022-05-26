package com.t2010a.javashopping.controller.user.product;

import com.t2010a.javashopping.entity.Category;
import com.t2010a.javashopping.entity.Color;
import com.t2010a.javashopping.entity.Product;
import com.t2010a.javashopping.model.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ListProductServlet extends HttpServlet {
    private ProductModel productModel;

    public ListProductServlet() {
        this.productModel = new MySqlProductModel();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> product = productModel.findAll();
        req.setAttribute("product", product);
        req.setAttribute("title","Shop");
        req.getRequestDispatcher("/user/product/list.jsp").forward(req,resp);
    }
}
