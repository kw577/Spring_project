package net.kzn.onlineshopping.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dto.Category;
import net.kzn.shoppingbackend.dto.Product;

// klasa sluzy do obslugi sklepu od itrony administratora

@Controller
@RequestMapping("/manage") 
public class ManagementController {
	
	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private ProductDAO productDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);
	
	@RequestMapping(value = "/products", method = RequestMethod.GET) // adresy typu:  http://localhost:8080/onlineshopping/manage/products 
	public ModelAndView showManageProducts(@RequestParam(name="operation", required=false) String operation) {
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("userClickManageProducts", true); // zmienna pomocnicza do okreslenia wyswietlania odpowiedniej zawartosci strony
		mv.addObject("title", "Manage Products");
		Product nProduct = new Product();
		
		// set few of the fields
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		
		mv.addObject("product", nProduct);
		
		// jesli dodano produkt wyswietli sie odpowiednia informacja
		if(operation!=null) {
			if(operation.equals("product")) {
				mv.addObject("message", "Product Submitted Successfully!");
			}
		}
		
		
		return mv;
	}
	
	// dodawanie nowego produktu poprzez formularz administratora
	@RequestMapping(value = "/products", method = RequestMethod.POST) 
	public String handleProductSubmission(@ModelAttribute("product") Product mProduct) { // @ModelAttribute("product") - jak w manageProducts.jsp
		
		// wydruk informacji w konsoli
		logger.info(mProduct.toString());
		
		// create a new product record
		productDAO.add(mProduct);
		
		return "redirect:/manage/products?operation=product";
	}
	
	// zwraca kategorie dla wszystkich mapowan typu http://localhost:8080/onlineshopping/manage/....
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		
		return categoryDAO.list();
	}
	
	
}
