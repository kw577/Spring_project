package net.kzn.onlineshopping.exception;
import java.io.Serializable;


// User defined exception - struktura

 public class ProductNotFoundException extends Exception implements Serializable {
 	/**
	 * Adresy typu http://localhost:8080/onlineshopping/show/{id}/product  sa obslugiwane - jest to wyswietlanie
	 * informacji o wybranym produkcie ale jesli w miejsce id wpisze sie numer produktu ktorego nie ma w bazie danych 
	 * zostanie wyrzucona informacja o bledzie
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	// konstruktor 1
	public ProductNotFoundException() {
		this("Product is not available!");
	}
	
	// konstruktor 2
	public ProductNotFoundException(String message) {
		this.message = System.currentTimeMillis() + ": " + message;
	}
	
 	public String getMessage() {
		return message;
	}
}