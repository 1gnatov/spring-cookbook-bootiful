package org.test.bookpub.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Reviewer {

	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String lastName;

	protected Reviewer() {
	}

	;

	public Reviewer(String firstName, String lastName) {
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
}
