package com.t2010a.javashopping.account;

import com.t2010a.javashopping.entity.Account;
import com.t2010a.javashopping.model.AccountModel;
import com.t2010a.javashopping.model.MySqlAccountModel;
import com.t2010a.javashopping.util.PassHash;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private AccountModel accountModel;

    public LoginServlet() {
        this.accountModel = new MySqlAccountModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/account/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Account account = accountModel.findByUsername(username);
        if (account != null) {
            boolean loginSuccess = PassHash.checkPassword(account.getPassword(), password, account.getSalt());
            if (!loginSuccess) {
                account.addErrors("username", "Invalid information");
            }
        } else {
            account = new Account();
            account.addErrors("username", "Invalid information");
        }
        if (account.getListErrors().size() > 0) {
            req.setAttribute("account", account);
            req.getRequestDispatcher("/account/login.jsp").forward(req, resp);
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("currentLogin", account);
            resp.sendRedirect("/home");
        }
    }
}
