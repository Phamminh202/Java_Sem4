<%@ page import="com.t2010a.javashopping.entity.Product" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: PhạmMinh
  Date: 21/05/2022
  Time: 2:07 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  Product product = (Product) request.getAttribute("product");
  int action = (int) request.getAttribute("action");
  HashMap<String,String> errors = (HashMap<String, String>) request.getAttribute("errors");
  String url = "/admin/products/create";
  if(action == 2){
    url = "/admin/products/edit";
  }
  if (errors == null){
    errors = new HashMap<>();
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
          <h1>Forms</h1>
        </div>

        <div class="section-body">
          <div class="row">
            <div class="col-12 col-md-6 col-lg-6">
              <form action="<%=url%>" method="post">
                <div class="card-header">
                  <h4>Create New Product</h4>
                </div>
                <div class="card-body">
                  <div class="form-group">
                    <label for="id">Id</label>
                    <input type="text" class="form-control  col-md-2" id="id" name="id" placeholder="Enter id" value="<%=product.getId()%>" <%=action == 2 ? "readonly":""%>>
                    <%if (errors.containsKey("id")){%>
                    <span class="text-danger">* <%=errors.get("id")%></span>
                    <%}%>
                  </div>
                  <div class="form-group">
                    <label for="name">Name</label>
                    <input type="text" class="form-control  col-md-8" id="name" name="name" placeholder="Enter name"  value="<%=product.getName()%>">
                    <%if (errors.containsKey("name")){%>
                    <span class="text-danger">* <%=errors.get("name")%></span>
                    <%}%>
                  </div>
                  <div class="form-group">
                    <label for="image">Image</label>
                    <input type="text" class="form-control  col-md-8" id="image" name="image" placeholder="Enter image"  value="<%=product.getImage()%>">
                    <%if (errors.containsKey("image")){%>
                    <span class="text-danger">* <%=errors.get("image")%></span>
                    <%}%>
                  </div>
                  <div class="form-group">
                    <label for="price">Price</label>
                    <input type="number" class="form-control col-md-3" id="price" name="price" placeholder="Enter price" value="<%=product.getPrice()%>">
                    <%if (errors.containsKey("price")){%>
                    <span class="text-danger">* <%=errors.get("price")%></span>
                    <%}%>
                  </div>
                  <div class="form-group">
                    <label for="qty">Quantity</label>
                    <input type="number" class="form-control phone-number col-md-2" id="qty" name="qty" placeholder="Enter quantity" value="<%=product.getQty()%>">
                    <%if (errors.containsKey("qty")){%>
                    <span class="text-danger">* <%=errors.get("qty")%></span>
                    <%}%>
                  </div>
                  <div class="form-group">
                    <label for="color">Color</label>
                    <input type="text" class="form-control col-md-4" id="color" name="color" placeholder="Enter color" value="<%=product.getColor()%>">
                    <%if (errors.containsKey("color")){%>
                    <span class="text-danger">* <%=errors.get("color")%></span>
                    <%}%>
                  </div>
                  <div class="form-group">
                    <label for="contents">Content</label>
                    <input type="text" class="form-control col-md-12" id="contents" name="content" placeholder="Enter content" value="<%=product.getContent()%>">
                    <%if (errors.containsKey("content")){%>
                    <span class="text-danger">* <%=errors.get("content")%></span>
                    <%}%>
                  </div>
                  <div class="form-group">
                    <label for="category">Category</label>
                    <input type="text" class="form-control  col-md-4" id="category" name="category" placeholder="Enter category" value="<%=product.getCategory()%>">
                    <%if (errors.containsKey("category")){%>
                    <span class="text-danger">* <%=errors.get("category")%></span>
                    <%}%>
                  </div>
                </div>
                <div class="card-footer text-right">
                  <button class="btn btn-primary" type="submit">Submit</button>
                  <button class="btn btn-secondary" type="reset">Reset</button>
                </div>
              </form>

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

