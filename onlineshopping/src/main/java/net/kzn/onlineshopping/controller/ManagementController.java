package net.kzn.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

// klasa sluzy do obslugi sklepu od itrony administratora

@Controller
@RequestMapping("/manage") 
public class ManagementController {

	@RequestMapping(value = "/products", method = RequestMethod.GET) // adresy typu:  http://localhost:8080/onlineshopping/manage/products 
	public ModelAndView showManageProducts() {
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("userClickManageProducts", true); // zmienna pomocnicza do okreslenia wyswietlania odpowiedniej zawartosci strony
		mv.addObject("title", "Manage Products");
		
		
		
		return mv;
	}
}
