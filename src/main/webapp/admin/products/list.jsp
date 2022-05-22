<%@ page import="java.util.List" %>
<%@ page import="com.t2010a.javashopping.entity.Product" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: PhạmMinh
  Date: 20/05/2022
  Time: 11:34 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Product> products = (List<Product>) request.getAttribute("listProduct");
    if (products == null){
        products = new ArrayList<>();
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
                                                <th>Id</th>
                                                <th>Name</th>
                                                <th>Image</th>
                                                <th>Price</th>
                                                <th>Quantity</th>
                                                <th>Color</th>
                                                <th>Content</th>
                                                <th>Category</th>
                                                <th>Create At</th>
                                                <th>Update At</th>
                                                <th>Status</th>
                                                <th>Action</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <%for (Product pd : products){%>
                                            <tr>
                                                <th><%=pd.getId()%></th>
                                                <th><%=pd.getName()%></th>
                                                <th><%=pd.getImage()%></th>
                                                <th><%=pd.getPrice()%></th>
                                                <th><%=pd.getQty()%></th>
                                                <th><%=pd.getColor()%></th>
                                                <th><%=pd.getContent()%></th>
                                                <th><%=pd.getCategory()%></th>
                                                <th><%=pd.getCreatedAt()%></th>
                                                <th><%=pd.getUpdatedAt()%></th>
                                                <th>
                                                    <%if (pd.getQty() > 0){%>
                                                        <div class="badge badge-success">Stocking</div>
                                                    <%}%>
                                                    <%if (pd.getQty() == 0){%>
                                                        <div class="badge badge-danger">Out of stock</div>
                                                    <%}%>
                                                </th>
                                                <th>
                                                    <a href="/admin/products/detail?id=<%=pd.getId()%>"><i class="fas fa-arrow-circle-right"></i></a>
                                                    <a href="/admin/products/edit?id=<%=pd.getId()%>"><i class="fa fa-pencil-alt"></i></a>
                                                    <a href="/admin/products/delete?id=<%=pd.getId()%>" onclick="return confirm('Are you sure?')"><i class="fas fa-trash"></i></a>
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