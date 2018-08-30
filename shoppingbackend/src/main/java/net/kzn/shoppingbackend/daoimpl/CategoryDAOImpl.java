package net.kzn.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

public class CategoryDAOImpl implements CategoryDAO {

	// stala lista kategorii - do celow testowych
	private static List<Category> categories = new ArrayList<>();	
	
	static {
		Category category = new Category();
		
		// adding first category
		category.setId(1);
		category.setName("Television");
		category.setDescription("This is some description for television!");
		category.setImageURL("CAT_1.png");
		
		categories.add(category);
		
		// adding second category
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is some description for Mobile!");
		category.setImageURL("CAT_2.png");
				
		categories.add(category);
		
		
		// adding third category
		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is some description for Laptop!");
		category.setImageURL("CAT_3.png");
				
		categories.add(category);
				
	}
	
	//////////////// stala lista kategorii - test 
	
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

}
