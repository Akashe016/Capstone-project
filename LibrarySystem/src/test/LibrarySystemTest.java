package test;

import model.Author;
import model.Book;
import model.CD;
import model.DVD;
import model.Magazine;

public class LibrarySystemTest {

	public static void main(String[] args) {
		
		Book book = new Book("Data structure", "17US024", "Engineering", "762088130742","S3TC");
		book.addAuthor(new Author("Ram"));

		System.out.println("Book-Title : "+book.getTitle());
		System.out.println("Book-UPC : "+book.getUpc());
		System.out.println("Book-Subject : "+book.getSubject());
		System.out.println("Book-ISBN : "+book.getIsbn());
		System.out.println("Book-DDS Number : "+book.getDds_number());


		for(Author author : book.getAuthor()) {
			
			System.out.println("Book-Actors : "+author.getName());
		}
		
		System.out.println("-------------------------------------------");

		Magazine magazine = new Magazine("Envirnoment","1024SE", "Science", "100", "10");
		
		System.out.println("Magazine-Title : "+magazine.getTitle());
		System.out.println("Magazine-UPC : "+magazine.getUpc());
		System.out.println("Magazine-Subject : "+magazine.getSubject());
		System.out.println("Magazine-Volume : "+magazine.getVolume());
		System.out.println("Magazine-Issue : "+magazine.getIssue());

		System.out.println("-------------------------------------------");
		
		DVD dvd = new DVD("Money heist", "8690234650", "Drama movie", "Rio, Berlin, Tokyo", "Albert Pintó's", "Drama");
		
		
		System.out.println("DVD-Title : "+dvd.getTitle());
		System.out.println("DVD-UPC : "+dvd.getUpc());
		System.out.println("DVD-Subject : "+dvd.getSubject());
		System.out.println("DVD-Actors : "+dvd.getActors());
		System.out.println("DVD-Director : "+dvd.getDirector());
		System.out.println("DVD-Genre : "+dvd.getGenre());

		System.out.println("-------------------------------------------");
		
		CD cd = new CD("Goat", "T69", "Hero", "Vijay");
		
		System.out.println("CD-Title : "+cd.getTitle());
		System.out.println("CD-UPC : "+cd.getUpc());
		System.out.println("CD-Subject : "+cd.getSubject());
		System.out.println("CD-Artist : "+cd.getArtist());

		System.out.println("-------------------------------------------");
		
	}
}
