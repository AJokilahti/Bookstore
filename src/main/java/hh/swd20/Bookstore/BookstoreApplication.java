package hh.swd20.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookdemo(BookRepository repository) {
		return(args) -> {
			log.info("Save a couple of books");
			repository.save(new Book("Hobitti", "J. R. R. Tolkien", 2020, "9789510468524", 20.45));
			repository.save(new Book("Taivaallinen vastaanotto", "Jukka Viikilä", 2021, "9789511325642", 16.95));
		
			log.info("fetch all books");
			for(Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}
