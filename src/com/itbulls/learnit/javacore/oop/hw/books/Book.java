package com.itbulls.learnit.javacore.oop.hw.books;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;

public class Book {
	
	private int id;
	private String name;
	private Author[] authors;
	private Publisher publisher;
	private int publishingYear;
	private int amountOfPages;
	private BigDecimal price;
	private CoverType coverType;
	
	public Book() {
	}

	public Book(int id, String name, Author[] authors, Publisher publisher,
			int publishingYear, int amountOfPages, BigDecimal price,
			CoverType coverType) {
		super();
		this.id = id;
		this.name = name;
		this.authors = authors;
		this.publisher = publisher;
		this.publishingYear = publishingYear;
		this.amountOfPages = amountOfPages;
		this.price = price;
		this.coverType = coverType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Author[] getAuthors() {
		return authors;
	}

	public void setAuthors(Author[] authors) {
		this.authors = authors;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public int getPublishingYear() {
		return publishingYear;
	}

	public void setPublishingYear(int publishingYear) {
		this.publishingYear = publishingYear;
	}

	public int getAmountOfPages() {
		return amountOfPages;
	}

	public void setAmountOfPages(int amountOfPages) {
		this.amountOfPages = amountOfPages;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public CoverType getCoverType() {
		return coverType;
	}

	public void setCoverType(CoverType coverType) {
		this.coverType = coverType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(authors);
		result = prime * result + Objects.hash(amountOfPages, coverType, id, name, price,
				publisher, publishingYear);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return amountOfPages == other.amountOfPages
				&& Arrays.equals(authors, other.authors) && coverType == other.coverType
				&& id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(price, other.price)
				&& Objects.equals(publisher, other.publisher)
				&& publishingYear == other.publishingYear;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", authors="
				+ Arrays.toString(authors) + ", publisher=" + publisher
				+ ", publishingYear=" + publishingYear + ", amountOfPages="
				+ amountOfPages + ", price=" + price + ", coverType=" + coverType + "]";
	}

	public boolean hasAuthor(Author authorCriteria) {
		for (Author author : authors) {
			if (author.equals(authorCriteria)) {
				return true;
			}
		}
		return false;
	}

}
