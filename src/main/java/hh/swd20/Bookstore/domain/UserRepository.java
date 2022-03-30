package hh.swd20.Bookstore.domain;


import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{

	// Find users by userName
	
	User findByUsername(String username);
	
}