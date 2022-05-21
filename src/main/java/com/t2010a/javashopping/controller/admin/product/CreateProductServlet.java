package com.t2010a.javashopping.controller.admin.product;

import com.t2010a.javashopping.entity.Product;
import com.t2010a.javashopping.model.MySqlProductModel;
import com.t2010a.javashopping.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;

public class CreateProductServlet extends HttpServlet {
    private ProductModel productModel;

    public CreateProductServlet() {
        this.productModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("product", new Product());
        req.setAttribute("action", 1);
        req.setAttribute("title", "Create Product");
        req.getRequestDispatcher("/admin/products/form.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        double price = Double.valueOf(req.getParameter("price"));
        String content = req.getParameter("content");
        String size = req.getParameter("size");
        int qty = Integer.parseInt(req.getParameter("qty"));
        int sku = Integer.parseInt(req.getParameter("sku"));
        String category = req.getParameter("category");
        String tag = req.getParameter("tag");
        Product product = new Product(id, name, price, content,size,qty,sku,category,tag );

        HashMap<String,String> errors = new HashMap<>();
        if (id == null || id.length() == 0){
            errors.put("id","Please enter id");
        }
        if (name == null || name.length() == 0){
            errors.put("name","Please enter name");
        }
        if (price == 0){
            errors.put("price","Please enter price");
        }
        if (content == null || content.length() == 0){
            errors.put("content","Please enter content");
        }
        if (size == null || size.length() == 0){
            errors.put("size","Please enter size");
        }
        if (qty == 0){
            errors.put("qty","Please enter qty");
        }
        if (sku == 0){
            errors.put("sku","Please enter sku");
        }
        if (category == null || category.length() == 0){
            errors.put("category","Please enter category");
        }
        if (tag == null || tag.length() == 0){
            errors.put("tag","Please enter tag");
        }
        if (errors.size() > 0){
            req.setAttribute("product",product);
            req.setAttribute("action",1);
            req.setAttribute("errors",errors);
            req.getRequestDispatcher("/admin/products/form.jsp").forward(req,resp);
        }

        if (productModel.save(product) != null){
            resp.sendRedirect("/admin/products/list");
        }else {
            req.setAttribute("title", "Create Product");
            req.getRequestDispatcher("/admin/products/form.jsp").forward(req,resp);
        }
    }
}
