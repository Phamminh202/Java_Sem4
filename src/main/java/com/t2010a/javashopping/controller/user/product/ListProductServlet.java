package com.t2010a.javashopping.controller.user.product;

import com.t2010a.javashopping.entity.Category;
import com.t2010a.javashopping.entity.Color;
import com.t2010a.javashopping.entity.Product;
import com.t2010a.javashopping.entity.ProductFilter;
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
    private CategoryModel categoryModel;
    private ColorModel colorModel;

    public ListProductServlet() {
        this.productModel = new MySqlProductModel();
        this.colorModel = new MySqlColorModel();
        this.categoryModel = new MySqlCategoryModel();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductFilter productFilter = new ProductFilter();

        String stringcategory_id = req.getParameter("category_id");
        String stringcolor_id = req.getParameter("color_id");
        String stringminPrice = req.getParameter("minPrice");
        String stringmaxPrice = req.getParameter("maxPrice");
        String stringstatus = req.getParameter("status");
        String keyword = req.getParameter("keyword");
        String stringpage = req.getParameter("page");
        String stringlimit = req.getParameter("limit");
        
        if (stringcategory_id != null){
            int categoty_id = Integer.parseInt(stringcategory_id);
            productFilter.setCategory_id(categoty_id);
        }
        if (stringcolor_id != null){
            int color_id = Integer.parseInt(stringcolor_id);
            productFilter.setColor_id(color_id);
        }
        if (stringminPrice != null){
            double minPrice = Double.parseDouble(stringminPrice);
            productFilter.setMinPrice(minPrice);
            double maxPrice = Double.parseDouble(stringmaxPrice);
            productFilter.setMaxPrice(maxPrice);
        }
        if (stringstatus != null){
            int status = Integer.parseInt(stringstatus);
            productFilter.setStatus(status);
        }
        if (keyword != null){
            productFilter.setKeyword(keyword);
        }
        if (stringpage != null){
            int page = Integer.parseInt(stringpage);
            productFilter.setPage(page);
        }
        if (stringlimit != null){
            int limit = Integer.parseInt(stringlimit);
            productFilter.setColor_id(limit);
        }

        List<Product> product = productModel.findAll(productFilter);
        req.setAttribute("product", product);
        req.setAttribute("category", categoryModel.findAll());
        req.setAttribute("color", colorModel.findAll());
        req.setAttribute("title","Shop");
        req.getRequestDispatcher("/user/product/list.jsp").forward(req,resp);
    }
}
