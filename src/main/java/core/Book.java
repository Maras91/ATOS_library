package core;

import java.util.ArrayList;
import java.util.List;

public class Book {
	private static  int highestId = 1;
	private String title;
	private int id;
	private int year;
	private String author;
	private Boolean isLent;
	Book(String title, int year, String autor)
	{
		this.title=title;
		this.year=year;
		this.author=autor;
		setIsLent(false);
		createUniqueId();
	}
	private void createUniqueId() {
		id = highestId;
		highestId++;
		return;
	}
	public int getId() {
		return id;
	}
	public Boolean getIsLent() {
		return isLent;
	}
	public void setIsLent(Boolean isLent) {
		this.isLent = isLent;
	}
	public String toString() {
		return "ID: "+id+" tltle: "+title +" author: "+author+" year: "+year;
		
	}
}
