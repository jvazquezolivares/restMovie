package mx.com.kodikas.reviews.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.kodikas.reviews.dao.IUserDao;
import mx.com.kodikas.reviews.entities.User;
import mx.com.kodikas.reviews.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserDao userDao;
	
	@Override
	@Transactional
	public User findUser(User user) {
		return userDao.findByEmail(user.getEmail());
	}
	
	@Override
	@Transactional
	public User createUser(User user) {
		return userDao.save(user);
	}

	@Override
	public User userLogin(String email, String password) {
		return userDao.findByEmailAndPassword(email, password);
	}

}
