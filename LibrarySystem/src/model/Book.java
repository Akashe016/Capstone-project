package model;

import java.util.ArrayList;
import java.util.List;

public class Book implements LibraryItem{

	private String title;
	private String upc;
	private String subject;
	private String isbn;
	private String dds_number;
	private List<Author> authors = new ArrayList();
	
	public Book(String title, String upc, String subject, String isbn, String dds_number) {
		this.title = title;
		this.upc = upc;
		this.subject = subject;
		this.isbn = isbn;
		this.dds_number = dds_number;;
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
	
	public String getDds_number() {
		return dds_number;
	}

	public String getIsbn() {
		return isbn;
	}

	public List<Author> getAuthor() {
		return authors;
	}

	public void addAuthor(Author author) {
		 authors.add(author);
	}

}
