package edu.jhu.cs.oose.montage.kryonet.request;
import edu.jhu.cs.oose.montage.model.iface.media.Media;

/**
 * Represents a request to update a piece of media with an upvote/downvote or a comment
 * @author Greg Kogut
 *
 */
public class UpdateMedia {
	/**Media we want to update.*/
	private Media media;

	/**
	 * UpdateMedia constructor.
	 * @param media media we want to update
	 */
	public UpdateMedia(Media media) {
		super();
		this.media = media;
	}
	
	/**
	 * Default constructor for Kryonet.
	 */
	public UpdateMedia() {
	}

	/**
	 * Get the media we want to update.
	 * @return the media
	 */
	public Media getMedia() {
		return media;
	}
	
	
}
