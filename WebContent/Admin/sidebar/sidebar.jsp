<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@page import="models.CategoryModel"%>
 <%@page import="service.impl.CategoryServiceImpl"%>
    <%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
          <%
          CategoryServiceImpl a = new CategoryServiceImpl();
          List<CategoryModel> newsListC=  a.getAll();
          String checkactive = (String) request.getAttribute("checkactive");
          %>
     <div class="left-sidebar-wrapper"><a class="left-sidebar-toggle" href="#">Dashboard</a>
          <div class="left-sidebar-spacer">
            <div class="left-sidebar-scroll">
              <div class="left-sidebar-content">
                <ul class="sidebar-elements">
                  <li class="divider">Menu</li>
                  <li class="active"><a href="admin"><i class="icon mdi mdi-home"></i><span>Dashboard</span></a>
                  </li>
                  <li class="parent"><a href="#"><i class="icon mdi mdi-face"></i><span>Category</span></a>
                    <ul class="sub-menu">
                      <li class="<%if(checkactive == "category"){ %> active<%}%>"> <a href="<%=request.getContextPath()%>/listcategory">Danh sách</a>
                      </li>
                      <li class="<%if(checkactive == "addcategory"){ %> active<%}%>" ><a href="<%=request.getContextPath()%>/addcategory">Thêm category</a>
                      </li>
                  
                    </ul>
                  </li>
                  <li class="parent"><a href="charts.html"><i class="icon mdi mdi-chart-donut"></i><span>Product</span></a>
                    <ul class="sub-menu">
                      <li class="<%if(checkactive == "listproduct"){ %> active<%}%>"><a href="<%=request.getContextPath()%>/listproduct">Danh sách</a>
                      </li>
                      <li class="<%if(checkactive == "addproduct"){ %> active<%}%>"><a href="<%=request.getContextPath()%>/addproduct">Thêm product</a>
                      </li>
                     
                    </ul>
                  </li>
                  <li class="parent"><a href="#"><i class="icon mdi mdi-dot-circle"></i><span>Order</span></a>
                    <ul class="sub-menu">
                      <li class="<%if(checkactive == "order"){ %> active<%}%>"> <a href="<%=request.getContextPath()%>/listorder">Danh sách</a>
                      </li>
                      <li class="<%if(checkactive == "detailorder"){ %> active<%}%>"><a>Detail</a>
                      </li>
                     
                    </ul>
                  </li>
                  <li class="parent"><a href="#"><i class="icon mdi mdi-border-all"></i><span>Blog</span></a>
                    <ul class="sub-menu">
                      <li class="<%if(checkactive == "blog"){ %> active<%}%>"> <a href="<%=request.getContextPath()%>/listblog">Danh sách</a>
                      </li>
                      <li class="<%if(checkactive == "addblog"){ %> active<%}%>"> <a href="<%=request.getContextPath()%>/addblog">Thêm blog</a>
                      </li>
                      
                    </ul>
                  </li>
                  <li class="parent"><a href="#"><i class="icon mdi mdi-layers"></i><span>Pages</span></a>
                    <ul class="sub-menu">
                      <li><a href="pages-blank.html">Blank Page</a>
                      </li>
                      <li><a href="pages-blank-header.html">Blank Page Header</a>
                      </li>
                      <li><a href="pages-login.html">Login</a>
                      </li>
                      <li><a href="pages-login2.html">Login v2</a>
                      </li>
                      <li><a href="pages-404.html">404 Page</a>
                      </li>
                      <li><a href="pages-sign-up.html">Sign Up</a>
                      </li>
                      <li><a href="pages-forgot-password.html">Forgot Password</a>
                      </li>
                      <li><a href="pages-profile.html">Profile</a>
                      </li>
                      <li><a href="pages-pricing-tables.html">Pricing Tables</a>
                      </li>
                      <li><a href="pages-pricing-tables2.html">Pricing Tables v2</a>
                      </li>
                      <li><a href="pages-timeline.html">Timeline</a>
                      </li>
                      <li><a href="pages-timeline2.html">Timeline v2</a>
                      </li>
                      <li><a href="pages-invoice.html"><span class="badge badge-primary float-right">New</span>Invoice</a>
                      </li>
                      <li><a href="pages-calendar.html">Calendar</a>
                      </li>
                      <li><a href="pages-gallery.html">Gallery</a>
                      </li>
                      <li><a href="pages-code-editor.html"><span class="badge badge-primary float-right">New    </span>Code Editor</a>
                      </li>
                      <li><a href="pages-booking.html"><span class="badge badge-primary float-right">New</span>Booking</a>
                      </li>
                      <li><a href="pages-loaders.html"><span class="badge badge-primary float-right">New</span>Loaders</a>
                      </li>
                      <li><a href="pages-ajax-loader.html"><span class="badge badge-primary float-right">New</span>AJAX Loader</a>
                      </li>
                    </ul>
                  </li>
                  <li class="divider">Features</li>
                  <li class="parent"><a href="#"><i class="icon mdi mdi-inbox"></i><span>Email</span></a>
                    <ul class="sub-menu">
                      <li><a href="email-inbox.html">Inbox</a>
                      </li>
                      <li><a href="email-read.html">Email Detail</a>
                      </li>
                      <li><a href="email-compose.html">Email Compose</a>
                      </li>
                    </ul>
                  </li>
                  <li class="parent"><a href="#"><i class="icon mdi mdi-view-web"></i><span>Layouts</span></a>
                    <ul class="sub-menu">
                      <li><a href="layouts-primary-header.html">Primary Header</a>
                      </li>
                      <li><a href="layouts-success-header.html">Success Header</a>
                      </li>
                      <li><a href="layouts-warning-header.html">Warning Header</a>
                      </li>
                      <li><a href="layouts-danger-header.html">Danger Header</a>
                      </li>
                      <li><a href="layouts-search-input.html">Search Input</a>
                      </li>
                      <li><a href="layouts-offcanvas-menu.html">Off Canvas Menu</a>
                      </li>
                      <li><a href="layouts-top-menu.html"><span class="badge badge-primary float-right">New</span>Top Menu</a>
                      </li>
                      <li><a href="layouts-nosidebar-left.html">Without Left Sidebar</a>
                      </li>
                      <li><a href="layouts-nosidebar-right.html">Without Right Sidebar</a>
                      </li>
                      <li><a href="layouts-nosidebars.html">Without Both Sidebars</a>
                      </li>
                      <li><a href="layouts-fixed-sidebar.html">Fixed Left Sidebar</a>
                      </li>
                      <li><a href="layouts-boxed-layout.html"><span class="badge badge-primary float-right">New</span>Boxed Layout</a>
                      </li>
                      <li><a href="pages-blank-aside.html">Page Aside</a>
                      </li>
                      <li><a href="layouts-collapsible-sidebar.html">Collapsible Sidebar</a>
                      </li>
                      <li><a href="layouts-sub-navigation.html"><span class="badge badge-primary float-right">New</span>Sub Navigation</a>
                      </li>
                      <li><a href="layouts-mega-menu.html"><span class="badge badge-primary float-right">New</span>Mega Menu</a>
                      </li>
                    </ul>
                  </li>
                  <li class="parent"><a href="#"><i class="icon mdi mdi-pin"></i><span>Maps</span></a>
                    <ul class="sub-menu">
                      <li><a href="maps-google.html">Google Maps</a>
                      </li>
                      <li><a href="maps-vector.html">Vector Maps</a>
                      </li>
                    </ul>
                  </li>
                  <li class="parent"><a href="#"><i class="icon mdi mdi-folder"></i><span>Menu Levels</span></a>
                    <ul class="sub-menu">
                      <li class="parent"><a href="#"><i class="icon mdi mdi-undefined"></i><span>Level 1</span></a>
                        <ul class="sub-menu">
                          <li><a href="#"><i class="icon mdi mdi-undefined"></i><span>Level 2</span></a>
                          </li>
                          <li class="parent"><a href="#"><i class="icon mdi mdi-undefined"></i><span>Level 2</span></a>
                            <ul class="sub-menu">
                              <li><a href="#"><i class="icon mdi mdi-undefined"></i><span>Level 3</span></a>
                              </li>
                              <li><a href="#"><i class="icon mdi mdi-undefined"></i><span>Level 3</span></a>
                              </li>
                            </ul>
                          </li>
                        </ul>
                      </li>
                      <li class="parent"><a href="#"><i class="icon mdi mdi-undefined"></i><span>Level 1</span></a>
                        <ul class="sub-menu">
                          <li><a href="#"><i class="icon mdi mdi-undefined"></i><span>Level 2</span></a>
                          </li>
                          <li class="parent"><a href="#"><i class="icon mdi mdi-undefined"></i><span>Level 2</span></a>
                            <ul class="sub-menu">
                              <li><a href="#"><i class="icon mdi mdi-undefined"></i><span>Level 3</span></a>
                              </li>
                              <li><a href="#"><i class="icon mdi mdi-undefined"></i><span>Level 3</span></a>
                              </li>
                            </ul>
                          </li>
                        </ul>
                      </li>
                    </ul>
                  </li>
                  <li><a href="documentation.html"><i class="icon mdi mdi-book"></i><span>Documentation</span></a>
                  </li>
                </ul>
              </div>
            </div>
          </div>
          <div class="progress-widget">
            <div class="progress-data"><span class="progress-value">60%</span><span class="name">Current Project</span></div>
            <div class="progress">
              <div class="progress-bar progress-bar-primary" style="width: 60%;"></div>
            </div>
          </div>
        </div>
</body>
</html>