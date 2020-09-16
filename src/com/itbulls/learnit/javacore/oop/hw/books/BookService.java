package com.itbulls.learnit.javacore.oop.hw.books;

import java.util.Arrays;
import java.util.Objects;

public class BookService {
	
	public Book[] filterBooksByAuthor(Author author, Book[] books) {
		if (author == null || books == null) {
			return new Book[0];
		}
		
		int matchBooksAmount = 0;
		for (Book book : books) {
			if (book.hasAuthor(author)) {
				matchBooksAmount++;
			}
		}
		
		Book[] filteredBooks = new Book[matchBooksAmount];
		int index = 0;
		for (Book book : books) {
			if (book.hasAuthor(author)) {
				filteredBooks[index++] = book;
			}
		}
		
		return filteredBooks;
	}

	public Book[] filterBooksByPublisher(Publisher publisher, Book[] books) {
		if (publisher == null || books == null) {
			return new Book[0];
		}
		
		int matchBooksAmount = 0;
		for (Book book : books) {
			if (book.getPublisher().equals(publisher)) {
				matchBooksAmount++;
			}
		}
		
		Book[] filteredBooks = new Book[matchBooksAmount];
		int index = 0;
		for (Book book : books) {
			if (book.getPublisher().equals(publisher)) {
				filteredBooks[index++] = book;
			}
		}
		
		return filteredBooks;
	}

	public Book[] filterBooksAfterSpecifiedYear(int yearFromInclusively, Book[] books) {
		if (books == null) {
			return new Book[0];
		}
		
		int matchBooksAmount = 0;
		for (Book book : books) {
			if (book.getPublishingYear() >= yearFromInclusively) {
				matchBooksAmount++;
			}
		}
		
		Book[] filteredBooks = new Book[matchBooksAmount];
		int index = 0;
		for (Book book : books) {
			if (book.getPublishingYear() >= yearFromInclusively) {
				filteredBooks[index++] = book;
			}
		}
		
		return filteredBooks;
	}
	
	
	
	// ====================== STREAM API solution below
	
//	public Book[] filterBooksByAuthor(Author author, Book[] books) {
//		if (author == null || books == null) {
//			return new Book[0];
//		}
//		return Arrays.stream(books)
//					.filter(Objects::nonNull)
//					.filter(book -> book.hasAuthor(author))
//					.toArray(Book[]::new);
//	}
//
//	public Book[] filterBooksByPublisher(Publisher publisher, Book[] books) {
//		if (publisher == null || books == null) {
//			return new Book[0];
//		}
//		return Arrays.stream(books)
//					.filter(Objects::nonNull)
//					.filter(book -> book.getPublisher().equals(publisher))
//					.toArray(Book[]::new);
//	}
//
//	public Book[] filterBooksAfterSpecifiedYear(int yearFromInclusively, Book[] books) {
//		if (books == null) {
//			return new Book[0];
//		}
//		return Arrays.stream(books)
//					.filter(Objects::nonNull)
//					.filter(book -> book.getPublishingYear() >= yearFromInclusively)
//					.toArray(Book[]::new);
//	}

}
