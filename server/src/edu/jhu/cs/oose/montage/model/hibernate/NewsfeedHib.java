package edu.jhu.cs.oose.montage.model.hibernate;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import edu.jhu.cs.oose.montage.model.abs.NewsfeedAbs;
import edu.jhu.cs.oose.montage.model.hibernate.media.MediaHib;
import edu.jhu.cs.oose.montage.model.iface.Newsfeed;
import edu.jhu.cs.oose.montage.model.iface.media.Media;

/**
 * Newsfeed hibernate class.
 * @author Greg Kogut, Da Lu
 *
 */
@Entity
public class NewsfeedHib extends NewsfeedAbs {
	private List<Media> currentNewsFeed; 
	/**Id for this entry in the database.*/
	private int id;
	
	/**
	 * Getter for the database id.
	 */
	@Id
	@GeneratedValue
	public int getID() {
		return this.id;
	}
	
	/**
	 * Setter for id.
	 * @param id id
	 */
	public void setID(int id) {
		this.id = id;
	}
	
	/**
	 * Getter for this list of media.
	 */
	@Override
	@OneToMany(targetEntity=MediaHib.class)
	public List<Media> getCurrentNewsFeed() {
		
		return this.currentNewsFeed;
	}

	/**
	 * Setter for Newsfeed.
	 * @param currentNewsFeed desired list 
	 */
	public void setCurrentNewsFeed(List<Media> currentNewsFeed) {
		this.currentNewsFeed = currentNewsFeed;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}


}
