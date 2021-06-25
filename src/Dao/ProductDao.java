package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.CategoryModel;
import models.ItemModel;
import models.ProductModel;
import utils.ConnectToDatabase;

public class ProductDao extends AbstractDao{

 Connection conn = ConnectToDatabase.getConnect();
  

  public List<ProductModel> getAllProduct() {
    List<ProductModel> list = new ArrayList<>();
    String sql = "select * from product limit 8";

    try {
      ps = conn.prepareStatement(sql);
      rs = ps.executeQuery();
      while (rs.next()) {
        list.add(
          new ProductModel(
            rs.getInt(1),
            rs.getString(2),
            rs.getString(3),
            rs.getString(4),
            rs.getInt(5),
            rs.getFloat(6),
            rs.getInt(7),
            rs.getInt(8)
          )
        );
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return list;
  }

  public ProductModel getProductById(String id) {
    String sql = "select * from product where product_id = ? ";
    try {
      ps = conn.prepareStatement(sql);
      ps.setString(1, id);
      rs = ps.executeQuery();
      while (rs.next()) {
        return new ProductModel(
          rs.getInt(1),
          rs.getString(2),
          rs.getString(3),
          rs.getString(4),
          rs.getInt(5),
          rs.getFloat(6),
          rs.getInt(7),
          rs.getInt(8)
        );
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }

  public List<ProductModel> getProductRecently() {
    List<ProductModel> list = new ArrayList<>();
    String sql = "select * from product limit 3";

    try {
      ps = conn.prepareStatement(sql);
      rs = ps.executeQuery();
      while (rs.next()) {
        list.add(
          new ProductModel(
            rs.getInt(1),
            rs.getString(2),
            rs.getString(3),
            rs.getString(4),
            rs.getInt(5),
            rs.getFloat(6),
            rs.getInt(7),
            rs.getInt(8)
          )
        );
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return list;
  }
  public List<ProductModel> getProductByNumber(int number) {
	    List<ProductModel> list = new ArrayList<>();
	    String sql = "select * from product limit ?";

	    try {
	      ps = conn.prepareStatement(sql);
	      ps.setInt(1, number);
	      rs = ps.executeQuery();
	      while (rs.next()) {
	        list.add(
	          new ProductModel(
	            rs.getInt(1),
	            rs.getString(2),
	            rs.getString(3),
	            rs.getString(4),
	            rs.getInt(5),
	            rs.getFloat(6),
	            rs.getInt(7),
	            rs.getInt(8)
	          )
	        );
	      }
	    } catch (SQLException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }

	    return list;
}
  public List<ProductModel> getProductRecommend(int number) {
    List<ProductModel> list = new ArrayList<>();
    String sql = "select * from product order by numberView DESC limit ?";

    try {
      ps = conn.prepareStatement(sql);
      ps.setInt(1, number);
      rs = ps.executeQuery();
      while (rs.next()) {
        list.add(
          new ProductModel(
            rs.getInt(1),
            rs.getString(2),
            rs.getString(3),
            rs.getString(4),
            rs.getInt(5),
            rs.getFloat(6),
            rs.getInt(7),
            rs.getInt(8)
          )
        );
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return list;
  }
  public int getNumberPage() {
	  String sql = "select count(*) from product";
	  
	  try {
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()) {
			int total = rs.getInt(1);
			int count = 0;
			count = total/12;
			if(total % 12 != 0) {
				count++;
			}
			return count;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return 0;
  }
  public int getNumberCategory(int id){
		int numberC=0 ;
		String sql = "select count(*) from product where cat_id=?";
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				numberC= rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return numberC;
	}
  public List<ProductModel> pagingproduct(int index){
	  List<ProductModel> list = new ArrayList<>();
	  String sql = "select * from `product` limit ?,?";
	  try {
		ps = conn.prepareStatement(sql);
		ps.setInt(1, (index-1)*12);
		ps.setInt(2, 12);
		rs = ps.executeQuery();
		while(rs.next()) {
			list.add(
			          new ProductModel(
			            rs.getInt(1),
			            rs.getString(2),
			            rs.getString(3),
			            rs.getString(4),
			            rs.getInt(5),
			            rs.getFloat(6),
			            rs.getInt(7),
			            rs.getInt(8)
			          )
			        );
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return list;
  }
  public ProductModel getProdcutById(int id) {
	  
	  String sql = "select * from product where product_id = ?";
	  
	  try {
		ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		rs = ps.executeQuery();
		while(rs.next()) {
			return new ProductModel(
		            rs.getInt(1),
		            rs.getString(2),
		            rs.getString(3),
		            rs.getString(4),
		            rs.getInt(5),
		            rs.getFloat(6),
		            rs.getInt(7),
		            rs.getInt(8)
		          );
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  return null;
  }
  public boolean addOrder(int customerId,List<ItemModel> list,boolean status) {
		int result = 0;
		
		String sql = "insert into orders(customerId,item,status) values(?,?,?)";
		
		try {
			String item = list.toString();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, customerId);
			ps.setString(2,item);
			ps.setBoolean(3, false);
			result = ps.executeUpdate();
			
			if(result==1) {
				return true;
			}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}
  public int getNumberViewCurrent(int productId) {
	  String sql = "select numberView from product where product_id = ?";
	  
	  try {
		ps = conn.prepareStatement(sql);
		ps.setInt(1, productId);
		rs = ps.executeQuery();
		while(rs.next()) {
			return rs.getInt(1);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  return 0;
  }
  public boolean addView(int productId) {
	  
	  String sql = "update product set numberView = ? where product_id = ?";
	  
	  int numberViewCurrent = getNumberViewCurrent(productId);
	  int result = 0;
	  try {
		ps = conn.prepareStatement(sql);
		ps.setInt(1, (numberViewCurrent+1));
		ps.setInt(2, productId);
		result = ps.executeUpdate();
		while(result==1) {
			return true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  return false;
  }
  
  
  public boolean checkExitWish(int userId,int productId) {
	  
	  String sql = "select count(*) from wishlist where user_id = ? and product_id = ?";
	  
	  try {
		ps = conn.prepareStatement(sql);
		ps.setInt(1, userId);
		ps.setInt(2, productId);
		rs = ps.executeQuery();
		while(rs.next()) {
			if(rs.getInt(1)>0) {
				return true;
			}
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  
	  return false;
  }
  
  public boolean addWishList(int userId,int productId) {
	  String sql = "insert into wishlist(user_id,product_id) values(?,?)";
	  int result = 0; 
	  try {
		ps = conn.prepareStatement(sql);
		ps.setInt(1, userId);
		ps.setInt(2, productId);
		result = ps.executeUpdate();
		if(result==1) {
			return true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  
	  return false;
  }
  public boolean deleteWishList(int userId,int productId) {
	  String sql = "delete from wishlist where user_id=? and product_id=?";
	  int result = 0; 
	  try {
		ps = conn.prepareStatement(sql);
		ps.setInt(1, userId);
		ps.setInt(2, productId);
		result = ps.executeUpdate();
		if(result==1) {
			return true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  
	  return false;
  }
  public List<ProductModel> getListWish(int userId){
	  List<ProductModel> list = new ArrayList<>();
	  
	  String sql ="SELECT * FROM product AS p INNER JOIN wishlist as w on p.product_id = w.product_id WHERE user_id =?";
	  
	  try {
		ps = conn.prepareStatement(sql);
		ps.setInt(1, userId);
		rs = ps.executeQuery();
		while(rs.next()) {
			list.add(new ProductModel(
		            rs.getInt(1),
		            rs.getString(2),
		            rs.getString(3),
		            rs.getString(4),
		            rs.getInt(5),
		            rs.getFloat(6),
		            rs.getInt(7),
		            rs.getInt(8)
		          ));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return list;
  }
  
  public List<ProductModel> sortByPrice(String keySearch){
	  List<ProductModel> list = new ArrayList<>();
	  String sql = "select * from product order by price desc where product_name like ?";
	  
	  try {
		ps = conn.prepareStatement(sql);
		ps.setNString(1, keySearch);
		rs = ps.executeQuery();
		while(rs.next()) {
			list.add(new ProductModel(
		            rs.getInt(1),
		            rs.getString(2),
		            rs.getString(3),
		            rs.getString(4),
		            rs.getInt(5),
		            rs.getFloat(6),
		            rs.getInt(7),
		            rs.getInt(8)
		          ));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  return list;
  }
  
  
  
  public static void main(String[] args) {
    ProductDao pp = new ProductDao();
//    ProductModel pd = pp.getProductById("27");
//    List<ProductModel> rs = pp.getProductByNumber(20);
//    System.out.println(rs.size());	
//    System.out.println(pp.getNumberPage());
//    System.out.println(pd);
//    List<ProductModel> rs1 = pp.pagingproduct(2);
//    for(ProductModel s:rs1) {
//    	System.out.println(s);
//    }
//	
//	 List<ItemModel> list = new ArrayList<>(); boolean a = pp.addOrder(2, list,
//	 false); if(a==true) { System.out.println("true"); }else {
//	  System.out.println("false"); }
//	 
//    System.out.println(pp.addView(1));
   
    List<ProductModel> abc = pp.getListWish(40);
    for(ProductModel a:abc) {
    	System.out.println(a);
    }
 
    System.out.println(pp.deleteWishList(56,2));
  }
}
