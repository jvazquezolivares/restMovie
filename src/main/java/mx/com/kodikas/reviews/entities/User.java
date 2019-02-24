package mx.com.kodikas.reviews.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	@Column(name= "user_name")
	private String userName;
	
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "password")
	private String password;

	@Column(name="created_at")
	@Temporal(TemporalType.DATE)
	private Date createdAt;
	
	
	//Joins
	@OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
	private List<Movie> movies = new ArrayList<>();
	
	@OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL)
	private List<Comment> comments = new ArrayList<>();
	
	
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
