package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.OrderDao;
import Dao.ProductDao;
import models.ItemModel;
import models.OrderModel;
import models.ProductModel;
import models.UserModel;

/**
 * Servlet implementation class AddCartController
 */
@WebServlet("/addcart")
public class AddCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int quantity = 1;
		int productId;
		
		ProductDao daoP = new ProductDao();
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("quantity"));
		if(request.getParameter("productId")!=null) {
			productId = Integer.parseInt(request.getParameter("productId"));
			ProductModel product = daoP.getProdcutById(productId);
			
			HttpSession session = request.getSession();
			if(session.getAttribute("order")==null) {
				UserModel user = (UserModel)session.getAttribute("user");
				
				if(user != null) {
					OrderModel  order = new  OrderModel();
					List<ItemModel> listItem = new ArrayList<>();
					ItemModel item = new ItemModel(product,quantity,product.getProductPrice());
					listItem.add(item);
					order.setItems(listItem);
					order.setCustomerId(user.getUserId());
					session.setAttribute("order", order);
				}else {
					OrderModel  order = new  OrderModel();
					List<ItemModel> listItem = new ArrayList<>();
					ItemModel item = new ItemModel(product,quantity,product.getProductPrice());
					listItem.add(item);
					order.setItems(listItem);
					session.setAttribute("order", order);
				}
			
			
				
			}else {
				UserModel user = (UserModel)session.getAttribute("user");
				OrderModel order = (OrderModel) session.getAttribute("order");
				List<ItemModel> listItem = order.getItems();
			
				boolean check = false;
				for(ItemModel item:listItem) {
				
						if(item.getProduct().getProductId()==product.getProductId()) {
							item.setQuantity(item.getQuantity()+quantity);
							check = true;
						}
					
					
				}
				if(check == false ){
					ItemModel item = new ItemModel(product,quantity,product.getProductPrice());
					listItem.add(item);
					
					
					
				}
				if(user!=null) {
					order.setCustomerId(user.getUserId());
					order.setItems(listItem);
					
					session.setAttribute("order", order);
				}else {
					order.setItems(listItem);
					
					session.setAttribute("order", order);
				}
				
			
			}
			
		}
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println(" <div class=\"toast-header\" style=\"background-color:  #33CC00 \">\r\n" + 
				"    <strong class=\"me-auto\" style=\"color: #ffff\">Success</strong>\r\n" + 
				"  </div>\r\n" + 
				"  <div class=\"toast-body\">\r\n" + 
				"    ✅  Add cart successfully\r\n" + 
				"  </div>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idEdit = request.getParameter("id");
		String quantityEdit = request.getParameter("quantity");
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("quantity"));
		HttpSession session = request.getSession();
		OrderModel order = (OrderModel)session.getAttribute("order");
		List<ItemModel> listItem = order.getItems();
		for(ItemModel item:listItem) {
			if(item.getProduct().getProductId()==Integer.parseInt(idEdit)) {
				item.setQuantity(Integer.parseInt(quantityEdit));
				order.setItems(listItem);
				session.setAttribute("order", order);
			}
		}
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		float total = 0;
		for(int i=0;i<order.getItems().size();i++) {
			total += order.getItems().get(i).getQuantity()*order.getItems().get(i).getPrice();
			out.println(" <tr>\r\n" + 
					"                          <td><a href=\"#\"><img src=\"img/"+order.getItems().get(i).getProduct().getProductPicture()+"\" alt=\"White Blouse Armani\"></a></td>\r\n" + 
					"                          <td><a href=\"<%=request.getContextPath()%>/detail?productId="+order.getItems().get(i).getProduct().getProductId()+"\">"+order.getItems().get(i).getProduct().getProductName()+"</a></td>\r\n" + 
					"                          <td>\r\n" + 
					"                            <input type=\"hidden\" id=\"productId"+i+"\" value=\""+order.getItems().get(i).getProduct().getProductId()+"\">\r\n" + 
					"                            <input min=\"1\" id=\"quantity"+i+"\" onclick=\"oncc("+i+")\" type=\"number\" value=\""+order.getItems().get(i).getQuantity()+"\" class=\"form-control\">\r\n" + 
					"                          </td>\r\n" + 
					"                          <td id=\"priceCurrent"+i+"\">"+order.getItems().get(i).getPrice()+"</td>\r\n" + 
					"                          <td  id=\"total"+i+"\">"+order.getItems().get(i).getQuantity()*order.getItems().get(i).getPrice()+"</td>\r\n" + 
					"                          <td><a onclick=\"ondd("+i+")\"><i class=\"fa fa-trash-o\"></i></a></td>\r\n" + 
					"                          <input type=\"hidden\" id=\"totalS\" value=\""+total+"\">\r\n" + 
					"                          \r\n" + 
					"                        </tr>");
		}
		out.println(" <tr>\r\n" + 
				"                          <th colspan=\"5\">Total</th>\r\n" + 
				"                          <th colspan=\"2\" id=\"sum\">"+total+"</th>\r\n" + 
				"                          <input type=\"hidden\" name=\"sendSum\" value=\""+total+"\">\r\n" + 
				"                        </tr>");
	}

}
