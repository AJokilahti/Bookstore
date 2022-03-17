package hh.swd20.Bookstore.domain;

import javax.persistence.*;

@Entity
public class User {

	// ID, NOT NULL, NOT UPDATABLE
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id", nullable=false, updatable=false)
	private Long id;
	
	// USERNAME, NOT NULL, UNIQUE
	@Column(name="username", nullable=false, unique=true)
	private String username;
	
	// PASSWORD, NOT NULL
	@Column(name="password", nullable=false)
	private String password;
	
	// EMAIL, NOT NULL
	@Column(name="email", nullable=false)
	private String email;
	
	// ROLE, NOT NULL
	@Column(name="role", nullable=false)
	private String role;
	
	// CONSTRUCTOR WITHOUT FIELDS
	public User() {
		
	}
	
	// CONSTRUCTOR WITH STRINGS
	public User (String username, String password, String email, String role) {
		super();
		this.username=username;
		this.password=password;
		this.email=email;
		this.role=role;
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getRole() {
		return role;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", role="
				+ role + "]";
	}
	
	
	
	
	
}
