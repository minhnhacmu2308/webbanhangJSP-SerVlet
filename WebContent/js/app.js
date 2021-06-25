function addWish(){
              	var productId = document.getElementById("productId").value;
              	
              	$.ajax({
              		  url: "/WebsiteBanHang/addwishlist",
              		  type:"get",
              		  data:{
              			productId:productId
              		  },
              		  success: function(data){
              			var row = document.getElementById("toast");
              			row.innerHTML = data;
              		    $(document).ready(function(){
              		    	 $('.toast').toast('show');
              		    });
              		
              		  }
              		});
              	
              }
              function oncc(){
                	var productId = document.getElementById("productId").value;
                	
                	$.ajax({
                		  url: "/WebsiteBanHang/addcart",
                		  type:"get",
                		  data:{
                			productId:productId
                		  },
                		  success: function(data){
                			var row = document.getElementById("toast");
                			row.innerHTML = data;
                		    $(document).ready(function(){
                		    	 $('.toast').toast('show');
                		    });
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
             function addCart(i){
	                
                    var productIdB = "productId"+i	;
                  	var productId = document.getElementById(productIdB).value;
                   
                	$.ajax({
                		  url: "/WebsiteBanHang/addcart",
                		  type:"get",
                		  data:{
                			productId:productId
                		  },
                		  success: function(data){
                			var row = document.getElementById("toast");
                			row.innerHTML = data;
                		    $(document).ready(function(){
                		    	 $('.toast').toast('show');
                		    });
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