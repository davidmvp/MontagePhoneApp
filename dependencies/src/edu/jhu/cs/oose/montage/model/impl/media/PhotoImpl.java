package edu.jhu.cs.oose.montage.model.impl.media;

import edu.jhu.cs.oose.montage.model.iface.Coordinates;
import edu.jhu.cs.oose.montage.model.iface.media.Photo;

/**
 * Photo class for Montage app.
 * @author Gregory Kogut
 * @author Andrew Ding
 * @author Tiffany Ko
 * @author Da Lu
 * @author Anthony Lee
 */
public class PhotoImpl extends MediaImpl implements Photo {
    /**
     * Creates a Photo object
     */
	
	/**The representation of this type of media.*/
	private byte[] photo;
	
	
	public PhotoImpl (Coordinates location,byte[] photo) {
		super(location);
		this.photo = photo;
	}
	
	/**
	 * Default constructor for kryonet.
	 */
	public PhotoImpl() {
		
	}

	@Override
	public String toString()  {
		return "photo";
	}

	public byte[] getPhoto() {
		return this.photo;
	}

}
