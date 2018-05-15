package core;

import java.util.ArrayList;
import java.util.List;

public class Library {
	private List<Book> allBooks;
	Library()
	{
		allBooks = new ArrayList<Book>();
	}
	public void addBook(String title, int year, String autor) {
		allBooks.add(new Book(title, year, autor));
		return;
	}
	public void removeBook(int id) {
		for (Book book : allBooks) {
			if (book.getId()==id && book.getIsLent()==false) {
				allBooks.remove(book);
			}
		}
		return;
	}
	public void showAllBooks() {
		int iterator=0;
		for (Book book:allBooks) {
			iterator++;
			System.out.println(iterator+". "+book.toString());
		}
		return;
	}
}
