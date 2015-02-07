package edu.jhu.cs.oose.montage.model.abs;

import edu.jhu.cs.oose.montage.model.iface.User;
import edu.jhu.cs.oose.montage.model.iface.media.Media;

/**
 * Abstract user class.
 * @author Da Lu, Zachary Palmer, Greg Kogut
 *
 */
public abstract class UserAbs implements User{

	/**
	 * Default constructor.
	 */
	public UserAbs() {
		super();
	}

	/**
	 * Add a user upvote to this media.
	 */
	public void upVoteMedia(Media media) {
		// this function returns boolean, not sure if needed yet
		media.addToUpVotes(this);
	}

	@Override
	public void downVoteMedia(Media media) {
		// this function returns boolean, not sure if needed yet
		media.addToDownVotes(this);
	}

}