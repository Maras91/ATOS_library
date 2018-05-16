package core;

import java.util.ArrayList;
import java.util.List;

public class Library {
	private List<Book> allBooks;
	private List<Customer> allCustomers;
	public List<Book> getAllBooks(){
		return allBooks;
	}
	public Library()
	{
		allBooks = new ArrayList<Book>();
		allCustomers = new ArrayList<Customer>();
		addBook("Zabijaka", 2000, "A.Bober");
		addBook("Drakula", 1950, "W.Koper");
		addBook("Szachy", 2014, "A.Bcer");
		addBook("Kolo", 2015, "A.Boccaa");
		addBook("Tanie ¿ycie", 1978, "W.Koper");
		addBook("Strach na lachy", 2002, "A.Bcer");
		addBook("Ale jaja", 2003, "A.Boccaa");
	}
	public void addCustomer(String name, String surname) {
		allCustomers.add(new Customer(name,surname));
		return;
	}
	public void addBook(String title, int year, String autor) {
		allBooks.add(new Book(title, year, autor));
		return;
	}
	public void removeBook(int id) {
		Book removeBook = null;
		for (Book book : allBooks) {
			if (book.getId()==id && book.getIsLend()==false) {
				//allBooks.remove(book);
				removeBook=book;
				
			}
		}
		if (removeBook==null) {
			System.out.println("The book with id: "+id+" not exist");
			return;
		}
		allBooks.remove(removeBook);
		return;
	}
	public void showAllBooks() {
			showBooksList(allBooks);
		return;
	}
	public void showBooksList(List<Book> listBooks){
		int iterator=0;
		int lendbooks=0;
		for (Book book:listBooks) {
			iterator++;
			if(book.getIsLend()) {
				lendbooks++;
			}
			System.out.println(iterator+". "+book.toString());
		}
		System.out.println("All books: "+listBooks.size());
		System.out.println("Books lended: "+lendbooks);
		System.out.println("Books in library: "+(listBooks.size()-lendbooks));
	}
	
	public void foundBooks(String kayword, int year, String kayword2) {
		List<Book> foundBooks = new ArrayList<Book>();
		for (Book book:allBooks)
		{
			if (book.getYear()==year) {
				if (book.getTitle().equals(kayword) && book.getAuthor().equals(kayword2) || book.getAuthor().equals(kayword) && book.getTitle().equals(kayword2))
				{
					foundBooks.add(book);
				}
			}
		}
		System.out.println("Books found:");
		showBooksList(foundBooks);
		return ;
	}
	public void foundBooks(String kayword, int year) {
		List<Book> foundBooks = new ArrayList<Book>();
		for (Book book:allBooks)
		{
			if ( (book.getTitle().equals(kayword) || book.getAuthor().equals(kayword)) && book.getYear()==year)
			{
				foundBooks.add(book);
			}
		}
		System.out.println("Books found:");
		showBooksList(foundBooks);
		return ;
	}
	public void foundBooks(String kayword, String kayword2) {
		List<Book> foundBooks = new ArrayList<Book>();
		for (Book book:allBooks)
		{
			if (book.getTitle().equals(kayword) && book.getAuthor().equals(kayword2) || book.getAuthor().equals(kayword) && book.getTitle().equals(kayword2))
			{
				foundBooks.add(book);
			}
		}
		System.out.println("Books found:");
		showBooksList(foundBooks);
		return ;
	}
	public void foundBooks(String kayword) {
		List<Book> foundBooks = new ArrayList<Book>();
		for (Book book:allBooks)
		{
			if (book.getTitle().equals(kayword) || book.getAuthor().equals(kayword))
			{
				foundBooks.add(book);
			}
		}
		System.out.println("Books found:");
		showBooksList(foundBooks);
		return ;
	}
	public void foundBooks(int year) {
		List<Book> foundBooks = new ArrayList<Book>();
		for (Book book:allBooks)
		{
			if (book.getYear()==year)
			{
				foundBooks.add(book);
			}
		}
		System.out.println("Books found:");
		showBooksList(foundBooks);
		return ;
	}
	public void lendBook(int customerid, int id) {
		Book chosenBook = null;
		for(Book book:allBooks) {
			if (book.getId()==id) {
				if (book.getIsLend()) {
					System.out.print("The book with id: "+id+" is already lended by customer ");
						for (Customer customer:allCustomers) {
							if (book.getCustomerId()==customer.getId()) {
								System.out.println(customer.toString());
							}
						}
					return;
				}else {
					chosenBook=book;
				}
			}
		}
		if (chosenBook==null) {
			System.out.println("The book with id: "+id+" not exist");
			return;
		}
		Boolean custonerFound= false;
		for(Customer customer:allCustomers) { 
			if (customer.getId()==customerid) {
				chosenBook.setIsLend(true);
				chosenBook.setCustomerId(customer.getId());
				customer.addBook(chosenBook);
				custonerFound= true;
			}
		}
		if (!custonerFound) {
			System.out.println("Customer not found");
		}
	}
	public void bookDetails (int id) {
		Book chosenBook = null;
		for(Book book:allBooks) {
			if (book.getId()==id) {
				chosenBook=book;
			}
		} 
		if (chosenBook==null) {
			System.out.println("The book with id: "+id+" not exist");
			return;
		}
		System.out.print(chosenBook.toString());
		if (chosenBook.getIsLend()) {
			for(Customer customer:allCustomers) {
				if (chosenBook.getCustomerId()==customer.getId()) {
					System.out.println(" book lended by "+customer.toString());
				}
			}
		} else
		{
			System.out.println(" book is not lend");
		}
		return;
	}
}
