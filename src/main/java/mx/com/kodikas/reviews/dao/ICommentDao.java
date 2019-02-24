package mx.com.kodikas.reviews.dao;

import org.springframework.data.repository.CrudRepository;

import mx.com.kodikas.reviews.entities.Comment;

public interface ICommentDao extends CrudRepository<Comment, Long>{
}
