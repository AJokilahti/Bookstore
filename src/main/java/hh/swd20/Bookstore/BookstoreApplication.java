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
import hh.swd20.Bookstore.domain.User;
import hh.swd20.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	
	
	@Bean
	public CommandLineRunner bookdemo(BookRepository repository, CategoryRepository categoryrepository, UserRepository userRepository) {
		return(args) -> {
			
			log.info("Save a couple of books");
			
			// CREATING A FEW CATEGORIES
			Category category1 = new Category("Fantasy");
			categoryrepository.save(category1);
			Category category2 = new Category("Classics");
			categoryrepository.save(category2);
			Category category3 = new Category("Fiction");
			categoryrepository.save(category3);
			
			// CREATING A FEW BOOKS
			repository.save(new Book("Hobitti", "J. R. R. Tolkien", 2020, "9789510468524", 20.45, category1 ));
			repository.save(new Book("Taivaallinen vastaanotto", "Jukka Viikilä", 2021, "9789511325642", 16.95, category3));
		
			// CREATING A FEW USERS: User/user, Admin/admin (INCL. BCRYPTED PASSWORDS)
			User user1 = new User("User", "$2a$10$9yfGRcHyQvNpqFl1tNQlweVnKviaCXukBOfjDEZfIyUn94QDJIuPK", "user@user.fi", "USER");
			User user2 = new User("Admin", "$2a$10$apV2clZPd7JMQB3qds34AujGis7LNDcBdA7SUZ/zeCOLfs3vNOKQK", "admin@admin.fi", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);
			
			log.info("fetch all users");
			for(User user : userRepository.findAll()) {
				log.info(user.toString());
			}
			
			log.info("fetch all books");
			for(Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}
	
	

}
