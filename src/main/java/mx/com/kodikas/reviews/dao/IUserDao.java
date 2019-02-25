package mx.com.kodikas.reviews.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import mx.com.kodikas.reviews.entities.User;

public interface IUserDao extends CrudRepository<User, Long>{
    public User findByEmailAndPassword(String email, String password);
    public User findByEmail(String email);
    public Optional<User> findById(Long id);
}
