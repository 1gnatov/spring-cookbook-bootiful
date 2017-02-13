package org.test.bookpub.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Author {

	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String lastName;
	@OneToMany(mappedBy = "author")
	private List<Book> books;

	protected Author() {
	}

	;

	public Author(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long pId) {
		id = pId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String pFirstName) {
		firstName = pFirstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String pLastName) {
		lastName = pLastName;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> pBooks) {
		books = pBooks;
	}
}
