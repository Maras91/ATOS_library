package libraryTest;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import library.Library;

public class Tests {

	@Test
	public void browserTests() {
		/*
		 * Library library = new Library();
		 * 
		 * library.getAllBooks().foundBooks("W.Koper", "drkula");
		 * System.out.println(""); library.getAllBooks().foundBooks("W.Koper");
		 * System.out.println(""); library.getAllBooks().foundBooks("Szachy", "A.Bcer");
		 * System.out.println(""); library.getAllBooks().foundBooks("W.Kopr", "drkula");
		 * System.out.println(""); library.getAllBooks().foundBooks("szacy", "A.Bcer");
		 * System.out.println(""); library.getAllBooks().foundBooks("Szachy", 2014);
		 * System.out.println(""); library.getAllBooks().foundBooks("Szachya", 2014);
		 * System.out.println(""); library.getAllBooks().foundBooks("Szachy", 12014);
		 * System.out.println(""); library.getAllBooks().foundBooks("Zabijaka", 2000,
		 * "A.Bober"); System.out.println("");
		 * library.getAllBooks().foundBooks("Zabijak", 2000, "A.Bober");
		 * System.out.println(""); library.getAllBooks().foundBooks("Zabijaka", 200,
		 * "A.Bober"); System.out.println("");
		 * library.getAllBooks().foundBooks("Zabijaka", 2000, "A.Bobe");
		 */
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
			assertTrue(e.getMessage().equals("The customer with id: " + 5 + " not exist"));
		}
		library.lendBook(1, 2);
		try {
			library.lendBook(2, 2);
			fail();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().equals("The book with id: " + 2 + " is already lended by customer " + "Marcin Boberek"));
		}
		try {
			library.lendBook(2, 400);
			fail();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().equals("The book with id: " + 400 + " not exist"));
		}

		library.bookDetails(1);
		library.bookDetails(2);
		try {
			library.bookDetails(200);
			fail();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().equals("The book with id: " + 200 + " not exist"));
		}
		 library.getAllBooks().removeBook(5);
		 try { 
			 library.lendBook(1, 5);
			 fail();
			} catch (IllegalArgumentException e) {
				assertTrue(e.getMessage().equals("The book with id: " + 5 + " not exist"));
			}

	}
}
