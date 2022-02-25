package hh.swd20.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner categorydemo(CategoryRepository repository) {
		return(args) -> {
			log.info("Save a couple of categories");
			repository.save(new Category("Sci-Fi"));
			repository.save(new Category("Comic"));
			repository.save(new Category("Fiction"));
		
			log.info("fetch all books");
			for(Category category : repository.findAll()) {
				log.info(category.toString());
			}
		};
	}
	
	@Bean
	public CommandLineRunner bookdemo(BookRepository repository, CategoryRepository categoryrepository) {
		return(args) -> {
			log.info("Save a couple of books");
			Category category1 = new Category("Fantasy");
			categoryrepository.save(category1);
			Category category2 = new Category("Comic");
			categoryrepository.save(category2);
			Category category3 = new Category("Fiction");
			categoryrepository.save(category3);
			
			repository.save(new Book("Hobitti", "J. R. R. Tolkien", 2020, "9789510468524", 20.45, category1 ));
			repository.save(new Book("Taivaallinen vastaanotto", "Jukka Viikilä", 2021, "9789511325642", 16.95, category3));
		
			log.info("fetch all books");
			for(Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}
	
	

}
