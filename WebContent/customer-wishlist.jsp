<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@page import="models.CategoryModel"%>
     <%@page import="models.ProductModel"%>
    <%@page import="java.util.List"%>
    <%@page import="Dao.CategoryDao"%>
     <%@page import="models.UserModel"%>
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
                  <li aria-current="page" class="breadcrumb-item active">My wishlist</li>
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
                 <% String tag = (String) request.getAttribute("tag") ;
                 UserModel user =(UserModel) session.getAttribute("user");
                %>
                <div class="card-body">
                  <ul class="nav nav-pills flex-column"><a href="<%=request.getContextPath()%>/myorder?tag=myOrder" class="nav-link <% if(tag == "myOrder") {%> active<%}else{%>""<%} %>"><i class="fa fa-list"></i> My orders</a>
                  <a href="customer-wishlist.jsp" class="nav-link <% if(tag != "wishlist") {%> active<%}else{%>""<%} %>"><i class="fa fa-heart"></i> My wishlist</a>
                  <a href="detailuser?username=<%= user.getUserName()%>" class="nav-link"><i class="fa fa-user"></i> My account</a><a href="<%=request.getContextPath()%>/logout" class="nav-link"><i class="fa fa-sign-out"></i> Logout</a></ul>
                </div>
              </div>
              <!-- /.col-lg-3-->
              <!-- *** CUSTOMER MENU END ***-->
            </div>
            <div id="wishlist" class="col-lg-9">
              <ul class="breadcrumb">
                <li><a href="#">Home</a></li>
                <li>Ladies</li>
              </ul>
              <div class="box">
                <h1>My wishlist</h1>
                <p class="lead">Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.</p>
              </div>
              <div class="row products">
               <%          
                             List<ProductModel> newsListProduct = null;
                               
                             	if(request.getAttribute("listP")!=null){
                             		newsListProduct = (List<ProductModel>) request.getAttribute("listP");
                                	
                               %>
              <%if(newsListProduct.size()>0){ %>
                   <% for(int j=0;j<newsListProduct.size();j++){ %>
              <div class="col-lg-3 col-md-4">
                  <div class="product">
                    <div class="flip-container">
                      <div class="flipper">
                        <div class="front"><a href="detail?productId=<%=newsListProduct.get(j).getProductId() %>"><img src="<%=request.getContextPath()%>/img/<%= newsListProduct.get(j).getProductPicture() %>" alt="" class="img-fluid"></a></div>
                        <div class="back"><a href="detail?productId=<%=newsListProduct.get(j).getProductId() %>"><img src="<%=request.getContextPath()%>/img/<%= newsListProduct.get(j).getProductPicture() %>" alt="" class="img-fluid"></a></div>
                      </div>
                    </div><a href="detail?productId=<%=newsListProduct.get(j).getProductId() %>" class="invisible"><img src="<%=request.getContextPath()%>/img/<%= newsListProduct.get(j).getProductPicture() %>" alt="" class="img-fluid"></a>
                    <div class="text">
                      <h3><a href="detail?productId=<%=newsListProduct.get(j).getProductId() %>"><%= newsListProduct.get(j).getProductName() %></a></h3>
                      <p class="price" style="margin-top:-8px"> 
                        <del></del><%= newsListProduct.get(j).getProductPrice() %>
                      </p>
                      <p class="buttons"><a href="detail?productId=<%=newsListProduct.get(j).getProductId() %>" class="btn btn-outline-secondary">View detail</a><a href="<%=request.getContextPath()%>/addcart?productId=<%=newsListProduct.get(j).getProductId() %>" class="btn btn-primary"><i class="fa fa-shopping-cart"></i>Add to cart</a></p>
                      <p class="buttons" style="margin-top:-15px"><a href="deletewishlist?productId=<%=newsListProduct.get(j).getProductId() %>" class="btn btn-outline-danger">Delete</a></p>
                    </div>
                    <!-- /.text-->
                  </div>
                  <!-- /.product            -->
               
                </div>
                <%} %>
              <%} else{%>
              <div class="box" style="margin-left:16px">
                <h1>No item</h1>
                <p class="lead">Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.</p>
              </div>
              <%} }%>                 
           
           </div>
                <!-- /.products-->
              
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