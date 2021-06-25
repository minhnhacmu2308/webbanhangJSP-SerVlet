package models;

public class StatisticalModel {
	
	private int totalUser;
	private int totalProduct;
	private int totalCategory;
	private int totalOrder;
	public int getTotalUser() {
		return totalUser;
	}
	public void setTotalUser(int totalUser) {
		this.totalUser = totalUser;
	}
	public int getTotalProduct() {
		return totalProduct;
	}
	public void setTotalProduct(int totalProduct) {
		this.totalProduct = totalProduct;
	}
	public int getTotalCategory() {
		return totalCategory;
	}
	public void setTotalCategory(int totalCategory) {
		this.totalCategory = totalCategory;
	}
	public int getTotalOrder() {
		return totalOrder;
	}
	public void setTotalOrder(int totalOrder) {
		this.totalOrder = totalOrder;
	}
	public StatisticalModel(int totalUser, int totalProduct, int totalCategory, int totalOrder) {
		super();
		this.totalUser = totalUser;
		this.totalProduct = totalProduct;
		this.totalCategory = totalCategory;
		this.totalOrder = totalOrder;
	}
	public StatisticalModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
