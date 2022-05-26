package com.t2010a.javashopping.controller.admin.product;

import com.t2010a.javashopping.entity.Category;
import com.t2010a.javashopping.entity.Color;
import com.t2010a.javashopping.entity.Product;
import com.t2010a.javashopping.model.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListProductServlet extends HttpServlet {
    private ProductModel productModel;
    private ColorModel colorModel;
    private CategoryModel categoryModel;

    public ListProductServlet() {
        this.productModel = new MySqlProductModel();
        this.colorModel = new MySqlColorModel();
        this.categoryModel = new MySqlCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productModel.findAll();
        req.setAttribute("title","List Product");
        req.setAttribute("listProduct",products);
        req.setAttribute("color", colorModel.findAll());
        req.setAttribute("category", categoryModel.findAll());
        req.getRequestDispatcher("/admin/products/list.jsp").forward(req,resp);
    }
}
