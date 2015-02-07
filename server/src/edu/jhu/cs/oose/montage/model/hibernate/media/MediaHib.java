package edu.jhu.cs.oose.montage.model.hibernate.media;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import edu.jhu.cs.oose.montage.model.abs.media.MediaAbs;
import edu.jhu.cs.oose.montage.model.hibernate.CoordinatesHib;
import edu.jhu.cs.oose.montage.model.hibernate.UserHib;
import edu.jhu.cs.oose.montage.model.iface.Coordinates;
import edu.jhu.cs.oose.montage.model.iface.User;

/**
 * Media hibernate class.
 * @author Greg Kogut, Da Lu
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class MediaHib extends MediaAbs {
	private Coordinates coordinates;
	private List<User> userUpVotes ;
	private List<User> userDownVotes;
	private Calendar uploadTime;
	private List<String> comments;
	/**Id of this entry in the database.*/
	private int id;
	

	/**
	 * Getter for user upvotes.
	 */
	@OneToMany(targetEntity=UserHib.class)
	public List<User> getUserUpVotes() {
		
		return this.userUpVotes;
	}

	/**
	 * Setter for user upvotes.
	 * @param userUpVotes upvotes
	 */
	public void setUserUpVotes(List<User> userUpVotes) {
		this.userUpVotes = userUpVotes;
	}

	/**
	 * Getter for user downvotes.
	 */
	@OneToMany(targetEntity=UserHib.class)
	public List<User> getUserDownVotes() {
		// TODO Auto-generated method stub
		return this.userDownVotes;
	}
	
	/**
	 * Setter for user downvotes
	 * @param userDownVotes
	 */
	public void setUserDownVotes(List<User> userDownVotes) {
		this.userDownVotes = userDownVotes;
	}

	/**
	 * Getter for upload time.
	 */
	@Basic
	public Calendar getUploadTime() {
		
		return this.uploadTime;
	}

	/**
	 * Setter for upload time.
	 * @param uploadTime upload time
	 */
	public void setUploadTime(Calendar uploadTime) {
		this.uploadTime = uploadTime;
	}

	/**
	 * Getter for coordinates.
	 */
	@OneToOne(targetEntity=CoordinatesHib.class)
	public Coordinates getCoordinates() {
		
		return this.coordinates;
	}

	/**
	 * Setter for coordinates of this media.
	 * @param coordinates coordinates
	 */
	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	/**
	 * Getter for database id.
	 */
	@Id
	@GeneratedValue
	public int getID() {
		
		return this.id;
	}
	
	/**
	 * Setter for this media's database id.
	 * @param id id
	 */
	public void setID(int id) {
		this.id = id;
	}

	@ElementCollection
	@CollectionTable(name="comments")
	@Column(name="comments")
	public List<String> getComments() {
		
		return this.comments;
	}

	public void setComments(List<String> co) {
		this.comments = co;
		
	}
	

}
