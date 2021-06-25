package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDatabase {
	public ConnectToDatabase() {};
	public static Connection getConnect(){
		final String url = "jdbc:mysql://localhost:3306/shopbanhang";
		final String use ="root";
		final String password ="";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url,use,password);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Error when you connect to database!Error is: "+e.getMessage());
		}
		return null;
	}
	public static void main(String[] args) throws Exception {
		Connection connection = getConnect();
		if(connection != null) {
			System.out.println("Success");
		}else{
			System.out.println("Error");
		}
	}
}
	