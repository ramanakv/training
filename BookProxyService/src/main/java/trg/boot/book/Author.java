package trg.boot.book;



public class Author {

	private int authorId;
	private String name;
	private String subject;
	private int mobile;
	
	public Author() {
		super();
	}
	public Author(int authorId, String name, String subject, int mobile) {
		super();
		this.authorId = authorId;
		this.name = name;
		this.subject = subject;
		this.mobile = mobile;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	
	

}
