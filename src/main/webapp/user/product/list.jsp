<%@ page import="com.t2010a.javashopping.entity.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.t2010a.javashopping.entity.Color" %>
<%@ page import="com.t2010a.javashopping.entity.Category" %><%--
  Created by IntelliJ IDEA.
  User: PhạmMinh
  Date: 26/05/2022
  Time: 2:11 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Product> products = (List<Product>) request.getAttribute("product");
    List<Category> categories = (List<Category>) request.getAttribute("category");
    List<Color> colors = (List<Color>) request.getAttribute("color");
    if (products == null){
        products = new ArrayList<>();
    }
    if (categories == null){
        categories = new ArrayList<>();
    }
    if (colors == null){
        colors = new ArrayList<>();
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

<!--================Category Product Area =================-->
<section class="cat_product_area section_padding">
    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <form action="/shop"></form>
                <div class="left_sidebar_area">
                    <aside class="left_widgets p_filter_widgets">
                        <div class="l_w_title">
                            <h3>Browse Categories</h3>
                        </div>
                        <div class="widgets_inner">
                            <ul class="list">
                                <li>
                                    <a href="#">Frozen Fish</a>
                                    <span>(250)</span>
                                </li>
                                <li>
                                    <a href="#">Dried Fish</a>
                                    <span>(250)</span>
                                </li>
                            </ul>
                        </div>
                    </aside>

                    <aside class="left_widgets p_filter_widgets">
                        <div class="l_w_title">
                            <h3>Product filters</h3>
                        </div>
                        <div class="widgets_inner">
                            <ul class="list">
                                <li>
                                    <a href="#">Apple</a>
                                </li>
                                <li>
                                    <a href="#">Asus</a>
                                </li>
                                <li class="active">
                                    <a href="#">Gionee</a>
                                </li>
                                <li>
                                    <a href="#">Micromax</a>
                                </li>
                                <li>
                                    <a href="#">Samsung</a>
                                </li>
                            </ul>
                            <ul class="list">
                                <li>
                                    <a href="#">Apple</a>
                                </li>
                                <li>
                                    <a href="#">Asus</a>
                                </li>
                                <li class="active">
                                    <a href="#">Gionee</a>
                                </li>
                                <li>
                                    <a href="#">Micromax</a>
                                </li>
                                <li>
                                    <a href="#">Samsung</a>
                                </li>
                            </ul>
                        </div>
                    </aside>

                    <aside class="left_widgets p_filter_widgets">
                        <div class="l_w_title">
                            <h3>Color Filter</h3>
                        </div>
                        <div class="widgets_inner">
                            <ul class="list">
                                <li>
                                    <a href="#">Black</a>
                                </li>
                                <li>
                                    <a href="#">Black Leather</a>
                                </li>
                                <li class="active">
                                    <a href="#">Black with red</a>
                                </li>
                                <li>
                                    <a href="#">Gold</a>
                                </li>
                                <li>
                                    <a href="#">Spacegrey</a>
                                </li>
                            </ul>
                        </div>
                    </aside>

                    <aside class="left_widgets p_filter_widgets price_rangs_aside">
                        <div class="l_w_title">
                            <h3>Price Filter</h3>
                        </div>
                        <div class="widgets_inner">
                            <div class="range_item">
                                <!-- <div id="slider-range"></div> -->
                                <input type="text" class="js-range-slider" value="" />
                                <div class="d-flex">
                                    <div class="price_text">
                                        <p>Price :</p>
                                    </div>
                                    <div class="price_value d-flex justify-content-center">
                                        <input type="text" class="js-input-from" id="amount" readonly />
                                        <span>to</span>
                                        <input type="text" class="js-input-to" id="amount" readonly />
                                    </div>
                                </div>
                            </div>
                        </div>
                    </aside>
                </div>
            </div>
            <div class="col-lg-9">
                <div class="row">
                    <div class="col-lg-12">
                        <form action="/shop">
                            <div class="product_top_bar d-flex justify-content-between align-items-center">
                                <div class="single_product_menu d-flex">
                                    <h5>Category : </h5>
                                    <select name="category_id">
                                        <%for (int i = 0; i < categories.size(); i++) {%>
                                            <option value="<%=categories.get(i).getId()%>"><%=categories.get(i).getName()%></option>
                                        <%}%>
                                    </select>
                                </div>
                                <div class="single_product_menu d-flex">
                                    <h5>Color : </h5>
                                    <select name="color_id">
                                        <%for (int i = 0; i < colors.size(); i++) {%>
                                            <option value="<%=colors.get(i).getId()%>"><%=colors.get(i).getName()%></option>
                                        <%}%>
                                    </select>
                                </div>
                                <div class="single_product_menu d-flex">
                                    <h5>Limit : </h5>
                                    <select name="limit">
                                        <option data-display="Select">15</option>
                                        <option value="20">20</option>
                                        <option value="25">25</option>
                                    </select>
                                </div>

                                <div class="single_product_menu d-flex">
                                    <button type="submit">Find</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>

                <div class="row align-items-center latest_product_inner">
                    <%for (Product product:products){%>
                    <div class="col-lg-4 col-sm-6">
                            <div class="single_product_item">
                                <a href="/product?id=<%=product.getId()%>"><img src="<%=product.getImage()%>" alt="" class="img-thumbnail" width="265px"></a>
                                <div class="single_product_text">
                                    <h4><%=product.getName()%></h4>
                                    <h3>$<%=product.getPrice()%></h3>
                                    <a href="/cart/add?id=<%=product.getId()%>&qty=1" class="add_cart">+ Add to cart</a>
                                    <a href="/product?id=<%=product.getId()%>"><i class="ti-search"></i></a>
                                </div>
                            </div>
                        </div>
                    <%}%>
                    <div class="col-lg-12">
                        <div class="pageination">
                            <nav aria-label="Page navigation example">
                                <ul class="pagination justify-content-center">
                                    <li class="page-item">
                                        <a class="page-link" href="#" aria-label="Previous">
                                            <i class="ti-angle-double-left"></i>
                                        </a>
                                    </li>
                                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                                    <li class="page-item"><a class="page-link" href="#">4</a></li>
                                    <li class="page-item"><a class="page-link" href="#">5</a></li>
                                    <li class="page-item"><a class="page-link" href="#">6</a></li>
                                    <li class="page-item">
                                        <a class="page-link" href="#" aria-label="Next">
                                            <i class="ti-angle-double-right"></i>
                                        </a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!--================End Category Product Area =================-->

<!-- product_list part start-->
<section class="product_list best_seller">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-12">
                <div class="section_tittle text-center">
                    <h2>Best Sellers <span>shop</span></h2>
                </div>
            </div>
        </div>
        <div class="row align-items-center justify-content-between">
            <div class="col-lg-12">
                <div class="best_product_slider owl-carousel">
                    <div class="single_product_item">
                        <img src="/user/content/img/product/product_1.png" alt="">
                        <div class="single_product_text">
                            <h4>Quartz Belt Watch</h4>
                            <h3>$150.00</h3>
                        </div>
                    </div>
                    <div class="single_product_item">
                        <img src="/user/content/img/product/product_2.png" alt="">
                        <div class="single_product_text">
                            <h4>Quartz Belt Watch</h4>
                            <h3>$150.00</h3>
                        </div>
                    </div>
                    <div class="single_product_item">
                        <img src="/user/content/img/product/product_3.png" alt="">
                        <div class="single_product_text">
                            <h4>Quartz Belt Watch</h4>
                            <h3>$150.00</h3>
                        </div>
                    </div>
                    <div class="single_product_item">
                        <img src="/user/content/img/product/product_4.png" alt="">
                        <div class="single_product_text">
                            <h4>Quartz Belt Watch</h4>
                            <h3>$150.00</h3>
                        </div>
                    </div>
                    <div class="single_product_item">
                        <img src="/user/content/img/product/product_5.png" alt="">
                        <div class="single_product_text">
                            <h4>Quartz Belt Watch</h4>
                            <h3>$150.00</h3>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- product_list part end-->

<!--::footer_part start::-->
<jsp:include page="../includes/footer.jsp"></jsp:include>
<!--::footer_part end::-->
<jsp:include page="../includes/script.jsp"></jsp:include>
</body>
</html>
