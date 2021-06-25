<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
             <script src="js/jquery-3.5.1.min.js"></script>
             <script src="js/app.js"></script>
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
     <jsp:include page="toast.jsp"></jsp:include>
    <div id="all">
      <div id="content">
        <div class="container">
          <div class="row">                       
            <div class="col-lg-12">
              <!-- breadcrumb-->
              <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                  <li class="breadcrumb-item"><a href="#">Home</a></li>
                  <li aria-current="page" class="breadcrumb-item active">Ladies</li>
                </ol>
              </nav>
              <div class="box">
                <h1>Result Search</h1>
                <p>In our Ladies department we offer wide selection of the best products we have found and carefully selected worldwide.</p>
              </div>
              <div class="box info-bar">
                  <%          
                             List<ProductModel> newsListProduct = null;
                  String keySearch = (String)request.getAttribute("keySearch") ;
                             	if(request.getAttribute("listP")!=null){
                             		newsListProduct = (List<ProductModel>) request.getAttribute("listP");
                                	
                  
                             	%>
               <%
               int tag = 12;
               
               %>
               <% if(newsListProduct.size()==0){ %>
               	 <div class="box">
                <h1>No item</h1>
                <p>Please, enter another  key search </p>
              </div>
               <%}else{ %>
                <div class="row">
                  <div class="col-md-12 col-lg-4 products-showing">Showing <strong>12</strong> of <strong>25</strong> products</div>
                  <div class="col-md-12 col-lg-7 products-number-sort">
                    <form class="form-inline d-block d-lg-flex justify-content-between flex-column flex-md-row">
                      <div class="products-number"><strong >Show</strong><a   href="<%= request.getContextPath()%>/categoryfull?number=12" <%if(tag==12){ %> class="btn btn-primary" <%}else{ %>class="btn btn-sm btn-outline-secondary" <%} %> >12</a><a href="<%= request.getContextPath()%>/categoryfull?number=24" <%if(tag==24){ %> class="btn btn-primary" <%}else{ %>class="btn  btn-sm btn-outline-secondary" <%} %>>24</a><a href="#" class="btn btn-outline-secondary btn-sm">All</a><span>products</span></div>
                      <div class="products-sort-by mt-2 mt-lg-0"><strong>Sort by</strong>
                        <select  onblur="sort(<%=keySearch %>)" name="sort-by" class="form-control">
                          <option>Price</option>
                          <option>Name</option>
                          <option>Sales first</option>
                        </select>
                      </div>
                    </form>
                  </div>
                </div>
               <%} %>
               
              </div>
           <div class="row products" id="sort">
           
                             	
                <% for(int j=0;j<newsListProduct.size();j++){ %>
                <div class="col-lg-3 col-md-4">
                  <div class="product">
                    <div class="flip-container">
                      <div class="flipper">
                        <div class="front"><a href="detail?productId=<%=newsListProduct.get(j).getProductId() %>"><img src="img/<%= newsListProduct.get(j).getProductPicture() %>" alt="" class="img-fluid"></a></div>
                        <div class="back"><a href="detail?productId=<%=newsListProduct.get(j).getProductId() %>"><img src="img/<%= newsListProduct.get(j).getProductPicture() %>" alt="" class="img-fluid"></a></div>
                      </div>
                    </div><a href="detail?productId=<%=newsListProduct.get(j).getProductId() %>" class="invisible"><img src="img/<%= newsListProduct.get(j).getProductPicture() %>" alt="" class="img-fluid"></a>
                    <div class="text">
                      <h3><a href="detail?productId=<%=newsListProduct.get(j).getProductId() %>"><%= newsListProduct.get(j).getProductName() %></a></h3>
                      <p class="price"> 
                        <del></del><%= newsListProduct.get(j).getProductPrice() %>
                      </p>
                     <input type="hidden" value="<%= newsListProduct.get(j).getProductId() %>" id="productId<%=j%>">
                      <p class="buttons"><a href="detail?productId=<%=newsListProduct.get(j).getProductId() %>" class="btn btn-outline-secondary">View detail</a><a onclick="addCart(<%=j%>)" class="btn btn-primary"><i class="fa fa-shopping-cart"></i>Add to cart</a></p>
                    </div>
                    <!-- /.text-->
                  </div>
                  <!-- /.product            -->
                </div>
                <%}} %>
                <!-- /.products-->
              </div>
               <script >
                function sort(){
                	alert("sdsdsd");
                	$.ajax({
                		  url: "/WebsiteBanHang/sortbyprice",
                		  type:"get",
						data:{
							keySearch:keySearch
						},
                		  success: function(data){
                		    var row = document.getElementById("sort");
                		    row.innerHTML = data;
                		  }
                		});
                }
                </script>
              <div class="pages">
              <% int numberPage = (int) request.getAttribute("numberPage"); ;int tagPage = (int)request.getAttribute("tagPage");%>
                <p class="loadMore"><a href="#" class="btn btn-primary btn-lg"><i class="fa fa-chevron-down"></i> Load more</a></p>
                <nav aria-label="Page navigation example" class="d-flex justify-content-center">
                  <ul class="pagination">
                    <li class="page-item"><a href="#" aria-label="Previous" class="page-link"><span aria-hidden="true">«</span><span class="sr-only">Previous</span></a></li>
                    <%  for(int i = 1 ;i <= numberPage ; i++){ %>
                     <% if(tagPage==i){ %>
                    <li class="page-item active"><a href="<%= request.getContextPath()%>/searchcontroller?page=<%=i %>&keySearch=<%=keySearch%>" class="page-link"><%= i %></a></li>
                    <%}else{ %>
                     <li class="page-item "><a href="<%= request.getContextPath()%>/searchcontroller?page=<%=i %>&keySearch=<%=keySearch%>" class="page-link"><%= i %></a></li>
                    <%} %>
                    <%} %>
                    <li class="page-item"><a href="#" aria-label="Next" class="page-link"><span aria-hidden="true">»</span><span class="sr-only">Next</span></a></li>
                  </ul>
                </nav>
              </div>
            </div>
            <!-- /.col-lg-9-->
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