package net.kzn.shoppingbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// Uruchomienie konsoli bazy danych -  C:\Program Files\h2\bin\h2-1.4.197

@Entity
public class Category {

	/*
	 * Private fields
	 */
		
	
	@Id // pole id jest kluczem glownym w tabeli Category bazy danych
	@GeneratedValue(strategy = GenerationType.IDENTITY) // automatyczne generowanie klucza glownego
	private int id; // nazwa atrybutu taka sama jak w tabeli bazy danych
	
	private String name;
	private String description;
	
	@Column(name = "image_url") // nazwa atrybutu inna niz odpowiadajaca mu kolumna w tabeli bazy danych
	private String imageURL;
	
	@Column(name = "is_active") // nazwa atrybutu inna niz odpowiadajaca mu kolumna w tabeli bazy danych
	private boolean active = true;
	
	
	
	
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + ", imageURL=" + imageURL
				+ ", active=" + active + "]";
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
}
