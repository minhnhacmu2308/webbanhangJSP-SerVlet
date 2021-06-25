<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.OrderModel"%>
  <%@page import="models.CategoryModel"%>
     <%@page import="models.ProductModel"%>
    <%@page import="java.util.List"%>
    <%@page import="Dao.CategoryDao"%>
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
        <script src="js/jquery-3.5.1.min.js"></script>
          <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>	
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
                  <li aria-current="page" class="breadcrumb-item active">Checkout - Order review</li>
                </ol>
              </nav>
            </div>
            <div id="checkout" class="col-lg-9">
              <div  id = "box"class="box">
              <form method="post" action="order">
                  <h1>Checkout - Order review</h1>
                  <div class="nav flex-column flex-sm-row nav-pills"><a href="checkout1.jsp" class="nav-link flex-sm-fill text-sm-center"> <i class="fa fa-map-marker">                  </i>Address</a><a href="checkout2.jsp" class="nav-link flex-sm-fill text-sm-center"> <i class="fa fa-truck">                       </i>Delivery Method</a><a href="checkout3.jsp" class="nav-link flex-sm-fill text-sm-center"> <i class="fa fa-money">                      </i>Payment Method</a><a href="#" class="nav-link flex-sm-fill text-sm-center active"> <i class="fa fa-eye">                     </i>Order Review</a></div>
             <% OrderModel order =(OrderModel) session.getAttribute("order");float total = 0.0f;%>
                  <div class="table-responsive">
                    <% if(order!=null){ %>
                       <table class="table">
                      <thead>
                        <tr>
                          <th colspan="2">Product</th>
                          <th>Quantity</th>
                          <th>Unit price</th>
                          <th colspan="2">Total</th>
                        </tr>
                      </thead>
                      <tbody>
                     <% for(int i=0 ;i< order.getItems().size() ;i++){ %>
                         <tr>
                          <td><a href="#"><img src="<%=request.getContextPath()%>/img/<%=order.getItems().get(i).getProduct().getProductPicture()%>" alt="White Blouse Armani"></a></td>
                          <td><a href="#"><%=order.getItems().get(i).getProduct().getProductName() %></a></td>
                          <td>
                            <input type="number" readonly value="<%=order.getItems().get(i).getQuantity() %>" class="form-control">
                          </td>
                          <td><%=order.getItems().get(i).getPrice() %></td>
                           <%total = total+order.getItems().get(i).getQuantity()*order.getItems().get(i).getPrice(); %>
                           <td  id="total<%=i%>"><%= order.getItems().get(i).getQuantity()*order.getItems().get(i).getPrice() %></td>
                          
                        </tr>
                        <%} %> 
                        

                      </tbody>
                      <tfoot>
                        <tr>
                          <th colspan="5">Total</th>
                          <th colspan="2"><%=total %></th>
                        </tr>
                      </tfoot>
                    </table>
                    <%} else {%>
                    	<h4>No item</h4>
                    <%} %>
                 
                  </div>
                  <!-- /.content-->
                  <div class="box-footer d-flex justify-content-between"><a href="checkout3.jsp" class="btn btn-outline-secondary"><i class="fa fa-chevron-left"></i>Back to payment method</a>
                    <a onclick="order()" class="btn btn-primary">Place an order<i class="fa fa-chevron-right"></i></a>
                  </div>
                </form>
              
              </div>
              <script type="text/javascript">
              function order(){
            		
            		
                  
             		
                	$.ajax({
                		  url: "/WebsiteBanHang/order",
                		  type:"post",
                		 
                		  success: function(data){
                			
                			var row = document.getElementById("box");
                			row.innerHTML = data;
                			 $.ajax({
                         		  url: "/WebsiteBanHang/loadcart",
                         		  type:"get",
                         		 
                         		  success: function(data){
                         			var row1 = document.getElementById("numberCart");
                         			row1.innerHTML = data;
                   
                         		
                         		  }
                         		});
                		  }
                		   
                		});
            		
            	 }
              </script>
              <!-- /.box-->
            </div>
            <!-- /.col-lg-9-->
            <div class="col-lg-3">
              <div id="order-summary" class="box">
                <div class="box-header">
                  <h3 class="mb-0">Java Jsp/servlet</h3>
                </div>
                <p class="text-muted">Shipping and additional costs are calculated based on the values you have entered.</p>
                <div class="table-responsive">
                  <!-- <table class="table">
                    <tbody>
                      <tr>
                        <td>Order subtotal</td>
                        <th></th>
                      </tr>
                      <tr>
                        <td>Shipping and handling</td>
                        <th></th>
                      </tr>
                      <tr>
                        <td>Tax</td>
                        <th></th>
                      </tr>
                      <tr class="total">
                        <td>Total</td>
                        <th></th>
                      </tr>
                    </tbody>
                  </table> -->
                </div>
              </div>
            </div>
            <!-- /.col-lg-3-->
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