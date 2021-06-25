<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.OrderModel"%>
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
   <div role="alert" aria-live="assertive" style=" z-index:1000; position: fixed;bottom: 20px;right: 20px;width: 300px" data-delay="1500" aria-atomic="true" id="toast" class="toast" data-bs-autohide="false">
  
</div> 
    <div id="all">
      <div id="content">
        <div class="container">
          <div class="row">
            <div class="col-lg-12">
              <!-- breadcrumb-->
              <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                  <li class="breadcrumb-item"><a href="#">Home</a></li>
                  <li aria-current="page" class="breadcrumb-item active">Shopping cart</li>
                </ol>
              </nav>
            </div>
            <div id="basket" class="col-lg-9">
              <div class="box">
                <form method="get" action="checkoutone">
                  <h1>Shopping cart</h1>
                  <% OrderModel order =(OrderModel) session.getAttribute("order");UserModel user = (UserModel)session.getAttribute("user");float total = 0.0f; %>
                  <div class="table-responsive">
                    <%if(order!=null){ %>
                       <% if(order.getItems().size()>0){ %>
                       <table class="table">
                      <thead>
                        <tr>
                          <th colspan="2">Product</th>
                          <th>Quantity</th>
                          <th>Unit price</th>
                          <th colspan="2">Total</th>
                        </tr>
                      </thead>
                      <tbody id="cartItem">
                     <% for(int i=0 ;i< order.getItems().size() ;i++){  %>
                         <tr>
                          <td><a href="#"><img src="<%=request.getContextPath()%>/img/<%=order.getItems().get(i).getProduct().getProductPicture()%>" alt="White Blouse Armani"></a></td>
                          <td><a href="<%=request.getContextPath()%>/detail?productId=<%= order.getItems().get(i).getProduct().getProductId()%>"><%=order.getItems().get(i).getProduct().getProductName() %></a></td>
                          <td>
                            <input type="hidden" id="productId<%=i %>" value="<%=order.getItems().get(i).getProduct().getProductId()%>">
                            <input min="1" id="quantity<%=i %>" onclick="oncc(<%= i %>)" type="number" value="<%=order.getItems().get(i).getQuantity() %>" class="form-control">
                          </td>
                          <td id="priceCurrent<%=i%>"><%=order.getItems().get(i).getPrice()%></td>
                          <td  id="total<%=i%>"><%= order.getItems().get(i).getQuantity()*order.getItems().get(i).getPrice() %></td>
                          <%total = total+order.getItems().get(i).getQuantity()*order.getItems().get(i).getPrice(); %>
                          <td>   <a onclick="ondd(<%= i %>)"><i class="fa fa-trash-o"></i></a> <input type="hidden" id="totalS" value="<%=total%>"></td>
                         
                          
                        </tr>
                        <%} %> 
                        
                     
                        <tr>
                          <th colspan="5">Total</th>
                          <th colspan="2" id="sum"><%=total %></th>
                          <input type="hidden" name="sendSum" value="<%=total%>">
                        </tr>
                      
                      </tbody>
                      
                    </table>
                    <%} else {%>
                    	<h4>No item</h4>
                    <%} %>
                    <%} else{%>
                    <h4>No item</h4>
                    <%} %>
                 
                  
                  </div>
                  <script type="text/javascript">
                 	
                  	 function oncc(i){
                  		
                  		var quantityId = "quantity"+i ;
                  
                   		var productIdB = "productId"+i
                   		
                   		var quantity =parseInt(document.getElementById(quantityId).value);
                   		
                   		var productId = parseInt(document.getElementById(productIdB).value);
                   		
                      	$.ajax({
                      		  url: "/WebsiteBanHang/addcart",
                      		  type:"post",
                      		  data:{
                      			id:productId,
                      			quantity:quantity
                      		  },
                      		  success: function(data){
                      			var row = document.getElementById("cartItem");
                      			row.innerHTML = data;
                      		  }
                      		   
                      		});
                  		
                  	 }
                  	$(document).ready(function(){
                  	  $("#myBtn").click(function(){
                  	    $('.toast').toast('show');
                  	  });
                  	});
                function ondd(i){
                  		
                  		
                  
                   		var productIdB = "productId"+i
                   		
                   		
                   		
                   		var productId = parseInt(document.getElementById(productIdB).value);
                   		
                      	$.ajax({
                      		  url: "/WebsiteBanHang/deletecart",
                      		  type:"get",
                      		  data:{
                      			id:productId,
                      			
                      		  },
                      		  success: function(data){
                      			var row = document.getElementById("cartItem");
                      		
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
                function checkoutOne(){
              		
                  	$.ajax({
                  		  url: "/WebsiteBanHang/checkoutone",
                  		  type:"get",
                  		 
                  		  success: function(data){
                  			
                  			var row = document.getElementById("toast");
                  			row.innerHTML = data;
                  		    $(document).ready(function(){
                  		    	 $('.toast').toast('show');
                  		    });
                  		  }
                  		   
                  		});
              		
              	 }
                  	 
                  </script>
                  <!-- /.table-responsive-->
                  <div class="box-footer d-flex justify-content-between flex-column flex-lg-row">
                    <div class="left"><a href="<%= request.getContextPath()+"/home" %>" class="btn btn-outline-secondary"><i class="fa fa-chevron-left"></i> Continue shopping</a></div>
                    <div class="right">
                      <a href="#" class="btn btn-outline-secondary"><i class="fa fa-refresh"></i> Update cart</a>
                      <%if(order!=null && order.getItems().size()>0){ %>
                      <%if(user==null){%>
                       <a onclick="checkoutOne()" class="btn btn-primary">Proceed to checkout <i class="fa fa-chevron-right"></i></a>
                      <%}else{ %>
                         <% if( order.getItems().size()==0){ %>
                         <a onclick="checkoutOne()" class="btn btn-primary">Proceed to checkout <i class="fa fa-chevron-right"></i></a>
                         <%}else{ %>
                          <button href="checkoutone" class="btn btn-primary">Proceed to checkout <i class="fa fa-chevron-right"></i></button>
                         <%} %>
                      
                      <%} %>
                      <%}else{ %>
                      
                      <%} %>
                      
                     
                    </div>
                  </div>
                </form>
              </div>
              <!-- /.box-->
            <div class="row same-height-row">
                <div class="col-md-3 col-sm-6">
                  <div class="box same-height">
                    <h3>You may also like these products</h3>
                  </div>
                </div>
              <%          
                             List<ProductModel> newsListProduct1 = null;
                               
                             	if(request.getAttribute("listRe")!=null){
                             		newsListProduct1 = (List<ProductModel>) request.getAttribute("listRe");
                                	
                               %>
                          <% for(int j =0 ;j<newsListProduct1.size();j++){ %>
                <div class="col-md-3 col-sm-6">
                  <div class="product same-height">
                    <div class="flip-container">
                      <div class="flipper">
                        <div class="front"><a href="detail?productId=<%=newsListProduct1.get(j).getProductId() %>"><img src="<%=request.getContextPath()%>/img/<%=newsListProduct1.get(j).getProductPicture()  %>" alt="" class="img-fluid"></a></div>
                        <div class="back"><a href="detail?productId=<%=newsListProduct1.get(j).getProductId() %>"><img src="<%=request.getContextPath()%>/img/<%=newsListProduct1.get(j).getProductPicture()  %>" alt="" class="img-fluid"></a></div>
                      </div>
                    </div><a href="detail?productId=<%=newsListProduct1.get(j).getProductId() %>" class="invisible"><img src="<%=request.getContextPath()%>/img/<%=newsListProduct1.get(j).getProductPicture()  %>" alt="" class="img-fluid"></a>
                    <div class="text">
                      <h3><a href="detail?productId=<%=newsListProduct1.get(j).getProductId() %>"><%= newsListProduct1.get(j).getProductName() %></a></h3>
                      <p class="price"><%= newsListProduct1.get(j).getProductPrice()%></p>
                    </div>
                  </div>
                  <!-- /.product-->
                </div>
                 <%} }%>
              </div>
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
              <div class="box">
                <div class="box-header">
                  <h4 class="mb-0">Coupon code</h4>
                </div>
                <p class="text-muted">If you have a coupon code, please enter it in the box below.</p>
                <form>
                  <div class="input-group">
                    <input type="text" class="form-control"><span class="input-group-append">
                      <button type="button" class="btn btn-primary"><i class="fa fa-gift"></i></button></span>
                  </div>
                  <!-- /input-group-->
                </form>
              </div>
            </div>
            <!-- /.col-md-3-->
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