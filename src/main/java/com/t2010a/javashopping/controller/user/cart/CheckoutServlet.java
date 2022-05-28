package com.t2010a.javashopping.controller.user.cart;

import com.t2010a.javashopping.entity.Account;
import com.t2010a.javashopping.entity.Product;
import com.t2010a.javashopping.entity.cart.CartItem;
import com.t2010a.javashopping.entity.cart.ShoppingCart;
import com.t2010a.javashopping.entity.myenum.ShoppingCartStatus;
import com.t2010a.javashopping.model.CheckoutCartItemModel;
import com.t2010a.javashopping.model.CheckoutShoppingCartModel;
import com.t2010a.javashopping.model.MySqlCartItemModel;
import com.t2010a.javashopping.model.MySqlShoppingCartModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class CheckoutServlet extends HttpServlet {
    private CheckoutShoppingCartModel checkoutShoppingCartModel;
    private CheckoutCartItemModel checkoutCartItemModel;

    public CheckoutServlet() {
        this.checkoutShoppingCartModel = new MySqlShoppingCartModel();
        this.checkoutCartItemModel = new MySqlCartItemModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title","Checkout");
        req.setAttribute("action",1);
        req.getRequestDispatcher("/user/cart/checkout.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingcart");
        Account account = (Account) session.getAttribute("currentLogin");
        if (account == null) {
            resp.sendRedirect("/login");
        } else {
            if (shoppingCart == null) {
                req.setAttribute("message", "Error!!");
                req.getRequestDispatcher("/user/errors/404.jsp").forward(req, resp);
                return;
            }else {
                try {
                    String shipName = req.getParameter("firstname") + " " + req.getParameter("lastname");
                    String shipPhone = req.getParameter("shipPhone");
                    String shipAddress = req.getParameter("shipAddress");
                    String shipNote = req.getParameter("shipNote");
                    double totalPrice = Double.parseDouble(req.getParameter("totalPrice"));
                    int userId = account.getId();
                    ShoppingCart shoppingCart1 = new ShoppingCart();
                    shoppingCart1.setUserId(userId);
                    shoppingCart1.setShipName(shipName);
                    shoppingCart1.setShipPhone(shipPhone);
                    shoppingCart1.setShipAddress(shipAddress);
                    shoppingCart1.setShipNote(shipNote);
                    shoppingCart1.setTotalPrice(totalPrice);
                    if (!shoppingCart1.isValid()) {
                        req.setAttribute("title", "Checkout");
                        req.setAttribute("action", 1);
                        req.getRequestDispatcher("/user/cart/checkout.jsp").forward(req, resp);
                    }
                    if (checkoutShoppingCartModel.save(shoppingCart1) != null) {
                        List<ShoppingCart> list = checkoutShoppingCartModel.findAll();
                        int shoppingcartId = 0;
                        for (int i = 0; i < list.size(); i++) {
                            if (shoppingcartId <= list.get(i).getId()){
                                shoppingcartId = list.get(i).getId();
                            }
                        }
                        List<CartItem> items = shoppingCart.getListItems();
                        for (int i = 0; i < items.size(); i++) {
                            checkoutCartItemModel.save(items.get(i),shoppingcartId);
                        }
                        session.removeAttribute("shoppingcart");
                        req.setAttribute("title", "Home");
                        resp.sendRedirect("/home");
                    } else {
                        req.setAttribute("title", "Checkout");
                        req.setAttribute("action", 1);
                        req.getRequestDispatcher("/user/cart/checkout.jsp").forward(req, resp);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    req.setAttribute("message", "Error!!");
                    req.getRequestDispatcher("/user/errors/500.jsp").forward(req, resp);
                }
            }

        }
    }
}
