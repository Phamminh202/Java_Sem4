<%@ page import="com.t2010a.javashopping.entity.cart.ShoppingCart" %>
<%@ page import="java.util.List" %>
<%@ page import="com.t2010a.javashopping.entity.cart.CartItem" %><%--
  Created by IntelliJ IDEA.
  User: PhạmMinh
  Date: 26/05/2022
  Time: 1:44 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingcart");
    int action = (int) request.getAttribute("action");
    double totalPrice =0;
    if (shoppingCart == null) {
        shoppingCart = new ShoppingCart();
        action = 2;
    }
%>
<!doctype html>
<html lang="zxx">
<jsp:include page="../includes/head.jsp"></jsp:include>
<body>
<jsp:include page="../includes/header.jsp"></jsp:include>

<!--================Home Banner Area =================-->
<!-- breadcrumb start-->
<jsp:include page="../includes/breadcrumb.jsp"></jsp:include>
<!-- breadcrumb start-->

<!--================Cart Area =================-->
<section class="cart_area padding_top">
    <div class="container">
        <div class="cart_inner">
            <%if (action == 1){%>
            <div class="table-responsive">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Product</th>
                        <th scope="col">Price</th>
                        <th scope="col">Quantity</th>
                        <th scope="col">Total</th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <%List<CartItem> items = shoppingCart.getListItems();
                        for (int i = 0; i < items.size(); i++) {
                            totalPrice = items.get(i).getUnitPrice() * items.get(i).getQty();%>
                        <tr>
                        <td>
                            <div class="media">
                                <div class="d-flex">
                                    <img src="<%=items.get(i).getProductImage()%>" alt="" class="img-thumbnail" width="200px"/>
                                </div>
                                <div class="media-body">
                                    <p><%=items.get(i).getProductName()%></p>
                                </div>
                            </div>
                        </td>
                        <td>
                            <h5>$<%=items.get(i).getUnitPrice()%></h5>
                        </td>
                        <td>
                            <div class="product_count">
                                <span class="input-number-decrement"> <i class="ti-angle-down"></i></span>
                                <input class="input-number" type="text" value="<%=items.get(i).getQty()%>" min="1" name="qty">
                                <span class="input-number-increment"> <i class="ti-angle-up"></i></span>
                            </div>
                        </td>
                        <td>
                            <h5>$<%=items.get(i).getUnitPrice() * items.get(i).getQty()%></h5>
                        </td>
                        <td>
                            <a class="fa fa-times-circle" style="color: black;" href="/cart/delete?id=<%=items.get(i).getProductId()%>" onclick="return confirm('Are you sure?')"></a>
                        </td>
                    </tr>
                    <%}%>
                    <tr class="bottom_button">
                        <td>
                            <a class="btn_1" href="#">Update Cart</a>
                        </td>
                        <td></td>
                        <td></td>
                        <td>
                            <div class="cupon_text float-right">
                                <a class="btn_1" href="#">Close Coupon</a>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td>
                            <h5>Subtotal</h5>
                        </td>
                        <td>
                            <h5>$<%=totalPrice%></h5>
                        </td>
                    </tr>
<%--
                    <tr class="shipping_area">
                        <td></td>
                        <td></td>
                        <td>
                            <h5>Shipping</h5>
                        </td>
                        <td>
                            <div class="shipping_box">
                                <ul class="list">
                                    <li>
                                        <a href="#">Flat Rate: $5.00</a>
                                    </li>
                                    <li>
                                        <a href="#">Free Shipping</a>
                                    </li>
                                    <li>
                                        <a href="#">Flat Rate: $10.00</a>
                                    </li>
                                    <li class="active">
                                        <a href="#">Local Delivery: $2.00</a>
                                    </li>
                                </ul>
                                <h6>
                                    Calculate Shipping
                                    <i class="fa fa-caret-down" aria-hidden="true"></i>
                                </h6>
                                <select class="shipping_select">
                                    <option value="1">Bangladesh</option>
                                    <option value="2">India</option>
                                    <option value="4">Pakistan</option>
                                </select>
                                <select class="shipping_select section_bg">
                                    <option value="1">Select a State</option>
                                    <option value="2">Select a State</option>
                                    <option value="4">Select a State</option>
                                </select>
                                <input type="text" placeholder="Postcode/Zipcode" />
                                <a class="btn_1" href="#">Update Details</a>
                            </div>
                        </td>
                    </tr>
--%>
                    </tbody>
                </table>
                <div class="checkout_btn_inner float-right">
                    <a class="btn_1" href="#">Continue Shopping</a>
                    <a class="btn_1 checkout_btn_1" href="/checkout">Proceed to checkout</a>
                </div>
            </div>
            <%}else{%>
            <h2>Your shopping cart is currently empty!</h2>
            <a href="/shop"><- Back to Shop</a>
            <%}%>
        </div>
    </div>
</section>
<!--================End Cart Area =================-->

<jsp:include page="../includes/footer.jsp"></jsp:include>
<jsp:include page="../includes/script.jsp"></jsp:include>
</body>
</html>