package net.kzn.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

// adnotacja @Repository nalezy do frameworku Spring
@Repository("categoryDAO") // polaczenie z projektem frontendu "categoryDAO" odpowiada nazwie obiektu w PageController - adnotacja @Autowired
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	/*
	
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
	*/
	
	// zwraca liste aktywnych kategorii
	@Override
	public List<Category> list() {
		
		// w hibernate jako nazwy tabeli uzywa sie nazwy klasy
		String selectActiveCategory = "FROM Category WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	
	// metoda pobiera z bazy danych kategorie o okreslonym id
	@Override
	public Category get(int id) {
		
		
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	// dodanie nowej kategorii do bazy danych
	@Override
	public boolean add(Category category) {
		
		try {
			// nawiazanie polaczenia z baza danych 
			sessionFactory.getCurrentSession().persist(category);
			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}

		
	}

	// metoda sluzy do updatowania kategorii w bazie danych
	@Override
	public boolean update(Category category) {
		try {
		
			sessionFactory.getCurrentSession().update(category);
			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		
		category.setActive(false); // kategoria nie jest tak wlasciewie usuwana tylko jej status jest ustawiany na nieaktywna
		
		// po zmianie statusu wybranej kategorii nastepuje jej update 
		try {
			
			sessionFactory.getCurrentSession().update(category);
			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
