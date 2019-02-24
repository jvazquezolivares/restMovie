package mx.com.kodikas.reviews.service;

import mx.com.kodikas.reviews.entities.User;

public interface IUserService {
	
	public User createUser(User user);
	
	public User userLogin(String email, String password);

}
