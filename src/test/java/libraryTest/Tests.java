package libraryTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import library.Library;

public class Tests {

	@Test
	public void browserTests() {
		Library library = new Library();
		assertEquals("ID: 13 tltle: Zabijaka author: A.Bober year: 2000", library.getAllBooks().findBooks("Zabijaka", null, null).get(0).toString());
		assertTrue(library.getAllBooks().findBooks("Zabijakaa", null, null).isEmpty());
		assertEquals("ID: 13 tltle: Zabijaka author: A.Bober year: 2000", library.getAllBooks().findBooks(null, 2000, null).get(0).toString());
		assertEquals("ID: 13 tltle: Zabijaka author: A.Bober year: 2000", library.getAllBooks().findBooks(null, null, "A.Bober").get(0).toString());
		
		assertEquals("ID: 13 tltle: Zabijaka author: A.Bober year: 2000", library.getAllBooks().findBooks(null, 2000, "A.Bober").get(0).toString());
		assertEquals("ID: 13 tltle: Zabijaka author: A.Bober year: 2000", library.getAllBooks().findBooks("Zabijaka", null, "A.Bober").get(0).toString());
		assertEquals("ID: 13 tltle: Zabijaka author: A.Bober year: 2000", library.getAllBooks().findBooks("Zabijaka", 2000, null).get(0).toString());
		
		assertEquals("ID: 13 tltle: Zabijaka author: A.Bober year: 2000", library.getAllBooks().findBooks("Zabijaka", 2000, "A.Bober").get(0).toString());
		
		try {
		library.getAllBooks().findBooks(null, null, null).get(0).toString();
		fail();
		}catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(),"no argument in function");
		}
		
		assertEquals("ID: 16 tltle: Kolo author: A.Boccaa year: 2015", library.getAllBooks().findBooks(null, 2015, null).get(0).toString());
	}

	@Test
	public void removeAddLendTests() {

		Library library = new Library();
		library.getAllBooks().addBook("zabijaka", 1200, "A.Bober");
		library.getAllBooks().addBook("drkula", 1950, "W.Koper");
		library.getAllBooks().addBook("szachy", 2014, "A.Bcer");
		library.getAllBooks().addBook("buka", 1200, "A.Boccaa");
		assertTrue(library.getAllBooks().getAllBooks().size() == 11);
		library.getAllBooks().removeBook(3);
		assertTrue(library.getAllBooks().getAllBooks().size() == 10);
		library.getAllBooks().addBook("asda", 2012, "B.Msolini");
		assertTrue(library.getAllBooks().getAllBooks().size() == 11);
		try {
			library.getAllBooks().removeBook(300);
			fail();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().equals("The book with id: " + 300 + " not exist"));
		}
		assertTrue(library.getAllBooks().getAllBooks().size() == 11);

		library.getAllCustomers().addCustomer("Marcin", "Boberek");
		library.getAllCustomers().addCustomer("Danuta", "Ma³ek");

		library.getAllBooks().showAllBooks();
		try {
			library.lendBook(5, 2);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(),"The customer with id: " + 5 + " not exist");
		}
		library.lendBook(1, 2);
		try {
			library.lendBook(2, 2);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(),"The book with id: " + 2 + " is already lended by customer " + "Marcin Boberek");
		}
		try {
			library.lendBook(2, 400);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(),"The book with id: " + 400 + " not exist");
		}

		library.bookDetails(1);
		library.bookDetails(2);
		try {
			library.bookDetails(200);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(),"The book with id: " + 200 + " not exist");
		}
		 library.getAllBooks().removeBook(5);
		 try { 
			 library.lendBook(1, 5);
			 fail();
			} catch (IllegalArgumentException e) {
				assertEquals(e.getMessage(),"The book with id: " + 5 + " not exist");
			}

	}
}
