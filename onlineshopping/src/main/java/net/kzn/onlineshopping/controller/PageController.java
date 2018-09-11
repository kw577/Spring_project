package net.kzn.onlineshopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dto.Category;
import net.kzn.shoppingbackend.dto.Product;

@Controller
public class PageController {
	
	// do drukowania logow w konsoli
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired // polaczenie z projektem Backendu - adnotacja @Repository CategoryDAO znajduje sie w projekcie shoppingbackend - CategoryDAOImpl
	private CategoryDAO categoryDAO;
	
	@Autowired // polaczenie z projektem Backendu - adnotacja @Repository CategoryDAO znajduje sie w projekcie shoppingbackend - CategoryDAOImpl
	private ProductDAO productDAO;

	// funkcja zwracajaca ModelAndView - zawartosc strony
	@RequestMapping(value = { "/", "/home", "/index" }) // adres html np: http://localhost:8080/onlineshopping/home
	public ModelAndView index() {

		ModelAndView mv = new ModelAndView("page");
		// mv.addObject("greeting","Welcome to Spring Web MVC");
		mv.addObject("title", "Home");
		
		logger.info("Inside PageController index method - INFO"); // informacja w konsoli
		logger.debug("Inside PageController index method - DEBUG");
		
		mv.addObject("categories", categoryDAO.list());
		
		mv.addObject("userClickHome", true);
		return mv;

	}

	// funkcja uruchamia sie gdy na pasku nawigacji nacisnie sie przycisk "about" -
	// przycisk ten jest odnosnikiem do adresu onlineshopping/about
	@RequestMapping(value = { "about" })
	public ModelAndView about() {

		ModelAndView mv = new ModelAndView("page");
		// mv.addObject("greeting","Welcome to Spring Web MVC");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;

	}

	// funkcja uruchamia sie gdy na pasku nawigacji nacisnie sie przycisk "Contact"
	// - przycisk ten jest odnosnikiem do adresu onlineshopping/contact
	@RequestMapping(value = { "contact" })
	public ModelAndView contact() {

		ModelAndView mv = new ModelAndView("page");
		// mv.addObject("greeting","Welcome to Spring Web MVC");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;

	}

	/*
	 * // funkcja ponizej napisana do celow testowych // greeting to parametr
	 * zapytania html - w zaleznosci od jego wartosci zostanie wyswietlona inna
	 * zawartosc
	 * 
	 * @RequestMapping(value = {"/test"}) // adres html:
	 * http://localhost:8080/onlineshopping/test adres html:
	 * http://localhost:8080/onlineshopping/test?greeting=good morning public
	 * ModelAndView test(@RequestParam(value = "greeting", required = false) String
	 * greeting) { // required = false - adres html nie musi koniecznie zawierac
	 * parametru greeting
	 * 
	 * // jesli w adresie html nie podano parametru greeting if(greeting == null) {
	 * greeting = "Hello"; }
	 * 
	 * ModelAndView mv = new ModelAndView("page");
	 * mv.addObject("greeting",greeting); return mv; }
	 */

	/*
	 * // funkcja testowa // funkcja z parametrem dynamicznym // greeting to
	 * parametr zapytania html - w zaleznosci od jego wartosci zostanie wyswietlona
	 * inna zawartosc 
	 * 
	 * @RequestMapping(value = {"/test/{greeting}"}) // adres html:
	 * http://localhost:8080/onlineshopping/test/trescPwitania public ModelAndView
	 * test(@PathVariable("greeting") String greeting) {
	 * 
	 * // jesli w adresie html nie podano parametru greeting if(greeting == null) {
	 * greeting = "Hello"; }
	 * 
	 * ModelAndView mv = new ModelAndView("page");
	 * mv.addObject("greeting",greeting); return mv; }
	 * 
	 */
	
	
	/*
	 * Methods to load all the products and based on category
	 */
	@RequestMapping(value = { "show/all/products" }) 
	public ModelAndView showAllProducts() {

		ModelAndView mv = new ModelAndView("page");
	
		mv.addObject("title", "All Products");
		
		mv.addObject("categories", categoryDAO.list());	
			
		mv.addObject("userClickAllProducts", true);
		return mv;

	}
	

	@RequestMapping(value = { "show/category/{id}/products" }) 
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {

		ModelAndView mv = new ModelAndView("page");
	
		// categoryDAO to fetch a single category
		Category category = null;
		
		category = categoryDAO.get(id);
		
		mv.addObject("title", category.getName());
		
		// lista kategorii
		mv.addObject("categories", categoryDAO.list());	
			
		// passing the single category object
		mv.addObject("category", category);	
		
		mv.addObject("userClickCategoryProducts", true);
		return mv;

	}
	
	/*
	 * Podglad informacji o pojedynczym produkcie - adresy typu np http://localhost:8080/onlineshopping/show/4/product
	 */
	
	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("page");
		
		Product product = productDAO.get(id);
		
		// zwieksza liczik wyswietlen wybranego produktu
		product.setViews(product.getViews() + 1); 
		productDAO.update(product);
		//-----------------------
		
		
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		
		mv.addObject("userClickShowProduct", true); // zmienna pomocnicza wykorzystywana w pliku page.jsp do ustalenia jaa zawartosc strony ma byc wyswietlona
		
		return mv;
	}
	
	
	
	
}
