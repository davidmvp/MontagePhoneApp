package edu.jhu.cs.oose.montage.model.abs.media;

import java.util.List;

import edu.jhu.cs.oose.montage.model.iface.User;
import edu.jhu.cs.oose.montage.model.iface.media.Media;

/**
 * Abstract Media class
 * @author Greg Kogut, Da Lu, Zachary Palmer
 *
 */
public abstract class MediaAbs implements Media {

	/**
	 * Default constructor.
	 */
	public MediaAbs() {
		super();
	}

	/**
	 * Adds an upvote to a piece of media.
	 */
	public boolean addToUpVotes(User uId) {
	    if (!this.getUserUpVotes().contains(uId)) {
	        this.getUserUpVotes().add(uId);
	        
	        return true;
	    } else {
	        return false;
	    }
	}

	/**
	 * Adds a downvote to a piece of media.
	 */
	public boolean addToDownVotes(User uId) {
	    if (!this.getUserDownVotes().contains(uId)) {
	        this.getUserDownVotes().add(uId);
	        
	        return true;
	    } else {
	        return false;
	    }
	}
	
	public void addComment(String comment) {
		this.getComments().add(comment);
	}

}