package edu.jhu.cs.oose.montage.kryonet.request;

import edu.jhu.cs.oose.montage.model.iface.media.Media;

/**
 * Represents a request to store media on the server.
 * @author Greg Kogut
 *
 */
public class StoreMedia {
	/**The media we want the server to store.*/
	private Media media;

	/**
	 * StoreMedia constructor.
	 * @param media media to store
	 */
	public StoreMedia(Media media) {
		super();
		this.media = media;
	}
	
	/**
	 * Default constructor for Kryonet.
	 */
	public StoreMedia() {
	}

	/**
	 * Get the media we want to store.
	 * @return the media
	 */
	public Media getMedia() {
		return media;
	}
	
}
