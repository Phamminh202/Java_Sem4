<%@ page import="com.t2010a.javashopping.entity.Product" %>
<%@ page import="com.t2010a.javashopping.entity.Color" %>
<%@ page import="java.util.List" %>
<%@ page import="com.t2010a.javashopping.entity.Category" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: PhạmMinh
  Date: 21/05/2022
  Time: 9:44 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Product product = (Product) request.getAttribute("product");
    List<Color> colors = (List<Color>) request.getAttribute("color");
    List<Category> categories = (List<Category>) request.getAttribute("category");
    if (colors == null){
        colors = new ArrayList<>();
    }
    if (categories == null){
        colors = new ArrayList<>();
    }
%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../includes/head.jsp"></jsp:include>
<body>
<div id="app">
    <div class="main-wrapper main-wrapper-1">
        <jsp:include page="../includes/navbar.jsp"></jsp:include>
        <jsp:include page="../includes/sidebar.jsp"></jsp:include>
        <!-- Main Content -->
        <div class="main-content">
            <section class="section">
                <div class="section-header">
                    <h1>Details Product</h1>
                </div>
                <div class="section-body">
                    <div class="row mt-sm-4">
                        <div class="col-12 col-md-12 col-lg-4">
                            <div class="card profile-widget">
                                <img src="<%=product.getImage()%>" class="img-thumbnail">
                            </div>
                        </div>
                        <div class="col-12 col-md-12 col-lg-8">
                            <h3 class="my-3"><%=product.getName()%></h3>
                            <p><%=product.getContent()%></p>
                            <hr>
                            <h4>Colors</h4>
                            <div class="btn-group btn-group-toggle" data-toggle="buttons">
                                <%for (Color cl : colors){%>
                                    <%if(product.getColor_id() == cl.getId()){%>
                                        <p><%=cl.getName()%></p>
                                    <%}%>
                                <%}%>
                                <br>
                            </div>
                            <h4>Category</h4>
                            <div class="btn-group btn-group-toggle" data-toggle="buttons">
                                <%for (Category ct : categories){%>
                                    <%if(product.getCategory_id() == ct.getId()){%>
                                        <p><%=ct.getName()%></p>
                                    <%}%>
                                <%}%>
                                <br>
                            </div>
                            <div class="bg-gray py-2 px-3 mt-4">
                                <h2 class="mb-0">
                                    $80.00
                                </h2>
                                <h4 class="mt-0">
                                    <small>Ex Tax: $80.00 </small>
                                </h4>
                            </div>

                            <div class="mt-4">
                                <div class="btn btn-primary btn-lg btn-flat">
                                    <i class="fas fa-cart-plus fa-lg mr-2"></i>
                                    Add to Cart
                                </div>

                                <div class="btn btn-default btn-lg btn-flat">
                                    <i class="fas fa-heart fa-lg mr-2"></i>
                                    Add to Wishlist
                                </div>
                            </div>

                            <div class="mt-4 product-share">
                                <a href="#" class="text-gray">
                                    <i class="fab fa-facebook-square fa-2x"></i>
                                </a>
                                <a href="#" class="text-gray">
                                    <i class="fab fa-twitter-square fa-2x"></i>
                                </a>
                                <a href="#" class="text-gray">
                                    <i class="fas fa-envelope-square fa-2x"></i>
                                </a>
                                <a href="#" class="text-gray">
                                    <i class="fas fa-rss-square fa-2x"></i>
                                </a>
                            </div>

                        </div>
                    </div>
                </div>
            </section>
        </div>
        <jsp:include page="../includes/footer.jsp"></jsp:include>
    </div>
</div>

<jsp:include page="../includes/script.jsp"></jsp:include>

</body>

</html>