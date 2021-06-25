package models;

public class CategoryModel {
	private int categoryId;
	private String categoryName;
	private int parentId;
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public CategoryModel(int categoryId, String categoryName, int parentId) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.parentId = parentId;
	}
	public CategoryModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return "CategoryModel [categoryId=" + categoryId + ", categoryName=" + categoryName + ", parentId=" + parentId
				+ "]";
	}
	
	
}
