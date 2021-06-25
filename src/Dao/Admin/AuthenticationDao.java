package Dao.Admin;

public interface AuthenticationDao {
	
	boolean login(String username,String password);
	String md5(String str);
	void logout();

}
