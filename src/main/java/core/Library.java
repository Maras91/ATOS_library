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
		for (Book book : allBooks) {
			if (book.getId()==id && book.getIsLend()==false) {
				allBooks.remove(book);
			}
		}
		return;
	}
	public void showAllBooks() {
			showBooksList(allBooks);
		return;
	}
	public void showBooksList(List<Book> listBooks){
		int iterator=0;
		for (Book book:listBooks) {
			iterator++;
			System.out.println(iterator+". "+book.toString());
		}
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
		showBooksList(foundBooks);
		return ;
	}
	public void lendBook(int customerid, int id) {
		Book chosenBook = null;
		for(Book book:allBooks) {
			if (book.getId()==id) {
				chosenBook=book;
			}
		}
		for(Customer customer:allCustomers) { 
			if (customer.getId()==customerid) {
				chosenBook.setIsLend(true);
				chosenBook.setCustomerId(customer.getId());
				customer.addBook(chosenBook);
			}
		}
	}
	public void bookDetails (int id) {
		Book chosenBook = null;
		for(Book book:allBooks) {
			if (book.getId()==id) {
				chosenBook=book;
			}
		} 
		System.out.print(chosenBook.toString());
		if (chosenBook.getIsLend()) {
			for(Customer customer:allCustomers) {
				if (chosenBook.getCustomerId()==customer.getId()) {
					System.out.print(" book lended "+customer.toString());
				}
			}
		} else
		{
			System.out.println(" book is not lend");
		}
		return;
	}
}
