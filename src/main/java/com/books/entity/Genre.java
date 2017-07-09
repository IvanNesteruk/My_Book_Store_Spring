package com.books.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Genre")
public class Genre extends AbstractEntity {

	@Column(name = "Genre")
	private String genreOfBook;

	@OneToMany(mappedBy = "genre")
	private Set<Book> books = new HashSet<Book>();

	public Genre() {
	}

	public Genre(String genreOfBook) {
		super();
		this.genreOfBook = genreOfBook;
	}

	public String getGenreOfBook() {
		return genreOfBook;
	}

	public void setGenreOfBook(String genreOfBook) {
		this.genreOfBook = genreOfBook;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Genre [genreOfBook=" + genreOfBook + "]";
	}

}
