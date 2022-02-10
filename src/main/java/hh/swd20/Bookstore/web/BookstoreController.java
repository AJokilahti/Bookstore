package hh.swd20.Bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookstoreController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String Books(Model model) {
		String hello = "Hello, welcome to the Bookstore. Here are some books:";
		model.addAttribute("bookslist", hello);
		return "bookslist";
	}
}
