package net.kzn.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;
import net.kzn.shoppingbackend.dto.Product;

// klasa sluzy do obslugi sklepu od itrony administratora

@Controller
@RequestMapping("/manage") 
public class ManagementController {
	
	@Autowired
	private CategoryDAO categoryDAO;

	@RequestMapping(value = "/products", method = RequestMethod.GET) // adresy typu:  http://localhost:8080/onlineshopping/manage/products 
	public ModelAndView showManageProducts() {
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("userClickManageProducts", true); // zmienna pomocnicza do okreslenia wyswietlania odpowiedniej zawartosci strony
		mv.addObject("title", "Manage Products");
		Product nProduct = new Product();
		
		// set few of the fields
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		
		mv.addObject("product", nProduct);
		
		return mv;
	}
	
	// zwraca kategorie dla wszystkich mapowan typu http://localhost:8080/onlineshopping/manage/....
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		
		return categoryDAO.list();
	}
	
	
}
