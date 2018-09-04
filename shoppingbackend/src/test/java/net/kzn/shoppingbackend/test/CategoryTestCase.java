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

}