package net.kzn.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	// funkcja zwracajaca ModelAndView - zawartosc strony 
	@RequestMapping(value = {"/", "/home", "/index"}) // adres html np: http://localhost:8080/onlineshopping/home
	public ModelAndView index() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting","Welcome to Spring Web MVC");
		mv.addObject("title", "Online Shopping");
		return mv;
		
		
	}
	
	/*
	// funkcja ponizej napisana do celow testowych
	// greeting to parametr zapytania html - w zaleznosci od jego wartosci zostanie wyswietlona inna zawartosc 
	@RequestMapping(value = {"/test"}) // adres html: http://localhost:8080/onlineshopping/test  adres html: http://localhost:8080/onlineshopping/test?greeting=good morning
	public ModelAndView test(@RequestParam(value = "greeting", required = false) String greeting) { // required = false - adres html nie musi koniecznie zawierac parametru greeting
		
		// jesli w adresie html nie podano parametru greeting
		if(greeting == null) {
			greeting = "Hello";
		}
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting",greeting);
		return mv;
	}
	*/
	// funkcja testowa
	// funkcja z parametrem dynamicznym
	// greeting to parametr zapytania html - w zaleznosci od jego wartosci zostanie wyswietlona inna zawartosc 
		@RequestMapping(value = {"/test/{greeting}"}) // adres html: http://localhost:8080/onlineshopping/test/trescPwitania
		public ModelAndView test(@PathVariable("greeting") String greeting) { 
			
			// jesli w adresie html nie podano parametru greeting
			if(greeting == null) {
				greeting = "Hello";
			}
			
			ModelAndView mv = new ModelAndView("page");
			mv.addObject("greeting",greeting);
			return mv;
		}
	
	
	
	
	
	
	
}
