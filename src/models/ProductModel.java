package models;

public class ProductModel {
		private int productId;
		private String productName;
		private String productDescription;
		private String productPicture;
		private int categoryId;
		private float productPrice;
		private int parentId;
		private int source;
		public int getProductId() {
			return productId;
		}
		public void setProductId(int productId) {
			this.productId = productId;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public String getProductDescription() {
			return productDescription;
		}
		public void setProductDescription(String productDescription) {
			this.productDescription = productDescription;
		}
		public String getProductPicture() {
			return productPicture;
		}
		public void setProductPicture(String productPicture) {
			this.productPicture = productPicture;
		}
		public int getCategoryId() {
			return categoryId;
		}
		public void setCategoryId(int categoryId) {
			this.categoryId = categoryId;
		}
		public float getProductPrice() {
			return productPrice;
		}
		public void setProductPrice(float productPrice) {
			this.productPrice = productPrice;
		}
		public int getParentId() {
			return parentId;
		}
		public void setParentId(int parentId) {
			this.parentId = parentId;
		}
		public int getSource() {
			return source;
		}
		public void setSource(int source) {
			this.source = source;
		}
		public ProductModel(int productId, String productName, String productDescription, String productPicture,
				int categoryId, float productPrice, int parentId, int source) {
			super();
			this.productId = productId;
			this.productName = productName;
			this.productDescription = productDescription;
			this.productPicture = productPicture;
			this.categoryId = categoryId;
			this.productPrice = productPrice;
			this.parentId = parentId;
			this.source = source;
		}
		public ProductModel(int productId, String productName, String productDescription, String productPicture,
				int categoryId, float productPrice) {
			super();
			this.productId = productId;
			this.productName = productName;
			this.productDescription = productDescription;
			this.productPicture = productPicture;
			this.categoryId = categoryId;
			this.productPrice = productPrice;
		}
		
		public ProductModel(String productName, String productDescription, String productPicture, int categoryId,
				float productPrice) {
			super();
			this.productName = productName;
			this.productDescription = productDescription;
			this.productPicture = productPicture;
			this.categoryId = categoryId;
			this.productPrice = productPrice;
		}
		public ProductModel() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public String toString() {
			return "ProductModel [productId=" + productId + ", productName=" + productName + ", productDescription="
					+ productDescription + ", productPicture=" + productPicture + ", categoryId=" + categoryId
					+ ", productPrice=" + productPrice + ", parentId=" + parentId + ", source=" + source + "]";
		}
		
}
