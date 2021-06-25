<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@page import="models.CategoryModel"%>
     <%@page import="models.ProductModel"%>
    <%@page import="java.util.List"%>
    <%@page import="Dao.CategoryDao"%>
     <%@page import="models.UserModel"%>
     <%@page import="models.OrderModel"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
     <title>Web food</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="robots" content="all,follow">
    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome CSS-->
    <link rel="stylesheet" href="vendor/font-awesome/css/font-awesome.min.css">
    <!-- Google fonts - Roboto -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,700">
    <!-- owl carousel-->
    <link rel="stylesheet" href="vendor/owl.carousel/assets/owl.carousel.css">
    <link rel="stylesheet" href="vendor/owl.carousel/assets/owl.theme.default.css">
    <!-- theme stylesheet-->
    <link rel="stylesheet" href="css/style.default.css" id="theme-stylesheet">
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet" href="css/custom.css">
    <!-- Favicon-->
    <link rel="shortcut icon" href="favicon.png">
    <!-- Tweaks for older IEs--><!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
  </head>
  <body>
    <!-- navbar-->
    <header class="header mb-5">
      <!--
      *** TOPBAR ***
      _________________________________________________________
      -->
      <jsp:include page="header/header1.jsp"></jsp:include>
    </header>
    <div id="all">
      <div id="content">
        <div class="container">
          <div class="row">
            <div class="col-lg-12">
              <!-- breadcrumb-->
              <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                  <li class="breadcrumb-item"><a href="#">Home</a></li>
                  <li aria-current="page" class="breadcrumb-item"><a href="#">My orders</a></li>
                  <li aria-current="page" class="breadcrumb-item active">Order # 1735</li>
                </ol>
              </nav>
            </div>
            <div class="col-lg-3">
              <!--
              *** CUSTOMER MENU ***
              _________________________________________________________
              -->
              <div class="card sidebar-menu">
                <div class="card-header">
                  <h3 class="h4 card-title">Customer section</h3>
                </div>
                <%  
                 UserModel user =(UserModel) session.getAttribute("user");
                 String tag = (String) request.getAttribute("tag") ;
                 List<OrderModel> newsListOrder = (List<OrderModel>) request.getAttribute("listO");
                %>
              
               
                <div class="card-body">
                  <ul class="nav nav-pills flex-column"><a href="<%=request.getContextPath()%>/myorder?tag=myOrder" class="nav-link <% if(tag != "myOrder") {%> active<%}else{%>""<%} %>"><i class="fa fa-list"></i> My orders</a>
                  <a href="<%=request.getContextPath()%>/wishlistcontroller?tag=wishlist" class="nav-link"><i class="fa fa-heart"></i> My wishlist</a>
                  <a href="detailuser?username=<%= user.getUserName()%>" class="nav-link <% if(tag == "myAccount") {%> active<%}else{%>""<%} %>"><i class="fa fa-user"></i> My account</a>
                  <a href="<%=request.getContextPath()%>/logout" class="nav-link"><i class="fa fa-sign-out"></i> Logout</a></ul>
                </div>
              </div>
              <!-- /.col-lg-3-->
              <!-- *** CUSTOMER MENU END ***-->
            </div>
             <% OrderModel ord = (OrderModel) request.getAttribute("DetailOrder"); %>
            <div id="customer-order" class="col-lg-9">
              <div class="box">
                <h1>Order #<%= ord.getOrderId() %></h1>
                <p class="lead">Order #<%= ord.getOrderId() %> was placed on <strong><%= ord.getCreateTime() %></strong> and is currently <strong>Being prepared</strong>.</p>
                <p class="text-muted">If you have any questions, please feel free to <a href="contact.jsp">contact us</a>, our customer service center is working for you 24/7.</p>
                <hr>
               
                <div class="table-responsive mb-4">
                  <table class="table">
                    <thead>
                      <tr>
                        <th colspan="2">Product</th>
                        <th>Quantity</th>
                        <th>Unit price</th>
                       
                        <th>Total</th>
                      </tr>
                    </thead>
                    <tbody>
                      <% if(ord.getItems().size()>0){ %>
                      		<% for(int i=0;i<ord.getItems().size();i++){ %>
                      		<tr>
                        <td><a href="#"><img src="<%=request.getContextPath()%>/img/<%= ord.getItems().get(i).getProduct().getProductPicture()%>" alt="White Blouse Armani"></a></td>
                        <td><a href="#"><%= ord.getItems().get(i).getProduct().getProductName()%></a></td>
                        <td><%= ord.getItems().get(i).getQuantity()%></td>
                        <td><%= ord.getItems().get(i).getPrice() %></td>
                        <% float total = ord.getItems().get(i).getPrice() * ord.getItems().get(i).getQuantity();%>
                        <td><%= total%></td>
                      </tr>
                      		<%} %>
                      <%} %>
                      
                    </tbody>
                    <%float phi = 10.00f; %>
                    <tfoot>
                      <tr>
                        <th colspan="5" class="text-right">Order subtotal</th>
                        <th><%=ord.getTotal()%></th>
                      </tr>
                      <tr>
                        <th colspan="5" class="text-right">Shipping and handling</th>
                        <th><%=phi %></th>
                      </tr>
                      <tr>
                        <th colspan="5" class="text-right">Tax</th>
                        <th>0.00</th>
                      </tr>
                      <tr>
                        <th colspan="5" class="text-right">Total</th>
                        <% float totalS =  ord.getTotal()+phi;%>
                        <th><%=totalS %></th>
                      </tr>
                    </tfoot>
                  </table>
                </div>
                <!-- /.table-responsive-->
                <div class="row addresses">
                  <div class="col-lg-6">
                    <h2>Invoice address</h2>
                    <p><%=ord.getAddress() %></p>
                  </div>
                  <div class="col-lg-6">
                    <h2>Shipping address</h2>
                   <p><%=ord.getAddress() %></p>
                   <h2>PhoneNumber Delivery</h2>
                   <p><%=ord.getPhoneNumber() %></p>
                   <h2>Payment Delivery</h2>
                   <p><%=ord.getPaymentdelivery() %></p>
                   <h2>Method Delivery</h2>
                   <p><%=ord.getMethodDelivery() %></p>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!--
    *** FOOTER ***
    _________________________________________________________
    -->
<footer>
 <jsp:include page="footer/footer1.jsp"></jsp:include>
 </footer>
    <!-- /#footer-->
    <!-- *** FOOTER END ***-->
    
    
    <!--
    *** COPYRIGHT ***
    _________________________________________________________
    -->
    <div id="copyright">
      <div class="container">
        <div class="row">
          <div class="col-lg-6 mb-2 mb-lg-0">
            <p class="text-center text-lg-left">©2019 Your name goes here.</p>
          </div>
          <div class="col-lg-6">
            <p class="text-center text-lg-right">Template design by <a href="https://bootstrapious.com/">Bootstrapious</a>
              <!-- If you want to remove this backlink, pls purchase an Attribution-free License @ https://bootstrapious.com/p/obaju-e-commerce-template. Big thanks!-->
            </p>
          </div>
        </div>
      </div>
    </div>
    <!-- *** COPYRIGHT END ***-->
    <!-- JavaScript files-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="vendor/jquery.cookie/jquery.cookie.js"> </script>
    <script src="vendor/owl.carousel/owl.carousel.min.js"></script>
    <script src="vendor/owl.carousel2.thumbs/owl.carousel2.thumbs.js"></script>
    <script src="js/front.js"></script>
  </body>
</html>