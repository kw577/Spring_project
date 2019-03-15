package net.kzn.onlineshopping.handler;

import org.springframework.stereotype.Component;

import net.kzn.onlineshopping.model.RegisterModel;
import net.kzn.shoppingbackend.dto.Address;
import net.kzn.shoppingbackend.dto.User;

@Component // aby klasa byla traktowana jako bean
public class RegisterHandler {

	public RegisterModel init() {
		
		return new RegisterModel();
	}
	
	
	public void addUser(RegisterModel registerModel, User user) {
		  registerModel.setUser(user);
 
	}
	
	 public void addBilling(RegisterModel registerModel, Address billing) {
		  registerModel.setBilling(billing);
	}
	 
	 
	 
}
