package net.kzn.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.kzn.shoppingbackend.dao.CategoryDAO;

@Controller
public class PageController {
	
	@Autowired // polaczenie z projektem Backendu - interface CategoryDAO znajduje sie w projekcie shoppingbackend
	private CategoryDAO categoryDAO;
	

	// funkcja zwracajaca ModelAndView - zawartosc strony
	@RequestMapping(value = { "/", "/home", "/index" }) // adres html np: http://localhost:8080/onlineshopping/home
	public ModelAndView index() {

		ModelAndView mv = new ModelAndView("page");
		// mv.addObject("greeting","Welcome to Spring Web MVC");
		mv.addObject("title", "Home");
		
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

}
