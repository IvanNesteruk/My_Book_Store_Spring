package com.books.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Author")
public class Author extends AbstractEntity {

	/* @Column(unique=true) */
	@Column(name = "Name")
	private String name;
	@Column(name = "Surname")
	private String surname;

	@ManyToOne
	private Country country;
	
	@ManyToMany
	@JoinTable(name = "AuthorBook", joinColumns = @JoinColumn(name = "AuthorID"), 
	inverseJoinColumns = @JoinColumn(name = "BookID"))
	private Set<Book> books = new HashSet<Book>();

	public Author() {
	}

	public Author(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}

	public Author(String name, String surname, Country country) {
		this.name = name;
		this.surname = surname;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Author [name=" + name + ", surname=" + surname + "]";
	}
	
	

}
