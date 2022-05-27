<%@ page import="com.t2010a.javashopping.entity.Account" %><%--
  Created by IntelliJ IDEA.
  User: PhạmMinh
  Date: 27/05/2022
  Time: 8:42 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Account account = (Account) request.getAttribute("account");
    if (account == null){
        account = new Account();
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no" name="viewport">
    <title>Admin - Login</title>

    <!-- General CSS Files -->
    <link rel="stylesheet" href="/admin/assets/modules/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/admin/assets/modules/fontawesome/css/all.min.css">

    <!-- CSS Libraries -->
    <link rel="stylesheet" href="/admin/assets/modules/bootstrap-social/bootstrap-social.css">

    <!-- Template CSS -->
    <link rel="stylesheet" href="/admin/assets/css/style.css">
    <link rel="stylesheet" href="/admin/assets/css/components.css">
    <!-- Start GA -->
    <script async src="https://www.googletagmanager.com/gtag/js?id=UA-94034622-3"></script>
    <script>
        window.dataLayer = window.dataLayer || [];
        function gtag(){dataLayer.push(arguments);}
        gtag('js', new Date());

        gtag('config', 'UA-94034622-3');
    </script>
    <!-- /END GA --></head>
<body>
<div id="app">
    <section class="section">
        <div class="container mt-5">
            <div class="row">
                <div class="col-12 col-sm-8 offset-sm-2 col-md-6 offset-md-3 col-lg-6 offset-lg-3 col-xl-4 offset-xl-4">
                    <div class="login-brand">
                        <img src="/admin/assets/img/stisla-fill.svg" alt="logo" width="100" class="shadow-light rounded-circle">
                    </div>

                    <div class="card card-primary">
                        <div class="card-header"><h4>Login</h4></div>
                        <%if (account.getListErrors().size() > 0){%>
                        <h6 class="error_form" style="color: #0d0d0d;font-size: 14px;border-top: 2px solid red;background: #f5f5f5;padding: 23px 30px 18px;margin-bottom: 50px;">Please enter information below
                            <ul style="margin-left: 20px;margin-top: 10px;">
                                <%for (int i = 0; i < account.getListErrors().size(); i++) {%>
                                <li><%=account.getListErrors().get(i)%></li>
                                <%}%>
                            </ul>
                        </h6>
                        <%}%>
                        <div class="card-body">
                            <form method="POST" action="/login" class="needs-validation" novalidate="">
                                <div class="form-group">
                                    <label for="username">Username</label>
                                    <input id="username" type="text" class="form-control" name="username" tabindex="1" required autofocus>
                                    <div class="invalid-feedback">
                                        Please fill in your email
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="d-block">
                                        <label for="password" class="control-label">Password</label>
                                        <div class="float-right">
                                            <a href="auth-forgot-password.html" class="text-small">
                                                Forgot Password?
                                            </a>
                                        </div>
                                    </div>
                                    <input id="password" type="password" class="form-control" name="password" tabindex="2" required>
                                    <div class="invalid-feedback">
                                        Please fill in your password
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="custom-control custom-checkbox">
                                        <input type="checkbox" name="remember" class="custom-control-input" tabindex="3" id="remember-me">
                                        <label class="custom-control-label" for="remember-me">Remember Me</label>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary btn-lg btn-block" tabindex="4">
                                        Login
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="mt-5 text-muted text-center">
                        Don't have an account? <a href="/register">Create One</a>
                    </div>
                    <div class="simple-footer">
                        Copyright &copy; Stisla <script>document.write(new Date().getFullYear())</script>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>

<!-- General JS Scripts -->
<script src="/admin/assets/modules/jquery.min.js"></script>
<script src="/admin/assets/modules/popper.js"></script>
<script src="/admin/assets/modules/tooltip.js"></script>
<script src="/admin/assets/modules/bootstrap/js/bootstrap.min.js"></script>
<script src="/admin/assets/modules/nicescroll/jquery.nicescroll.min.js"></script>
<script src="/admin/assets/modules/moment.min.js"></script>
<script src="/admin/assets/js/stisla.js"></script>

<!-- JS Libraies -->

<!-- Page Specific JS File -->

<!-- Template JS File -->
<script src="/admin/assets/js/scripts.js"></script>
<script src="/admin/assets/js/custom.js"></script>
</body>

</html>
