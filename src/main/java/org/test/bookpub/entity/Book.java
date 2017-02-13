package org.test.bookpub.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
public class Book {

	@Id
	@GeneratedValue
	private Long id;
	private String isbn;
	private String title;
	private String description;
	@ManyToOne
	private Author author;
	@ManyToOne
	private Publisher publisher;
	@ManyToMany
	private List<Reviewer> reviewers;

	protected Book() {
	}

	public Book(String isbn, String title, Author author, Publisher publisher) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long pId) {
		id = pId;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String pIsbn) {
		isbn = pIsbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String pTitle) {
		title = pTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String pDescription) {
		description = pDescription;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author pAuthor) {
		author = pAuthor;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher pPublisher) {
		publisher = pPublisher;
	}

	public List<Reviewer> getReviewers() {
		return reviewers;
	}

	public void setReviewers(List<Reviewer> pReviewers) {
		reviewers = pReviewers;
	}
}
