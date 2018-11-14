package com.java.tech.ood.onlineBookReader;

import java.util.HashMap;

public class BookCatalog {

	HashMap<Integer, Book> books;

	static BookCatalog instance = null;

	private BookCatalog() {
		books = new HashMap<Integer, Book>();
	}

	public void addBook() {

	}

	public static void setupCatalog() {

	}

	public HashMap<Integer, Book> getBooks() {
		return books;
	}

	public static BookCatalog getInstance() {
		if (instance == null) {
			instance = new BookCatalog();
			setupCatalog();
		}
		return instance;
	}
}
