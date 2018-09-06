package net.kzn.shoppingbackend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend.dto.Product;


@Repository("productDAO") // oznacza ze klasa jest klasa dostepu do danych
@Transactional // wszystkie metody klasy dzialaja na zasadzie transacji (dostep do bazy danych)
public class ProductDAOImpl implements ProductDAO {

	@Autowired  // wstrzykiwanie beana
	private SessionFactory sessionFactory;
	
	/*
	 * SINGLE
	 * */
	// zwraca produkt o okreslonym id
	@Override
	public Product get(int productId) {
		try {			
			return sessionFactory
					.getCurrentSession()
						.get(Product.class,Integer.valueOf(productId));			
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}
		return null;
	}

	/*
	 * LIST - wyswietla liste wszystkich produktow
	 * */
	
	@Override
	public List<Product> list() {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Product" , Product.class)
						.getResultList();
	}

	/*
	 * INSERT - dodawanie nowego produktu
	 * */
	@Override
	public boolean add(Product product) {
		try {			
			sessionFactory
					.getCurrentSession()
						.persist(product);
			return true;
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;
	}

	/*
	 * UPDATE = aktualizacja produktu
	 * */
	@Override
	public boolean update(Product product) {
		try {			
			sessionFactory
					.getCurrentSession()
						.update(product);
			return true;
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;		
	}

	
	/*
	 * DELETE
	 * */
	@Override
	public boolean delete(Product product) {
		try {
			
			product.setActive(false);
			// call the update method
			return this.update(product);
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;			
	}

	
	
	////////////////////// Dodatkowe MEtody - ktorych nie bylo w klasie Category
	
	@Override
	public List<Product> listActiveProducts() {
		String selectActiveProducts = "FROM Product WHERE active = :active";
		// "FROM Product WHERE active .... "" - Product to nazwa biezacej klasy 
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveProducts,Product.class)
						.setParameter("active", true)
							.getResultList();
					
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String selectActiveProductsByCategory = "FROM Product WHERE active = :active AND categoryId = :categoryId";
		// "FROM Product WHERE active .... "" - Product to nazwa klasy 
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveProductsByCategory,Product.class)
						.setParameter("active", true)
						.setParameter("categoryId", categoryId)
							.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Product WHERE active = :active ORDER BY id",Product.class)
						.setParameter("active", true)
							.setFirstResult(0)  // zapytanie pobiera z bazy danych liste produktow uporzadkowana wg id - nastepnie ustawiamy ze maksymalna ilosc rezutatow wynosi count - czyli liczbe wybrana przez uzytkownika 
							.setMaxResults(count)  //zwraca maksymalnie tyle produktow ile wybral uzytkownik
								.getResultList();					
	}

}
