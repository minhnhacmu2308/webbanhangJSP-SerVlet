<%@page contentType="text/html" pageEncoding="UTF-8"%>
     <%@page import="models.CategoryModel"%>
    <%@page import="java.util.List"%>
    <%@page import="Dao.CategoryDao"%>
    <%@page import="models.UserModel"%>
     <%@page import="models.OrderModel"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>ok </title>
</head>
<body>
   <div id="top">
        <div class="container">
          <div class="row">
            <div class="col-lg-6 offer mb-3 mb-lg-0"><a href="#" class="btn btn-success btn-sm">Offer of the day</a><a href="#" class="ml-1">Get flat 35% off on orders over $50!</a></div>
            <div class="col-lg-6 text-center text-lg-right">
              <ul class="menu list-inline mb-0">
                <%
                       UserModel user =(UserModel) session.getAttribute("user");
                       String fullName = "";
			   		   if(user!=null){
			   			fullName = user.getFullName();
			    	  }
			      %>
			      <% if(fullName != ""){ %>
			       <li class="list-inline-item"><a href="<%=request.getContextPath()%>/detailuser?username=<%= user.getUserName()%>">Xin chào, <%= fullName%></a></li>
			        <li class="list-inline-item"><a href="<%=request.getContextPath()%>/logout">Logout</a></li>
			         <li class="list-inline-item"><a href="contact.html">Contact</a></li>
                <li class="list-inline-item"><a href="#">Recently viewed</a></li>
			      <%} else {%>
			   <!--  <li class="list-inline-item"><a href="#" data-toggle="modal" data-target="#login-modal">Login </a></li> -->
                <li class="list-inline-item"><a href="<%=request.getContextPath()%>/register">Login | Register</a></li>
                <li class="list-inline-item"><a href="contact.html">Contact</a></li>
                <li class="list-inline-item"><a href="#">Recently viewed</a></li>
                <%} %>
              </ul>
            </div>
          </div>
        </div>
        <div id="login-modal" tabindex="-1" role="dialog" aria-labelledby="Login" aria-hidden="true" class="modal fade">
          <div class="modal-dialog modal-sm">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title">Customer login</h5>
                <button type="button" data-dismiss="modal" aria-label="Close" class="close"><span >×</span></button>
              </div>
              <div class="modal-body">
                <form action="login" method="post">
                  <div class="form-group">
                    <input name="userName" type="text" placeholder="UserName" class="form-control">
                  </div>
                  <div class="form-group">
                    <input name="password" type="password" placeholder="password" class="form-control">
                  </div>
                  <p class="text-center">
                    <button class="btn btn-primary"><i class="fa fa-sign-in"></i> Log in</button>
                  </p>
                </form>
                <p class="text-center text-muted">Not registered yet?</p>
                <p class="text-center text-muted"><a href="register"><strong>Register now</strong></a>! It is easy and done in 1 minute and gives you access to special discounts and much more!</p>
              </div>
            </div>
          </div>
        </div>
        <!-- *** TOP BAR END ***-->
        
        
      </div>
      <nav class="navbar navbar-expand-lg">
        <div class="container"><a href="<%=request.getContextPath()%>/home" class="navbar-brand home"><img src="<%=request.getContextPath()%>/img/logo.png" alt="Obaju logo" class="d-none d-md-inline-block"><img src="<%=request.getContextPath()%>/img/logo-small.png" alt="Obaju logo" class="d-inline-block d-md-none"><span class="sr-only">Obaju - go to homepage</span></a>
          <div class="navbar-buttons">
            <button type="button" data-toggle="collapse" data-target="#navigation" class="btn btn-outline-secondary navbar-toggler"><span class="sr-only">Toggle navigation</span><i class="fa fa-align-justify"></i></button>
            <button type="button" data-toggle="collapse" data-target="#search" class="btn btn-outline-secondary navbar-toggler"><span class="sr-only">Toggle search</span><i class="fa fa-search"></i></button><a href="basket.html" class="btn btn-outline-secondary navbar-toggler"><i class="fa fa-shopping-cart"></i></a>
          </div>
          <div id="navigation" class="collapse navbar-collapse">
            <ul class="navbar-nav mr-auto">
              <li class="nav-item"><a href="#" class="nav-link active">Home</a></li>
              <li class="nav-item dropdown menu-large"><a href="#" data-toggle="dropdown" data-hover="dropdown" data-delay="200" class="dropdown-toggle nav-link">Food<b class="caret"></b></a>
                <ul class="dropdown-menu megamenu">
                  <li>
                    <div class="row">
                      <%
				   
					  List<CategoryModel> newsListByCat = null;
                      List<CategoryModel> newsListChirldCat = null;
                      CategoryDao newdao = new  CategoryDao();
					  newsListByCat = newdao.getAllCategory();		
					  OrderModel order =(OrderModel) session.getAttribute("order");
					  int numberOrder = 0;
					  if(order!=null){
						  numberOrder = order.getItems().size();
					  }
					
				%>
				<%
							int cid=0;
							if (newsListByCat.size() > 0) {
								for(int i =0 ;i <newsListByCat.size();i++ ){
						%>
                 <div class="col-md-12 col-lg-3">
                         <% if(newsListByCat.get(i).getParentId()<1){ %>
                          <h5><%= newsListByCat.get(i).getCategoryName() %></h5>
                         <%} %>
                        <ul class="list-unstyled mb-3">
                          <%
                          newsListChirldCat = newdao.getChirldCategory(i+1);
                          for(int j=0;j<newsListChirldCat.size();j++) {%>
                          <li class="nav-item"><a href="category?caId=<%= newsListChirldCat.get(j).getCategoryId()%>" class="nav-link"><%= newsListChirldCat.get(j).getCategoryName() %></a></li>
                          <%} %>
                        </ul>
                      </div>
          <%}} %>
                   
                    </div>
                  </li>
                </ul>
              </li>
              <li class="nav-item dropdown menu-large"><a href="#" data-toggle="dropdown" data-hover="dropdown" data-delay="200" class="dropdown-toggle nav-link">Blogs<b class="caret"></b></a>
                <ul class="dropdown-menu megamenu">
                  <li>
                    <div class="row">
                      <div class="col-md-6 col-lg-3">
                        <h5>Shop</h5>
                        <ul class="list-unstyled mb-3">
                          <li class="nav-item"><a href="<%=request.getContextPath()%>/home" class="nav-link">Homepage</a></li>
                          <li class="nav-item"><a href="category.html" class="nav-link">Category - sidebar left</a></li>
                          <li class="nav-item"><a href="category-right.html" class="nav-link">Category - sidebar right</a></li>
                          <li class="nav-item"><a href="<%=request.getContextPath()%>/categoryfull" class="nav-link">Category - full width</a></li>
                          <li class="nav-item"><a href="detail.html" class="nav-link">Product detail</a></li>
                        </ul>
                      </div>
                      <%if(user!=null){ %>
                       <div class="col-md-6 col-lg-3">
                        <h5>User</h5>
                        <ul class="list-unstyled mb-3">
                         
                          <li class="nav-item"><a href="<%=request.getContextPath()%>/myorder" class="nav-link">Orders history</a></li>
                         
                           <li class="nav-item"><a href="<%=request.getContextPath()%>/wishlistcontroller?tag=wishlist"  class="nav-link">Wishlist</a></li>
                      
                         
                          
                        </ul>
                      </div>
                      <%} else{%>
                      
                      <%} %>
                      <div class="col-md-6 col-lg-3">
                        <h5>Pages and blog</h5>
                        <ul class="list-unstyled mb-3">
                          <li class="nav-item"><a href="<%=request.getContextPath()%>/listblogs" class="nav-link">Blog listing</a></li>
                         
                          <li class="nav-item"><a href="faq.html" class="nav-link">FAQ</a></li>
                          <li class="nav-item"><a href="text.html" class="nav-link">Text page</a></li>
                          <li class="nav-item"><a href="text-right.html" class="nav-link">Text page - right sidebar</a></li>
                          <li class="nav-item"><a href="404.html" class="nav-link">404 page</a></li>
                          <li class="nav-item"><a href="contact.html" class="nav-link">Contact</a></li>
                        </ul>
                      </div>
                    </div>
                  </li>
                </ul>
              </li>
            </ul>
            <div class="navbar-buttons d-flex justify-content-end">
              <!-- /.nav-collapse-->
              <div id="search-not-mobile" class="navbar-collapse collapse"></div><a data-toggle="collapse" href="#search" class="btn navbar-btn btn-primary d-none d-lg-inline-block"><span class="sr-only">Toggle search</span><i class="fa fa-search"></i></a>
              <div id="basket-overview" class="navbar-collapse collapse d-none d-lg-block"><a id="numberCart" href="<%=request.getContextPath()%>/order" class="btn btn-primary navbar-btn"><i class="fa fa-shopping-cart"></i><span > <%= numberOrder %> items in cart</span></a></div>
            </div>
          </div>
        </div>
      </nav>
      <div id="search" class="collapse">
        <div class="container">
          <form role="search" action="searchcontroller" class="ml-auto" method="get">
            <div class="input-group">
              <input type="text" placeholder="Search" name="keySearch"  class="form-control">
              <div class="input-group-append">
                <button type="submit" class="btn btn-primary"><i class="fa fa-search"></i></button>
              </div>
            </div>
          </form>
        </div>
      </div>
</body>
</html>