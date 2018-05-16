package unitTests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import core.Book;
import core.Library;



public class Tests {
	 
	@Test
	 public void browserTests() {
		Library library = new Library();
		library.addBook("zabijaka", 1200, "A.Bober");
		library.addBook("drkula", 1950, "W.Koper");
		library.addBook("szachy", 2014, "A.Bcer");
		library.addBook("buka", 1200, "A.Boccaa");
		
		
					
		library.foundBooks("W.Koper","drkula");
		System.out.println("");
		library.foundBooks("W.Koper");
		System.out.println("");
		library.foundBooks("szachy","A.Bcer");
		System.out.println("");
		library.foundBooks("W.Kopr","drkula");
		System.out.println("");
		library.foundBooks("szacy","A.Bcer");
		System.out.println("");
		library.foundBooks("szachy",2014);
		System.out.println("");
		library.foundBooks("szachya",2014);
		System.out.println("");
		library.foundBooks("szachy",12014);
		System.out.println("");
		library.foundBooks("zabijaka", 1200, "A.Bober");
		System.out.println("");
		library.foundBooks("zabijak", 1200, "A.Bober");
		System.out.println("");
		library.foundBooks("zabijaka", 120, "A.Bober");
		System.out.println("");
		library.foundBooks("zabijaka", 1200, "A.Bobe");
	
	 }
	@Test
	 public void removeAddLendTests() {
		
	
		Library library = new Library();
		library.addBook("zabijaka", 1200, "A.Bober");
		library.addBook("drkula", 1950, "W.Koper");
		library.addBook("szachy", 2014, "A.Bcer");
		library.addBook("buka", 1200, "A.Boccaa");
		assertTrue(library.getAllBooks().size()==11);
		library.removeBook(3);
		assertTrue(library.getAllBooks().size()==10);
		library.addBook("asda", 2012, "B.Msolini");
		assertTrue(library.getAllBooks().size()==11);
		library.removeBook(300);
		assertTrue(library.getAllBooks().size()==11);
		
		library.addCustomer("Marcin", "Boberek");
		library.addCustomer("Danuta", "Ma³ek");
		
		library.showAllBooks();
		library.lendBook(5, 2);
		library.lendBook(1, 2);
		library.lendBook(2, 2);
		library.lendBook(2, 400);
		
		library.bookDetails(1);
		library.bookDetails(2);
		library.bookDetails(200);
		
		library.removeBook(5);
		library.lendBook(1, 5);
		library.lendBook(2, 5);
		
	}
}
