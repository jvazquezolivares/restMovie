package mx.com.kodikas.reviews.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Comment implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	@Column(name = "comment")
	String comment;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user = new User();

	@Column(name="created_at")
	@Temporal(TemporalType.DATE)
	private Date createdAt;
	
	@PrePersist
	public void prePersist() {
		this.createdAt = new Date();
	}
	
	
	
	private Long getId() {
		return id;
	}



	private void setId(Long id) {
		this.id = id;
	}



	private Date getCreatedAt() {
		return createdAt;
	}



	private void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
