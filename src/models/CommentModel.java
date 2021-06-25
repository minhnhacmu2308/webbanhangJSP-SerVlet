package models;

public class CommentModel {
	private int commentId;
	private int userId;
	private int blogId;
	private String comment;
	private String create_time;
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public CommentModel(int commentId, int userId, int blogId, String comment) {
		super();
		this.commentId = commentId;
		this.userId = userId;
		this.blogId = blogId;
		this.comment = comment;
	}
	public CommentModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CommentModel(int commentId, int userId, int blogId, String comment, String create_time) {
		super();
		this.commentId = commentId;
		this.userId = userId;
		this.blogId = blogId;
		this.comment = comment;
		this.create_time = create_time;
	}
	public CommentModel(int userId, int blogId, String comment, String create_time) {
		super();
		this.userId = userId;
		this.blogId = blogId;
		this.comment = comment;
		this.create_time = create_time;
	}
	public CommentModel(int userId, int blogId, String comment) {
		super();
		this.userId = userId;
		this.blogId = blogId;
		this.comment = comment;
	}
	public String toString() {
		return "CommentModel [commentId=" + commentId + ", userId=" + userId + ", blogId=" + blogId + ", comment="
				+ comment + "]";
	}
	
}
