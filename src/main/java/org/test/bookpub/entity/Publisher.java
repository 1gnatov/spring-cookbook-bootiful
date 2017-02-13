package org.test.bookpub.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Publisher {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@OneToMany(mappedBy = "publisher")
	private List<Book> books;

	protected Publisher() {
	}

	;

	public Publisher(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long pId) {
		id = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String pName) {
		name = pName;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> pBooks) {
		books = pBooks;
	}
}
