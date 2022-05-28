<%@ page import="com.t2010a.javashopping.entity.cart.ShoppingCart" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.t2010a.javashopping.entity.myenum.ShoppingCartStatus" %><%--
  Created by IntelliJ IDEA.
  User: PhạmMinh
  Date: 28/05/2022
  Time: 12:22 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<ShoppingCart> shoppingCart = (ArrayList<ShoppingCart>) request.getAttribute("shoppingCart");
    if (shoppingCart == null) {
        shoppingCart = new ArrayList<>();
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
                <h2 class="section-title"><a href="/admin/products/create">Create New Product</a></h2>
                <div class="section-body">
                    <div class="row">
                        <div class="col-12">
                            <div class="card">
                                <div class="card-header">
                                    <h4>List Product</h4>
                                </div>
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table class="table table-striped" id="table-1">
                                            <thead>
                                            <tr>
                                                <th>User</th>
                                                <th>Ship Name</th>
                                                <th>Ship Phone</th>
                                                <th>Ship Address</th>
                                                <th>Ship Note</th>
                                                <th>Total Price</th>
                                                <th>Status</th>
                                                <th>Action</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <%for (ShoppingCart sc : shoppingCart){%>
                                            <tr>
                                                <th><%=sc.getUserId()%></th>
                                                <th><%=sc.getShipName()%></th>
                                                <th><%=sc.getShipPhone()%></th>
                                                <th><%=sc.getShipAddress()%></th>
                                                <th><%=sc.getShipNote()%></th>
                                                <th><%=sc.getTotalPrice()%></th>
                                                <th>
                                                    <%if (sc.getStatus() == ShoppingCartStatus.ACTIVE){%>
                                                    <div class="badge badge-success">Not approved yet</div>
                                                    <%}%>
                                                    <%if (sc.getStatus() == ShoppingCartStatus.DEACTIVE){%>
                                                    <div class="badge badge-danger">Approved</div>
                                                    <%}%>
                                                </th>
                                                <th>
                                                    <a href="/admin/cart/detail?id=<%=sc.getId()%>"><i class="fas fa-arrow-circle-right"></i></a>
                                                </th>
                                            </tr>
                                            <%}%>
                                            </tbody>
                                        </table>
                                    </div>
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
