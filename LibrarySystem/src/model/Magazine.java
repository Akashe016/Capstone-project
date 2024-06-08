package model;

public class Magazine  implements LibraryItem{

	private String title;
	private String upc;
	private String subject;
	private String volume;
	private String issue;
	
	public Magazine(String title, String upc, String subject, String volume, String issue) {
		this.title = title;
		this.upc = upc;
		this.subject = subject;
		this.volume = volume;
		this.issue = issue;
	}
	
	@Override
	public String getTitle() {
		return title;
	}
	@Override
	public String getUpc() {
		return upc;
	}
	@Override
	public String getSubject() {
		return subject;
	}

	public String getVolume() {
		return volume;
	}

	public String getIssue() {
		return issue;
	}
	
	
	
}
