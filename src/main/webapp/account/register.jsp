<%@ page import="com.t2010a.javashopping.entity.Account" %><%--
  Created by IntelliJ IDEA.
  User: PhạmMinh
  Date: 27/05/2022
  Time: 8:43 CH
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
    <title>Admin - Register</title>

    <!-- General CSS Files -->
    <link rel="stylesheet" href="/admin/assets/modules/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/admin/assets/modules/fontawesome/css/all.min.css">

    <!-- CSS Libraries -->
    <link rel="stylesheet" href="/admin/assets/modules/jquery-selectric/selectric.css">

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
                <div class="col-12 col-sm-10 offset-sm-1 col-md-8 offset-md-2 col-lg-8 offset-lg-2 col-xl-8 offset-xl-2">
                    <div class="login-brand">
                        <img src="/admin/assets/img/stisla-fill.svg" alt="logo" width="100" class="shadow-light rounded-circle">
                    </div>

                    <div class="card card-primary">
                        <div class="card-header"><h4>Register</h4></div>
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
                            <form method="POST" action="/register">
                                <div class="row">
                                    <div class="form-group col-6">
                                        <label for="username">UserName</label>
                                        <input id="username" type="text" class="form-control" name="username" autofocus value="<%=account.getUsername()%>">
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="form-group col-8">
                                        <label for="email">Email</label>
                                        <input id="email" type="email" class="form-control" name="email" value="<%=account.getEmail()%>">
                                        <%--<div class="invalid-feedback"></div>--%>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="form-group col-4">
                                        <label for="phone">Phone</label>
                                        <input id="phone" type="text" class="form-control" name="phone" value="<%=account.getPhone()%>">
                                        <%--<div class="invalid-feedback"></div>--%>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="form-group col-6">
                                        <label for="password" class="d-block">Password</label>
                                        <input id="password" type="password" class="form-control pwstrength"<%-- data-indicator="pwindicator"--%> name="password">
                                        <%--<div id="pwindicator" class="pwindicator">
                                            <div class="bar"></div>
                                            <div class="label"></div>
                                        </div>--%>
                                    </div>
                                    <div class="form-group col-6">
                                        <label for="password2" class="d-block">Password Confirmation</label>
                                        <input id="password2" type="password" class="form-control" name="password-confirm">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="custom-control custom-checkbox">
                                        <input type="checkbox" name="agree" class="custom-control-input" id="agree">
                                        <label class="custom-control-label" for="agree">I agree with the terms and conditions</label>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary btn-lg btn-block">
                                        Register
                                    </button>
                                </div>
                            </form>
                        </div>
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
<script src="/admin/assets/modules/jquery-pwstrength/jquery.pwstrength.min.js"></script>
<script src="/admin/assets/modules/jquery-selectric/jquery.selectric.min.js"></script>

<!-- Page Specific JS File -->
<script src="/admin/assets/js/page/auth-register.js"></script>

<!-- Template JS File -->
<script src="/admin/assets/js/scripts.js"></script>
<script src="/admin/assets/js/custom.js"></script>
</body>

</html>

