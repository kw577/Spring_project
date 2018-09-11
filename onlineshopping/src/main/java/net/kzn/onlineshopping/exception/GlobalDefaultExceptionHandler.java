package net.kzn.onlineshopping.exception;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

// klasa zajmuje sie globalna obsluga bledow - np uzytkownik wpisze nieobslugiwany adres url

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
 	
	// obsluga bledu 404 - nie obslugiwany adres url NoHandlerFoundException - zdefiniiowany w frameworku Spring
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException() {
		
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "The page is not constructed!");
		
		mv.addObject("errorDescription", "The page you are looking for is not available now!");
		
		mv.addObject("title", "404 Error Page");
		
		return mv;
	}
	
	// obslugiwany adres url - ale brak produktu w bazie danych - jesli wpisano id produktu ktorego nie ma w bazie danych
	// ProductNotFoundException - user defined exception - zdefiniowany w klasie ProductNotFoundException.java
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException() {
		
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "Product not available!");
		
		mv.addObject("errorDescription", "The product you are looking for is not available right now!");
		
		mv.addObject("title", "Product Unavailable");
		
		return mv;
	}
		
	// Parametr adresu url ma zly typ danych - np. jesli zamiast numeru id szukanego produktu wpisano ciag liter
	// np adresy typu http://localhost:8080/onlineshopping/show/{id}/product gdy za id wpisze sie ciag liter zamiast numeru
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex) {
		
		ModelAndView mv = new ModelAndView("error"); // plik views/error.jsp
		
		mv.addObject("errorTitle", "Contact Your Administrator!!");
		
		
		/* only for debugging your application*/
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		
		ex.printStackTrace(pw);
						
		mv.addObject("errorDescription", sw.toString());
		
		mv.addObject("title", "Error");
		
		return mv;
	}
			
	
}