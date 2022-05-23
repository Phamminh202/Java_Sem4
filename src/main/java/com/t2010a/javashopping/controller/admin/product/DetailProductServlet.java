package com.t2010a.javashopping.controller.admin.product;

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

public class DetailProductServlet extends HttpServlet {
    private ProductModel productModel;
    private ColorModel colorModel;
    private CategoryModel categoryModel;

    public DetailProductServlet() {
        this.productModel = new MySqlProductModel();
        this.colorModel = new MySqlColorModel();
        this.categoryModel = new MySqlCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        req.setAttribute("title", "Detail Product");
        Product product = productModel.findById(id);
        List<Color> color = colorModel.findAll();
        List<Category> category = categoryModel.findAll();

        if (product == null) {
            req.setAttribute("message", "Data not found!");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
        } else {
            HttpSession session = req.getSession();
            req.setAttribute("product", product);
            req.setAttribute("color", color);
            req.setAttribute("category", category);
            req.getRequestDispatcher("/admin/products/detail.jsp").forward(req, resp);
        }
    }
}
