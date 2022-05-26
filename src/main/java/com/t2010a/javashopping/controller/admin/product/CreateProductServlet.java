package com.t2010a.javashopping.controller.admin.product;

import com.t2010a.javashopping.entity.Category;
import com.t2010a.javashopping.entity.Color;
import com.t2010a.javashopping.entity.Product;
import com.t2010a.javashopping.entity.myenum.ProductStatus;
import com.t2010a.javashopping.model.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public class CreateProductServlet extends HttpServlet {
    private ProductModel productModel;
    private ColorModel colorModel;
    private CategoryModel categoryModel;

    public CreateProductServlet() {
        this.productModel = new MySqlProductModel();
        this.colorModel = new MySqlColorModel();
        this.categoryModel = new MySqlCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("product", new Product());
        req.setAttribute("color", colorModel.findAll());
        req.setAttribute("category", categoryModel.findAll());
        req.setAttribute("action", 1);
        req.setAttribute("title", "Create Product");
        req.getRequestDispatcher("/admin/products/form.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String image = req.getParameter("image");
        double price = Double.valueOf(req.getParameter("price"));
        int qty = Integer.parseInt(req.getParameter("qty"));
        int color_id = Integer.parseInt(req.getParameter("color_id"));
        String content = req.getParameter("content");
        int category_id = Integer.parseInt(req.getParameter("category_id"));
        int status = Integer.parseInt(req.getParameter("status"));
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setImage(image);
        product.setPrice(price);
        product.setQty(qty);
        product.setColor_id(color_id);
        product.setContent(content);
        product.setCategory_id(category_id);
        product.setStatus(ProductStatus.of(status));

        if (!product.isValid()){
            req.setAttribute("product",product);
            req.setAttribute("color", colorModel.findAll());
            req.setAttribute("category", categoryModel.findAll());
            req.setAttribute("action",1);
            req.setAttribute("title","Create Product");
            req.setAttribute("errors",product.getErrors());
            req.getRequestDispatcher("/admin/products/form.jsp").forward(req,resp);
        }
        if (productModel.save(product) != null){
            resp.sendRedirect("/admin/products/list");
        }else {
            req.setAttribute("action",1);
            req.setAttribute("title", "Create Product");
            req.getRequestDispatcher("/admin/products/form.jsp").forward(req,resp);
        }
    }
}
