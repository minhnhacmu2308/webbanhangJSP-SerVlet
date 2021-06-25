package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class AbstractDao {
	
	protected Statement st;
	
	
	protected PreparedStatement ps;
	
	
	protected Connection conn;
	
	protected ResultSet rs;
	
	
	
	
}
