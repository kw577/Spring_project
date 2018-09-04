package net.kzn.shoppingbackend.test;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

public class CategoryTestCase {
	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.kzn.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	
	// Uruchamianie testu: prawy przycisk myszy -> Run as -> JUnit test
	
	/*
	// Test - dodanie nowej kategorii do bazy danych
	@Test
	public void testAddCategory() {

		category = new Category();

		category.setName("Laptop");
		category.setDescription("This is some description for laptop!");
		category.setImageURL("CAT_105.png");

		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));
		// po udanym ddaniu nowej kategorii (metoda add(CAtegory category) z klasy CategoryDAO.impl zwraca true) pojawi sie komunikat "Successfully added a category ..."
	
	
	}
	*/
	/*
	@Test
	public void testGetCategory() {
		
		category = categoryDAO.get(2);
		
		
		assertEquals("Successfully fetched a single category from the table!","Television",category.getName());
		// jesli zostania pobrane informacje o kategorii nr 2 (metoda category.getName() z klasy CategoryDAO.impl zwraca "Television") pojawi sie komunikat "Successfully fetched a single category ..."
		
		
	}
	*/
	
	/*
	@Test
	public void testUpdateCategory() {
		
		category = categoryDAO.get(3);
		
		category.setName("TV");
		
		assertEquals("Successfully updated a single category in the table!",true,categoryDAO.update(category));
		
		
	}
	*/

	/*
	@Test
	public void testDeleteCategory() {
		
		category = categoryDAO.get(3);		
		assertEquals("Successfully deleted a single category in the table!",true,categoryDAO.delete(category));
		
		
	}
	*/
	
	
	/*
	@Test
	public void testListCategory() {
					
		assertEquals("Successfully fetched the list of categories from the table!",3,categoryDAO.list().size());
		// jesli zostania pobrane informacje aktywnych kategoriach i ich ilosc jest rowna 3 - aktualna ilosc rekordow w tej tabeli bazy danych (metoda categoryDAO.list().size() zwraca 3) pojawi sie komunikat "Successfully fetched the list ..."
		
		
	}
	*/

	// test zbiorczy
	@Test
	public void testCRUDCategory() {
		
		// add operation
		category = new Category();
		
		category.setName("Laptop");
		category.setDescription("This is some description for laptop!");
		category.setImageURL("CAT_1.png");
		
		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));
		
		
		category = new Category();
		
		category.setName("Television");
		category.setDescription("This is some description for television!");
		category.setImageURL("CAT_2.png");
		
		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));

		
		// fetching and updating the category
		category = categoryDAO.get(2);
		
		category.setName("TV");
		
		assertEquals("Successfully updated a single category in the table!",true,categoryDAO.update(category));
		
		
		// delete the category
		assertEquals("Successfully deleted a single category in the table!",true,categoryDAO.delete(category));
		
		
		//fetching the list
		assertEquals("Successfully fetched the list of categories from the table!",1,categoryDAO.list().size());		
				
		
	}
	
}