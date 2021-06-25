<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                  <li aria-current="page" class="breadcrumb-item active">My account</li>
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
                  <ul class="nav nav-pills flex-column"><a href="<%=request.getContextPath()%>/myorder" class="nav-link "><i class="fa fa-list"></i> My orders</a>
                  <a href="<%=request.getContextPath()%>/wishlistcontroller?tag=wishlist" class="nav-link"><i class="fa fa-heart"></i> My wishlist</a>
                  <a href="detailuser?username=<%= user.getUserName()%>" class="nav-link <% if(tag == "myAccount") {%> active<%}else{%>""<%} %>"><i class="fa fa-user"></i> My account</a>
                  <a href="<%=request.getContextPath()%>/logout" class="nav-link"><i class="fa fa-sign-out"></i> Logout</a></ul>
                </div>
              </div>
              <!-- /.col-lg-3-->
              <!-- *** CUSTOMER MENU END ***-->
            </div>
            <div class="col-lg-9">
              <div class="box">
                <h1>My account</h1>
                <p class="lead">Change your personal details or your password here.</p>
                <p class="text-muted">Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.</p>
                <h3>Change password</h3>
                <form action="changepassword" method="post">
                  <div class="row">
                    <div class="col-md-6">
                      <div class="form-group">
                        <label for="password_old">Old password</label>
                        <input id="password_old"  type="password" name="passwordOld" class="form-control">
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-md-6">
                      <div class="form-group">
                        <label for="password_1">New password</label>
                        <input id="password_1" type="password" name = "passwordNew"class="form-control">
                      </div>
                    </div>
                    <div class="col-md-6">
                      <div class="form-group">
                        <label for="password_2">Retype new password</label>
                        <input id="password_2" type="password" name = "rePasswordNew" class="form-control">
                      </div>
                    </div>
                  </div>
                  <!-- /.row-->
                  <% String mess = (String)request.getAttribute("mes"); %>
                  <% if(mess!=null){ %>
                    <%if(mess=="error"){ %>
                     <div class="alert alert-danger" role="alert">
					   Two passwords do not match
					</div>
                    <%}else if(mess=="error1") {%>
                    <div class="alert alert-danger" role="alert">
					   Change password failt
					</div>
                    <%} else{%>
                    <div class="alert alert-success" role="alert">
						 Change password successfully!!
						</div>
                    <%} %>
                   
                  <%}else{ %> 
                  <%} %>
                 
                  <div class="col-md-12 text-center">
                    <button type="submit" class="btn btn-primary"><i class="fa fa-save"></i> Save new password</button>
                  </div>
                </form>
                <h3 class="mt-5">Personal details</h3>
                <form action="editprofile" method="post">
                  <div class="row">
                    <div class="col-md-6">
                      <div class="form-group">
                        <label for="firstname">Full name</label>
                        <input id="firstname" value="<%= user.getFullName() %>" type="text" name="fullname" class="form-control">
                      </div>
                    </div>
                   <div class="col-md-6">
                      <div class="form-group">
                        <label for="firstname">Number Phone</label>
                        <input id="firstname" value="<%= user.getPhoneNumber() %>" type="text" name ="phoneNumber"class="form-control">
                      </div>
                    </div>
                  </div>
                  <!-- /.row-->
                  <div class="row">
                    <div class="col-md-6">
                      <div class="form-group">
                        <label for="company">Address</label>
                        <input id="company" value="<%= user.getAddress() %>" name="address" type="text" class="form-control">
                      </div>
                    </div>
                    <div class="col-md-6">
                      <div class="form-group">
                        <label for="street">Role</label>
                        <input readonly id="street" value="<% if(user.getIsSell()==0){ %> User <%}else{ %> Admin <%} %>" type="text" class="form-control">
                      </div>
                    </div>
                  </div>
                  <!-- /.row-->
                  <%String mess1 = (String)request.getAttribute("mes1"); %>
                  <%if(mess1 !=null){ %>
                  <%if(mess1=="success"){ %>
                   <div class="alert alert-success" role="alert">
						 Edit profile successfully!!
						</div>
                  <%} else{%>
                   <div class="alert alert-danger" role="alert">
					   Eidt profile failt
					</div>
                  <%} %>
                  	
                  <%}else{ %>
                  <%} %>
                  <div class="row">
             
                    <div class="col-md-12 text-center">
                      <button type="submit" class="btn btn-primary"><i class="fa fa-save"></i> Save changes</button>
                    </div>
                  </div>
                </form>
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