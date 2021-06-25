package models;

import java.util.List;

public class BlogModel {
	private int blogId;
	private String title;
	private String author;
	private String image;
	private String detail;
	private String create_time;
	private List<CommentModel> listComment;
	
	public List<CommentModel> getListComment() {
		return listComment;
	}
	public void setListComment(List<CommentModel> listComment) {
		this.listComment = listComment;
	}
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public BlogModel(String title, String author, String image, String detail, String create_time) {
		super();
		this.title = title;
		this.author = author;
		this.image = image;
		this.detail = detail;
		this.create_time = create_time;
	}
	public BlogModel(int blogId, String title, String author, String image, String detail, String create_time) {
		super();
		this.blogId = blogId;
		this.title = title;
		this.author = author;
		this.image = image;
		this.detail = detail;
		this.create_time = create_time;
	}
	
	
	public BlogModel(String title, String author, String image, String detail, String create_time,
			List<CommentModel> listComment) {
		super();
		this.title = title;
		this.author = author;
		this.image = image;
		this.detail = detail;
		this.create_time = create_time;
		this.listComment = listComment;
	}
	

	public BlogModel(int blogId, String title, String author, String image, String detail, String create_time,
			List<CommentModel> listComment) {
		super();
		this.blogId = blogId;
		this.title = title;
		this.author = author;
		this.image = image;
		this.detail = detail;
		this.create_time = create_time;
		this.listComment = listComment;
	}
	public String toString() {
		return "BlogModel [blogId=" + blogId + ", title=" + title + ", author=" + author + ", image=" + image
				+ ", detail=" + detail + ", create_time=" + create_time + ", listComment=" + listComment + "]";
	}
	public BlogModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
