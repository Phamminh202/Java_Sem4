<%@ page import="com.t2010a.javashopping.entity.Product" %><%--
  Created by IntelliJ IDEA.
  User: PhạmMinh
  Date: 21/05/2022
  Time: 9:44 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Product product = (Product) request.getAttribute("product");
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
                    <h1>Detail Product</h1>
                </div>
                <div class="section-body">
                    <div class="row mt-sm-4">
                        <div class="col-12 col-md-12 col-lg-10">
                            <div class="card profile-widget">
                                <div class="profile-widget-header">
                                    <img alt="image" src="../assets/img/avatar/avatar-1.png" class="rounded-circle profile-widget-picture">
                                    <div class="profile-widget-items">
                                        <div class="profile-widget-item">
                                            <div class="profile-widget-item-label">Posts</div>
                                            <div class="profile-widget-item-value">187</div>
                                        </div>
                                        <div class="profile-widget-item">
                                            <div class="profile-widget-item-label">Followers</div>
                                            <div class="profile-widget-item-value">6,8K</div>
                                        </div>
                                        <div class="profile-widget-item">
                                            <div class="profile-widget-item-label">Following</div>
                                            <div class="profile-widget-item-value">2,1K</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="profile-widget-description">
                                    <div class="profile-widget-name"><%=product.getName()%> <div class="text-muted d-inline font-weight-normal"><div class="slash"></div> <%=product.getCategory()%></div></div>
                                    <%=product.getContent()%>
                                </div>
                                <div class="card-footer text-center">
                                    <div class="font-weight-bold mb-2">Follow Ujang On</div>
                                    <a href="#" class="btn btn-social-icon btn-facebook mr-1">
                                        <i class="fab fa-facebook-f"></i>
                                    </a>
                                    <a href="#" class="btn btn-social-icon btn-twitter mr-1">
                                        <i class="fab fa-twitter"></i>
                                    </a>
                                    <a href="#" class="btn btn-social-icon btn-github mr-1">
                                        <i class="fab fa-github"></i>
                                    </a>
                                    <a href="#" class="btn btn-social-icon btn-instagram">
                                        <i class="fab fa-instagram"></i>
                                    </a>
                                </div>
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