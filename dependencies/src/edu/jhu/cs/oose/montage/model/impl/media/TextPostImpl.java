package edu.jhu.cs.oose.montage.model.impl.media;

import edu.jhu.cs.oose.montage.model.iface.Coordinates;
import edu.jhu.cs.oose.montage.model.iface.media.TextPost;

/**
 * TextPost class for Montage app.
 * @author Gregory Kogut
 * @author Andrew Ding
 * @author Tiffany Ko
 * @author Da Lu
 * @author Anthony Lee
 */
public class TextPostImpl extends MediaImpl implements TextPost {
    /**
     * Creates a TextPost object
     */
	
	/**The representation of this type of media.*/
	private String textPost;
	/** ID of this object*/
	
    public TextPostImpl(String text, Coordinates location) {
        super(location);
    	this.textPost = text;
    }

    public TextPostImpl() {
    	super(null);
    }

	@Override
	public String toString() {
		//return "TextPostImpl [textPost=" + textPost + "]";
		return this.textPost;
	}

	@Override
	public String getTextPost() {
		
		return this.textPost;
	}
	
}
