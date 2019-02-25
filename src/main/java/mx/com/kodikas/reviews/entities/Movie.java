package mx.com.kodikas.reviews.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity class Movie
 * @author Javier Vázquez
 * */
@Entity
@Table(name = "movies")
public class Movie implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name="synopsis")
	private String synopsis;
	
	@Column(name="review")
	private String review;
	
    @Lob
	@Column(name="poster", columnDefinition="mediumblob")
	private byte[] poster;
	
	@Column(name="premier_date")
	@Temporal(TemporalType.DATE)
	private Date premierDate;

	@Column(name="created_at")
	@Temporal(TemporalType.DATE)
	private Date createdAt;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user = new User();

	@OneToMany(mappedBy = "movie" , cascade = CascadeType.ALL)
	@OrderBy("createdAt ASC")
	private List<Comment> comments = new ArrayList<>();
	
	@PrePersist
	public void prePersist() {
		this.createdAt = new Date();
	}

	/**
	 * Returns entity's id
	 * @return entity's id
	 * */
	public Long getId() {
		return id;
	}

	/**
	 * Set id value
	 * @param id - The id of entity
	 * */
	public void setId(Long id) {
		this.id = id;
	}

	
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public byte[] getPoster() {
		return poster;
	}

	public void setPoster(byte[] poster) {
		this.poster = poster;
	}

	public Date getPremierDate() {
		return premierDate;
	}

	public void setPremierDate(Date premierDate) {
		this.premierDate = premierDate;
	}

	public User getUser() {
		return user;
	}


    public void setUser(User user) {
		this.user = user;
	}
	
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	


	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", synopsis=" + synopsis + ", review=" + review + ", poster="
				+ Arrays.toString(poster) + ", premierDate=" + premierDate + ", createdAt=" + createdAt + ", user="
				+ user + ", comments=" + comments + "]";
	}




	/**
	 * 
	 */
	public static final long serialVersionUID = 1L;
}
