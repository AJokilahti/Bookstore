package com.example.Bookstore;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.Category;


@ExtendWith(SpringExtension.class)   // JUnit5 eli Jupiter
@DataJpaTest
public class BookRepositoryTest {
	
	@Autowired
	private BookRepository repository;
	
	@Test
	public void findByTitle() {
		List<Book> books = repository.findByTitle("Taivaallinen vastaanotto");
		
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getTitle()).isEqualTo("Rikos ja Rangaistus");
	}
	
	@Test
	public void createrNewBook() {
		Book book = new Book("Star Wars", "Geroge Lucas", 1987, "1326547656621", 30.95, new Category("Sci-fi"));
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}
}
