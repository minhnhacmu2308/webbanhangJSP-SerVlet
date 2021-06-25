package models;

public class UserModel {

	private int userId;
	private String userName;
	private String password;
	private String fullName;
	private String phoneNumber;
	private String address;
	private int isSell;
	private int isAdmin;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {	
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getIsSell() {
		return isSell;
	}
	public void setIsSell(int isSell) {
		this.isSell = isSell;
	}
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	public UserModel(int userId, String userName, String password, String fullName, String phoneNumber, String address,
			int isSell, int isAdmin) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.isSell = isSell;
		this.isAdmin = isAdmin;
	}
	public UserModel( String userName, String password, String fullName, String phoneNumber, String address,
			int isSell, int isAdmin) {
		super();
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.isSell = isSell;
		this.isAdmin = isAdmin;
	}
	public UserModel( String userName, String password, String fullName, String phoneNumber, String address
			) {
		super();
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		
	}
	public UserModel( String userName, String password, String fullName
			) {
		super();
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		
		
	}
	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserModel [userId=" + userId + ", userName=" + userName + ", password=" + password + ", fullName="
				+ fullName + ", phoneNumber=" + phoneNumber + ", address=" + address + ", isSell=" + isSell
				+ ", isAdmin=" + isAdmin + "]";
	}
	
	
}
