<%@ page import="com.t2010a.javashopping.entity.cart.ShoppingCart" %>
<%@ page import="com.t2010a.javashopping.entity.cart.CartItem" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: PhạmMinh
  Date: 27/05/2022
  Time: 5:08 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingcart");
    int action = (int) request.getAttribute("action");
    if (shoppingCart == null) {
        shoppingCart = new ShoppingCart();
        action = 2;
    }
%>
<!doctype html>
<html lang="zxx">

<jsp:include page="../includes/head.jsp"></jsp:include>
<body>
<!--::header part start::-->

<jsp:include page="../includes/header.jsp"></jsp:include>
<!-- Header part end-->

<!--================Home Banner Area =================-->
<!-- breadcrumb start-->
<jsp:include page="../includes/breadcrumb.jsp"></jsp:include>
<!-- breadcrumb start-->

<!--================Checkout Area =================-->
<section class="checkout_area padding_top">
    <div class="container">
        <%--<div class="returning_customer">
            <div class="check_title">
                <h2>
                    Returning Customer?
                    <a href="/login">Click here to login</a>
                </h2>
            </div>
            <p>
                If you have shopped with us before, please enter your details in the
                boxes below. If you are a new customer, please proceed to the
                Billing & Shipping section.
            </p>
            <form class="row contact_form" action="#" method="post" novalidate="novalidate">
                <div class="col-md-6 form-group p_star">
                    <input type="text" class="form-control" id="name" name="name" value=" " />
                    <span class="placeholder" data-placeholder="Username or Email"></span>
                </div>
                <div class="col-md-6 form-group p_star">
                    <input type="password" class="form-control" id="password" name="password" value="" />
                    <span class="placeholder" data-placeholder="Password"></span>
                </div>
                <div class="col-md-12 form-group">
                    <button type="submit" value="submit" class="btn_3">
                        Log in
                    </button>
                    <div class="creat_account">
                        <input type="checkbox" id="f-option" name="selector" />
                        <label for="f-option">Remember me</label>
                    </div>
                    <a class="lost_pass" href="/login">Lost your password?</a>
                </div>
            </form>
        </div>--%>
        <%--<div class="cupon_area">
            <div class="check_title">
                <h2>
                    Have a coupon?
                    <a href="#">Click here to enter your code</a>
                </h2>
            </div>
            <input type="text" placeholder="Enter coupon code" />
            <a class="tp_btn" href="#">Apply Coupon</a>
        </div>--%>
        <%if (action ==1){%>
        <div class="billing_details">
            <div class="row">
                <form class="row contact_form" action="/checkout" method="post" novalidate="novalidate">
                    <div class="col-lg-8">
                    <h3>Billing Details</h3>
                        <div class="col-md-5 form-group p_star">
                            <input type="text" class="form-control" id="first" name="firstname" placeholder="First name"/>
                        </div>
                        <div class="col-md-5 form-group p_star">
                            <input type="text" class="form-control" id="last" name="lastname" placeholder="Last name"/>
                        </div>
                        <div class="col-md-3 form-group p_star">
                            <input type="text" class="form-control" id="number" name="shipPhone" placeholder="Phone"/>
                        </div>
                        <div class="col-md-5 form-group p_star">
                            <input type="text" class="form-control" id="email" name="shipAddress" placeholder="Address"/>
                        </div>
                        <div class="col-md-12 form-group">
                            <textarea class="form-control" name="shipNote" id="message" rows="1"
                                      placeholder="Order Notes"></textarea>
                        </div>
                        <div class="col-md-12 form-group">
                            <div class="creat_account">
                                <input type="checkbox" id="f-option2" name="selector" />
                                <label for="f-option2">Create an account?</label>
                            </div>
                        </div>

                </div>
                    <div class="col-lg-4">
                    <div class="order_box">
                        <h2>Your Order</h2>
                        <ul class="list">
                            <li>
                                <a>Product
                                    <span>Total</span>
                                </a>
                            </li>
                            <%List<CartItem> items = shoppingCart.getListItems();
                            double totalprice =0;
                                for (int i = 0; i < items.size(); i++) {
                                    totalprice +=(items.get(i).getQty()*items.get(i).getUnitPrice());%>
                                <li>
                                    <a href="/product?id=<%=items.get(i).getProductId()%>"><%=items.get(i).getProductName()%>
                                        <span class="middle">x <%=items.get(i).getQty()%></span>
                                        <span class="last">$<%=items.get(i).getUnitPrice() * items.get(i).getQty()%></span>
                                    </a>
                                </li>
                            <%}%>
                        </ul>
                        <ul class="list list_2">
                            <li>
                                <a>Subtotal
                                    <span>$<%=totalprice%></span>
                                </a>
                            </li>
                            <%--<li>
                                <a href="#">Shipping
                                    <span>Flat rate: $50.00</span>
                                </a>
                            </li>--%>
                            <input name="totalPrice" type="hidden" value="<%=totalprice%>">
                            <li>
                                <a href="">Total
                                    <span>$<%=totalprice%></span>
                                </a>
                            </li>
                        </ul>
                        <div class="payment_item">
                            <div class="radion_btn">
                                <input type="radio" id="f-option5" name="selector" />
                                <label for="f-option5">Check payments</label>
                                <div class="check"></div>
                            </div>
                        </div>
                        <div class="payment_item active">
                            <div class="radion_btn">
                                <input type="radio" id="f-option6" name="selector" />
                                <label for="f-option6">Paypal </label>
                                <img src="/user/content/img/product/single-product/card.jpg" alt="" />
                                <div class="check"></div>
                            </div>
                        </div>
                        <div class="creat_account">
                            <input type="checkbox" id="f-option4" name="selector" />
                            <label for="f-option4">I’ve read and accept the </label>
                            <a href="#">terms & conditions*</a>
                        </div>
                        <button class="btn_3" type="submit">Proceed to checkout</button>
                    </div>
                </div>
                </form>
            </div>
        </div>
        <%}else{%>
            <h2>Your shopping cart is currently empty!</h2>
            <a href="/shop"><- Back to Shop</a>
        <%}%>
    </div>
</section>
<!--================End Checkout Area =================-->


<jsp:include page="../includes/footer.jsp"></jsp:include>
<jsp:include page="../includes/script.jsp"></jsp:include>
</body>
</html>