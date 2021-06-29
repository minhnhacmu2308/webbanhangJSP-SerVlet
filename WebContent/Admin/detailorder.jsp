<%@page contentType="text/html" pageEncoding="UTF-8"%>
   <%@page import="models.CategoryModel"%>
    <%@page import="Dao.impl.UserdaoImpl"%>
      <%@page import="models.OrderModel"%>
    <%@page import="java.util.List"%>
<!DOCTYPE html>

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="Admin/assets/img/logo-fav.png">
    <title>Beagle</title>
    <link rel="stylesheet" type="text/css" href="Admin/assets/lib/perfect-scrollbar/css/perfect-scrollbar.css">
    <link rel="stylesheet" type="text/css" href="Admin/assets/lib/material-design-icons/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="Admin/assets/css/app.css" type="text/css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
  </head>
  <body>
    <div class="be-wrapper">
      <jsp:include page="header/header.jsp"></jsp:include>
      <div class="be-left-sidebar">
       <jsp:include page="sidebar/sidebar.jsp"></jsp:include>
        <%String mes = (String) request.getAttribute("mes"); %>
         <% if(mes !=null){ %>
         <script type="text/javascript">
         $(document).ready(function(){
		    	 $('#toast1').toast('show');
		    });

         </script>
         
         <%}else{ %>
         <%} %>
         
    <div role="alert" aria-live="assertive" style=" z-index:2000; position: fixed;top: 20px;right: 20px;width: 300px" data-delay="2000" aria-atomic="true" id="toast1" class="toast" data-bs-autohide="false">
    <div class="toast-header" style="background-color: #33CC00">
   
    <strong style="color: #ffff" class="me-auto">Success</strong>
  </div>
  <div class="toast-body">
   Payment successfully
  </div>
</div> 
      </div>
      
      <div class="be-content">
        <div class="page-head">
          <h2 class="page-head-title">Invoice</h2>
          <nav aria-label="breadcrumb" role="navigation">
            <ol class="breadcrumb page-head-nav">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item"><a href="#">Pages</a></li>
              <li class="breadcrumb-item active">Invoice</li>
            </ol>
          </nav>
        </div>
        <%OrderModel order= (OrderModel) request.getAttribute("orderDetail"); %>
        <%UserdaoImpl ord = new UserdaoImpl(); %>
        <div class="main-content container-fluid">
          <div class="row">
            <div class="col-lg-12">
              <div class="invoice">
                <div class="row invoice-header">
                  <div class="col-sm-7">
                    <div class="invoice-logo"></div>
                  </div>
                  <div class="col-sm-5 invoice-order"><span class="invoice-id">Invoice #<%=order.getOrderId() %></span><span class="incoice-date"><%=order.getCreateTime()%></span></div>
                </div>
                <div class="row invoice-data">
                  <div class="col-sm-5 invoice-person"><span class="name"><%= ord.getFullName(order.getCustomerId())%></span><span><%= order.getAddress() %></span></div>
                  <div class="col-sm-2 invoice-payment-direction"><i class="icon mdi mdi-chevron-right"></i></div>
                  <div class="col-sm-5 invoice-person"><span class="name">Admin</span><span><%= order.getAddress() %></span></div>
                </div>
                <div class="row">
                  <div class="col-lg-12">
                    <table class="invoice-details">
                      <tr>
                        <th style="width:40%;">Name product</th>
                        <th class="hours" style="width:17%;">Quantity</th>
                        <th class="amount" style="width:15%;">Price</th>
                       
                      </tr>
                      
                      <%for(int i=0;i< order.getItems().size();i++){ %>
                       <tr>
                        <td class="description"><img src="img/<%= order.getItems().get(i).getProduct().getProductPicture() %>" style="height: 70px;width: 70px" alt="Avatar"> <%= order.getItems().get(i).getProduct().getProductName() %></td>
                        <td class="hours"><%= order.getItems().get(i).getQuantity() %></td>
                        <td class="amount"><%= order.getItems().get(i).getPrice()%></td>
                        
                      </tr>
                      <%} %>
                     
                      <tr>
                        <td></td>
                        <td class="summary">Subtotal</td>
                        <td class="amount"><%= order.getTotal()%></td>
                      </tr>
                        <%float phi = 10.00f; %>
                      <tr>
                        <td></td>
                        <td class="summary">Shipping and handling</td>
                        <td class="amount"><%= phi %></td>
                      </tr>
                      <tr>
                        <td></td>
                       <% float totalS =  order.getTotal()+phi;%>
                        <td class="summary total">Total</td>
                        <td class="amount total-value"><%=totalS %></td>
                      </tr>
                    </table>
                  </div>
                </div>
                <div class="row">
                  <div class="col-lg-12 invoice-payment-method"><span class="title">Payment Method</span><%=order.getPaymentdelivery()%><span>Phone Number: <%= order.getPhoneNumber() %></span></div>
                </div>
                <div class="row">
                  <div class="col-lg-12 invoice-message"><span class="title">Thank you for contacting us</span>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas quis massa nisl. Sed fringilla turpis id mi ultrices, et faucibus ipsum aliquam. Sed ut eros placerat, facilisis est eu, congue felis.</p>
                  </div>
                </div>
                <div class="row invoice-company-info">
                  <div class="col-md-6 col-lg-2 logo"><img src="Admin/assets/img/logo-symbol.png" alt="Logo-symbol"></div>
                  <div class="col-md-6 col-lg-4 summary"><span class="title">Beagle Company</span>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. </p>
                  </div>
                  <div class="col-sm-6 col-lg-3 phone">
                    <ul class="list-unstyled">
                      <li>+1(535)-8999278</li>
                      <li>+1(656)-3558302</li>
                    </ul>
                  </div>
                  <div class="col-sm-6 col-lg-3 email">
                    <ul class="list-unstyled">
                      <li>beagle@company.co</li>
                      <li>beagle@support.co</li>
                    </ul>
                  </div>
                </div>
                <div class="row invoice-footer">
                  <div class="col-lg-12">
                    <button class="btn btn-lg btn-space btn-secondary">Save PDF</button>
                    <button class="btn btn-lg btn-space btn-secondary">Print</button>
                    <a href="payment?id=<%=order.getOrderId() %>" class="btn btn-lg btn-space btn-primary">Pay now</a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <nav class="be-right-sidebar">
        <div class="sb-content">
          <div class="tab-navigation">
            <ul class="nav nav-tabs nav-justified" role="tablist">
              <li class="nav-item" role="presentation"><a class="nav-link active" href="#tab1" aria-controls="tab1" role="tab" data-toggle="tab">Chat</a></li>
              <li class="nav-item" role="presentation"><a class="nav-link" href="#tab2" aria-controls="tab2" role="tab" data-toggle="tab">Todo</a></li>
              <li class="nav-item" role="presentation"><a class="nav-link" href="#tab3" aria-controls="tab3" role="tab" data-toggle="tab">Settings</a></li>
            </ul>
          </div>
          <div class="tab-panel">
            <div class="tab-content">
              <div class="tab-pane tab-chat active" id="tab1" role="tabpanel">
                <div class="chat-contacts">
                  <div class="chat-sections">
                    <div class="be-scroller-chat">
                      <div class="content">
                        <h2>Recent</h2>
                        <div class="contact-list contact-list-recent">
                          <div class="user"><a href="#"><img src="Admin/assets/img/avatar1.png" alt="Avatar">
                              <div class="user-data"><span class="status away"></span><span class="name">Claire Sassu</span><span class="message">Can you share the...</span></div></a></div>
                          <div class="user"><a href="#"><img src="Admin/assets/img/avatar2.png" alt="Avatar">
                              <div class="user-data"><span class="status"></span><span class="name">Maggie jackson</span><span class="message">I confirmed the info.</span></div></a></div>
                          <div class="user"><a href="#"><img src="Admin/assets/img/avatar3.png" alt="Avatar">
                              <div class="user-data"><span class="status offline"></span><span class="name">Joel King		</span><span class="message">Ready for the meeti...</span></div></a></div>
                        </div>
                        <h2>Contacts</h2>
                        <div class="contact-list">
                          <div class="user"><a href="#"><img src="Admin/assets/img/avatar4.png" alt="Avatar">
                              <div class="user-data2"><span class="status"></span><span class="name">Mike Bolthort</span></div></a></div>
                          <div class="user"><a href="#"><img src="Admin/assets/img/avatar5.png" alt="Avatar">
                              <div class="user-data2"><span class="status"></span><span class="name">Maggie jackson</span></div></a></div>
                          <div class="user"><a href="#"><img src="Admin/assets/img/avatar6.png" alt="Avatar">
                              <div class="user-data2"><span class="status offline"></span><span class="name">Jhon Voltemar</span></div></a></div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="bottom-input">
                    <input type="text" placeholder="Search..." name="q"><span class="mdi mdi-search"></span>
                  </div>
                </div>
                <div class="chat-window">
                  <div class="title">
                    <div class="user"><img src="Admin/assets/img/avatar2.png" alt="Avatar">
                      <h2>Maggie jackson</h2><span>Active 1h ago</span>
                    </div><span class="icon return mdi mdi-chevron-left"></span>
                  </div>
                  <div class="chat-messages">
                    <div class="be-scroller-messages">
                      <div class="content">
                        <ul>
                          <li class="friend">
                            <div class="msg">Hello</div>
                          </li>
                          <li class="self">
                            <div class="msg">Hi, how are you?</div>
                          </li>
                          <li class="friend">
                            <div class="msg">Good, I'll need support with my pc</div>
                          </li>
                          <li class="self">
                            <div class="msg">Sure, just tell me what is going on with your computer?</div>
                          </li>
                          <li class="friend">
                            <div class="msg">I don't know it just turns off suddenly</div>
                          </li>
                        </ul>
                      </div>
                    </div>
                  </div>
                  <div class="chat-input">
                    <div class="input-wrapper"><span class="photo mdi mdi-camera"></span>
                      <input type="text" placeholder="Message..." name="q" autocomplete="off"><span class="send-msg mdi mdi-mail-send"></span>
                    </div>
                  </div>
                </div>
              </div>
              <div class="tab-pane tab-todo" id="tab2" role="tabpanel">
                <div class="todo-container">
                  <div class="todo-wrapper">
                    <div class="be-scroller-todo">
                      <div class="todo-content"><span class="category-title">Today</span>
                        <ul class="todo-list">
                          <li>
                            <div class="custom-checkbox custom-control custom-control-sm"><span class="delete mdi mdi-delete"></span>
                              <input class="custom-control-input" type="checkbox" checked="" id="tck1">
                              <label class="custom-control-label" for="tck1">Initialize the project</label>
                            </div>
                          </li>
                          <li>
                            <div class="custom-checkbox custom-control custom-control-sm"><span class="delete mdi mdi-delete"></span>
                              <input class="custom-control-input" type="checkbox" id="tck2">
                              <label class="custom-control-label" for="tck2">Create the main structure							</label>
                            </div>
                          </li>
                          <li>
                            <div class="custom-checkbox custom-control custom-control-sm"><span class="delete mdi mdi-delete"></span>
                              <input class="custom-control-input" type="checkbox" id="tck3">
                              <label class="custom-control-label" for="tck3">Updates changes to GitHub							</label>
                            </div>
                          </li>
                        </ul><span class="category-title">Tomorrow</span>
                        <ul class="todo-list">
                          <li>
                            <div class="custom-checkbox custom-control custom-control-sm"><span class="delete mdi mdi-delete"></span>
                              <input class="custom-control-input" type="checkbox" id="tck4">
                              <label class="custom-control-label" for="tck4">Initialize the project							</label>
                            </div>
                          </li>
                          <li>
                            <div class="custom-checkbox custom-control custom-control-sm"><span class="delete mdi mdi-delete"></span>
                              <input class="custom-control-input" type="checkbox" id="tck5">
                              <label class="custom-control-label" for="tck5">Create the main structure							</label>
                            </div>
                          </li>
                          <li>
                            <div class="custom-checkbox custom-control custom-control-sm"><span class="delete mdi mdi-delete"></span>
                              <input class="custom-control-input" type="checkbox" id="tck6">
                              <label class="custom-control-label" for="tck6">Updates changes to GitHub							</label>
                            </div>
                          </li>
                          <li>
                            <div class="custom-checkbox custom-control custom-control-sm"><span class="delete mdi mdi-delete"></span>
                              <input class="custom-control-input" type="checkbox" id="tck7">
                              <label class="custom-control-label" for="tck7" title="This task is too long to be displayed in a normal space!">This task is too long to be displayed in a normal space!							</label>
                            </div>
                          </li>
                        </ul>
                      </div>
                    </div>
                  </div>
                  <div class="bottom-input">
                    <input type="text" placeholder="Create new task..." name="q"><span class="mdi mdi-plus"></span>
                  </div>
                </div>
              </div>
              <div class="tab-pane tab-settings" id="tab3" role="tabpanel">
                <div class="settings-wrapper">
                  <div class="be-scroller-settings"><span class="category-title">General</span>
                    <ul class="settings-list">
                      <li>
                        <div class="switch-button switch-button-sm">
                          <input type="checkbox" checked="" name="st1" id="st1"><span>
                            <label for="st1"></label></span>
                        </div><span class="name">Available</span>
                      </li>
                      <li>
                        <div class="switch-button switch-button-sm">
                          <input type="checkbox" checked="" name="st2" id="st2"><span>
                            <label for="st2"></label></span>
                        </div><span class="name">Enable notifications</span>
                      </li>
                      <li>
                        <div class="switch-button switch-button-sm">
                          <input type="checkbox" checked="" name="st3" id="st3"><span>
                            <label for="st3"></label></span>
                        </div><span class="name">Login with Facebook</span>
                      </li>
                    </ul><span class="category-title">Notifications</span>
                    <ul class="settings-list">
                      <li>
                        <div class="switch-button switch-button-sm">
                          <input type="checkbox" name="st4" id="st4"><span>
                            <label for="st4"></label></span>
                        </div><span class="name">Email notifications</span>
                      </li>
                      <li>
                        <div class="switch-button switch-button-sm">
                          <input type="checkbox" checked="" name="st5" id="st5"><span>
                            <label for="st5"></label></span>
                        </div><span class="name">Project updates</span>
                      </li>
                      <li>
                        <div class="switch-button switch-button-sm">
                          <input type="checkbox" checked="" name="st6" id="st6"><span>
                            <label for="st6"></label></span>
                        </div><span class="name">New comments</span>
                      </li>
                      <li>
                        <div class="switch-button switch-button-sm">
                          <input type="checkbox" name="st7" id="st7"><span>
                            <label for="st7"></label></span>
                        </div><span class="name">Chat messages</span>
                      </li>
                    </ul><span class="category-title">Workflow</span>
                    <ul class="settings-list">
                      <li>
                        <div class="switch-button switch-button-sm">
                          <input type="checkbox" name="st8" id="st8"><span>
                            <label for="st8"></label></span>
                        </div><span class="name">Deploy on commit</span>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </nav>
    </div>
    <script src="Admin/assets/lib/jquery/jquery.min.js" type="text/javascript"></script>
    <script src="Admin/assets/lib/perfect-scrollbar/js/perfect-scrollbar.min.js" type="text/javascript"></script>
    <script src="Admin/assets/lib/bootstrap/dist/js/bootstrap.bundle.min.js" type="text/javascript"></script>
    <script src="Admin/assets/js/app.js" type="text/javascript"></script>
    <script type="text/javascript">
      $(document).ready(function(){
      	//-initialize the javascript
      	App.init();
      });
      
    </script>
  </body>
</html>