<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="Admin/assets\img\logo-fav.png">
    <title>Beagle</title>
    <link rel="stylesheet" type="text/css" href="Admin/assets\lib\perfect-scrollbar\css\perfect-scrollbar.css">
    <link rel="stylesheet" type="text/css" href="Admin/assets\lib\material-design-icons\css\material-design-iconic-font.min.css">
    <link rel="stylesheet" href="Admin/assets\css\app.css" type="text/css">
      <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
  </head>
  <body class="be-splash-screen">
     <%String mes = (String) request.getAttribute("mes"); %>
         <% if(mes =="error"){ %>
         <script type="text/javascript">
         $(document).ready(function(){
		    	 $('#toast1').toast('show');
		    });

         </script>
         
         <%}else{ %>
         <%} %>
         
    <div role="alert" aria-live="assertive" style=" z-index:2000; position: fixed;top: 20px;right: 20px;width: 300px" data-delay="2000" aria-atomic="true" id="toast1" class="toast" data-bs-autohide="false">
    <div class="toast-header" style="background-color: red">
   
    <strong style="color: #ffff" class="me-auto">Error</strong>
  </div>
  <div class="toast-body">
  Username or password incorret
  </div>
</div> 
    <div class="be-wrapper be-login">
      <div class="be-content">
        <div class="main-content container-fluid">
          <div class="splash-container">
            <div class="card card-border-color card-border-color-primary">
              <div class="card-header"><img class="logo-img" src="Admin/assets\img\logo-xx.png" alt="logo" width="102" height="27"><span class="splash-description">Please enter your user information.</span></div>
              <div class="card-body">
                <form method="post" action="admin">
                  <div class="form-group">
                    <input class="form-control" name="username" type="text" placeholder="Username" autocomplete="off">
                  </div>
                  <div class="form-group">
                    <input class="form-control" name="password" type="password" placeholder="Password">
                  </div>
                  <div class="form-group row login-tools">
                    <div class="col-6 login-remember">
                      <div class="custom-control custom-checkbox">
                        <input class="custom-control-input" type="checkbox" id="checkbox1">
                        <label class="custom-control-label" for="checkbox1">Remember Me</label>
                      </div>
                    </div>
                    <div class="col-6 login-forgot-password"><a href="pages-forgot-password.html">Forgot Password?</a></div>
                  </div>
                  <div class="form-group login-submit"><button class="btn btn-primary btn-xl" type="submit" data-dismiss="modal">Sign me in</button></div>
                </form>
              </div>
            </div>
            <div class="splash-footer"><span>Don't have an account? <a href="pages-sign-up.html">Sign Up</a></span></div>
          </div>
        </div>
      </div>
    </div>
    <script src="Admin/assets\lib\jquery\jquery.min.js" type="text/javascript"></script>
    <script src="Admin/assets\lib\perfect-scrollbar\js\perfect-scrollbar.min.js" type="text/javascript"></script>
    <script src="Admin/assets\lib\bootstrap\dist\js\bootstrap.bundle.min.js" type="text/javascript"></script>
    <script src="Admin/assets\js\app.js" type="text/javascript"></script>
    <script type="text/javascript">
      $(document).ready(function(){
      	//-initialize the javascript
      	App.init();
      });
      
    </script>
  </body>
</html>