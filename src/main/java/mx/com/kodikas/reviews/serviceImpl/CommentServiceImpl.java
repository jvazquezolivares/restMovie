package mx.com.kodikas.reviews.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.kodikas.reviews.dao.ICommentDao;
import mx.com.kodikas.reviews.entities.Comment;
import mx.com.kodikas.reviews.service.ICommentService;

@Service
public class CommentServiceImpl implements ICommentService{
	
    @Autowired
    ICommentDao commentDao;

	@Override
	@Transactional
	public Comment createComment(Comment comment) {
		return commentDao.save(comment);
	}

}
