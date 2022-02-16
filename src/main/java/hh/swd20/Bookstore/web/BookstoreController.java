package hh.swd20.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.Bookstore.domain.BookRepository;

@Controller
public class BookstoreController {

@Autowired
private BookRepository repository;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String Books(Model model) {
		String hello = "Hello, welcome to the Bookstore.";
		model.addAttribute("index", hello);
		return "index";
	}
	
	@RequestMapping(value = "/booklist")
	public String Booklist(Model model) {
		model.addAttribute("booklist", repository.findAll());
		return "booklist";
	}
}
