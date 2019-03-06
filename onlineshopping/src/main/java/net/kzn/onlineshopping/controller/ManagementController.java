package net.kzn.onlineshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.kzn.onlineshopping.util.FileUploadUtility;
import net.kzn.onlineshopping.validator.ProductValidator;
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
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult results, Model model, HttpServletRequest request) { // @ModelAttribute("product") - jak w manageProducts.jsp
		
		// sprawdzenie czy nastapily bledy przy uploadzie pliku
		new ProductValidator().validate(mProduct, results);
		
		
		// sprawdzenie czy wystapily jakies bledy przy walidacji - nastapi ponowne wczytanie formularza
		if(results.hasErrors()) {
			
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Manage Products");
			model.addAttribute("message", "Validation failed for Product Submission!");
			return "page";
		}
		
		// wydruk informacji w konsoli
		logger.info(mProduct.toString());
		
		// create a new product record
		productDAO.add(mProduct);
		
		if(!mProduct.getFile().getOriginalFilename().equals("")) {
			
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}
		
		
		return "redirect:/manage/products?operation=product";
	}
	
	
	@RequestMapping(value = "/product/{id}/activation", method=RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id) {
		
		// pobranie produktu z bazy danych
		Product product = productDAO.get(id);
		
		boolean isActive = product.isActive();
		
		//zmiana statusu aktywnosci produktu na przeciwny (dezaktywacja - aktywacja)
		product.setActive(!product.isActive());		
		
		//zapis zmian w bazie
		productDAO.update(product);
		
		return (isActive)? "You have succesfully deactivated the product with id " + product.getId() 
						 : "You have succesfully activated the product with id " + product.getId();
	}
	
	
	// zwraca kategorie dla wszystkich mapowan typu http://localhost:8080/onlineshopping/manage/...
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		
		return categoryDAO.list();
	}
	
	
}
