package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.ItemModel;
import models.OrderModel;

/**
 * Servlet implementation class DeleteCartController
 */
@WebServlet("/deletecart")
public class DeleteCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idEdit = request.getParameter("id");
		System.out.println(request.getParameter("id"));
		HttpSession session = request.getSession();
		OrderModel order = (OrderModel)session.getAttribute("order");
		List<ItemModel> listItem = order.getItems();
		for(int j =0 ;j<listItem.size();j++ ) {
			if(listItem.get(j).getProduct().getProductId()==Integer.parseInt(idEdit)) {
				listItem.remove(listItem.get(j));
				order.setItems(listItem);
				session.setAttribute("order", order);
				
				response.setContentType("text/html;charset=UTF-8");
				request.setCharacterEncoding("UTF-8");
				PrintWriter out = response.getWriter();
				float total = 0;
				if(order.getItems().size()>0) {
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
					out.println("<tr>\r\n" + 
							"                          <th colspan=\"5\">Total</th>\r\n" + 
							"                          <th colspan=\"2\" id=\"sum\">"+total+"</th>\r\n" + 
							"                        </tr>");
				}else {
					out.println("<h3>No item</h3>");
				}
			
			}
		}
		
	
	}

}
