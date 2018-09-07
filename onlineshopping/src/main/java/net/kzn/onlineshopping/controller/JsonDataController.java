package net.kzn.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dto.Product;

@Controller // obsluguja zapytania wysylane poprzez przegladarke od uzytkownikow
@RequestMapping("/json/data")  // Dotyczy wszystkich metod zawartych w tej klasie
public class JsonDataController {

	@Autowired // wstrzykiwanie beanu - klasy ProductDAOImpl  
	private ProductDAO productDAO;
	
	@RequestMapping("/all/products")  // adresy typu:  http://localhost:8080/onlineshopping/json/data/all/products 
	@ResponseBody // Spring stara sie przeksztalcic zwrocone wartosci w odpowiedz http (np. konwertujac obiekt na format JSON lub XML)
	public List<Product> getAllProducts(){
		
		
		return productDAO.listActiveProducts();
	}
	
	
	@RequestMapping("/category/{id}/products")   
	@ResponseBody // Spring stara sie przeksztalcic zwrocone wartosci w odpowiedz http (np. konwertujac obiekt na format JSON lub XML)
	public List<Product> getProductsByCategory(@PathVariable int id){
		
		
		return productDAO.listActiveProductsByCategory(id);
	}
	
	// testowanie czy dane sa zwracane w formacie JSON - postman 
	// np http://localhost:8080/onlineshopping/json/data/all/products    -  metoda GET
	// http://localhost:8080/onlineshopping/json/data/category/3/products
}
