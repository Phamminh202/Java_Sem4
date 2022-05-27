package com.t2010a.javashopping.controller.account;

import com.t2010a.javashopping.entity.Account;
import com.t2010a.javashopping.model.AccountModel;
import com.t2010a.javashopping.model.MySqlAccountModel;
import com.t2010a.javashopping.util.PassHash;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    private AccountModel accountModel;

    public RegisterServlet() {
        this.accountModel = new MySqlAccountModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("account",new Account());
        req.getRequestDispatcher("/account/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String confirmPassword = req.getParameter("password-confirm");
        Account account = new Account();
        account.setUsername(username);
        account.setPasswordNoHash(password);
        account.setPasswordConfirm(confirmPassword);
        account.setEmail(email);
        account.setPhone(phone);
        if (accountModel.findByUsername(username) != null){
            account.addErrors("username","Username is exists");
        }
        if (accountModel.findByEmail(email) != null){
            account.addErrors("email","Email is exists");
        }
        if (account.isValid()){
            account.setSalt(PassHash.randomString(12));
            account.setPassword(PassHash.encode(account.getPasswordNoHash(),account.getSalt()));
            accountModel.save(account);
            resp.sendRedirect("/login");
        }else {
            req.setAttribute("account",account);
            req.getRequestDispatcher("/account/register.jsp").forward(req,resp);
        }

    }
}
