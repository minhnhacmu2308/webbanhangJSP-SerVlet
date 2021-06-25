<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <%@page import="models.CategoryModel"%>
    <%@page import="models.BlogModel"%>
    <%@page import="java.util.List"%>
    <%@page import="Dao.CategoryDao"%>
     <%@page import="Dao.UserDao"%>
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
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
             <script src="js/jquery-3.5.1.min.js"></script>
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
  <div class="toast-header" style=" background-color:   red">
   
    <strong style="color: #ffff" class="me-auto">Error</strong>
    
   
  </div>
  <div class="toast-body">
     ❌ You need login
  </div>
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
                  <li class="breadcrumb-item"><a href="blog.html">Blog</a></li>
                  <li aria-current="page" class="breadcrumb-item active">Blog post</li>
                </ol>
              </nav>
            </div>
            <div id="blog-post" class="col-lg-9">
              <% List<BlogModel> list = (List<BlogModel>)request.getAttribute("listB");
                  UserDao us = new UserDao();
                  UserModel user = (UserModel)session.getAttribute("user");
              %>
              <%if(user==null){ %>
               <input type="hidden" value="1" id="userId">
              <%}else{ %>
               <input type="hidden" value="2" id="userId">
               <%} %>
              <div class="box">
                <h1><%= list.get(0).getTitle() %></h1>
                <p class="author-date">By <a href="#"><%= list.get(0).getAuthor()%></a> |<%= list.get(0).getCreate_time()%></p>
                <div id="post-content">
                  
                  <p><img src="<%=request.getContextPath()%>/img/<%= list.get(0).getImage()%>" alt="Example blog post alt" class="img-fluid"></p>
                  <p><%= list.get(0).getDetail() %></p>
                </div>
                <!-- /#post-content-->
                <div id="comments">
                  <h4><%= list.get(0).getListComment().size()%> comments</h4>
                  <%for(int j=0;j<list.get(0).getListComment().size();j++){ %>
                   <div class="row comment">
                    <div class="col-md-3 col-lg-2 text-center text-md-center">
                      <p><img src="<%=request.getContextPath()%>/img/avatar.jpg" alt="" class="img-fluid rounded-circle"></p>
                    </div>
                    <%String fullname = us.getFullName(list.get(0).getListComment().get(j).getUserId()); %>
                    <div class="col-md-9 col-lg-10">
                      <h5><%=fullname %></h5>
                      <p class="posted"><i class="fa fa-clock-o"></i><%=" "+ list.get(0).getListComment().get(j).getCreate_time()%></p>
                      <p><%= list.get(0).getListComment().get(j).getComment() %></p>
                      <p class="reply"><a href="#"><i class="fa fa-reply"></i> Reply</a></p>
                    </div>
                  </div>
                  <%} %>
                 
                  <!-- /.comment-->
              
                  <!-- /.comment-->
                </div>
                <!-- /#comments-->
                <div id="comment-form">
                  <h4>Leave comment</h4>
                
                    <input id="blogId" name="blogId" value="<%= list.get(0).getBlogId()%>" type="hidden">
                    <div class="row">
                      <div class="col-md-12">
                        <div class="form-group">
                          <label for="comment">Comment <span class="required">*</span></label>
                          <textarea id="comment" rows="4"  name ="comment" class="form-control"></textarea>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-12 text-right">
                        <button onclick="postComment()" class="btn btn-primary"><i class="fa fa-comment-o"></i> Post comment</button>
                      </div>
                    </div>
                 
                </div>
                <script >
                function postComment(){
                	var checkId = document.getElementById("userId").value;
                	
                	if(checkId==1){
                		$(document).ready(function(){
                			  $('.toast').toast('show');
                			});
                	}else{
                		var stringComment = document.getElementById("comment").value;
                    	var blogId = document.getElementById("blogId").value;
                    	$.ajax({
                    		  url: "/WebsiteBanHang/addcomment",
                    		  type:"get",
                    		  data:{
                    			  comment:stringComment,
                    			  blogId:blogId
                    		  },
                    		  success: function(data){
                    		    var row = document.getElementById("comments");
                    		    row.innerHTML = data;
                    		  }
                    		});
                	}
                
                }
                </script>
                <!-- /#comment-form-->
              </div>
              <!-- /.box-->
            </div>
            <!-- /#blog-post-->
            <div class="col-lg-3">
              <!--
              *** BLOG MENU ***
              _________________________________________________________
              -->
              <div class="card sidebar-menu mb-4">
                <div class="card-header">
                  <h3 class="h4 panel-title">Blog</h3>
                </div>
                <div class="card-body">
                  <p></p>
                </div>
              </div>
              <!-- /.col-lg-3-->
              <!-- *** BLOG MENU END ***-->
              <div class="banner"><a href="#"><img src="<%=request.getContextPath()%>/img/banner.jpg" alt="sales 2014" class="img-fluid"></a></div>
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