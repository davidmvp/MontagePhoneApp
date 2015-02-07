package edu.jhu.cs.oose.montage.model.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.jhu.cs.oose.montage.model.abs.GridSquareAbs;
import edu.jhu.cs.oose.montage.model.iface.Coordinates;
import edu.jhu.cs.oose.montage.model.iface.GridSquare;
import edu.jhu.cs.oose.montage.model.iface.media.Media;

/**
 * GridSquare class for Montage app. A basic unit for our storage on the montage server.
 * A server will have many grid squares and a grid square will contain media among other
 * things.
 * 
 * @author Gregory Kogut
 * @author Andrew Ding
 * @author Tiffany Ko
 * @author Da Lu
 * @author Anthony Lee
 */
public class GridSquareImpl extends GridSquareAbs implements Serializable, GridSquare{

	private static final long serialVersionUID = 1L;

	/**All the media in this grid square*/
    private List<Media> allMedia;
    
    /**A boundary of this square*/
    private Coordinates upperLeft;
    /**A boundary of this square*/
    private Coordinates upperRight;
    /**A boundary of this square*/
    private Coordinates lowerLeft;
    /**A boundary of this square*/
    private Coordinates lowerRight;
    /** ID of this object*/
	private int id;
    
    public GridSquareImpl(Coordinates upLeft,
			Coordinates upRight, Coordinates lowLeft, Coordinates lowRight) {
		super();
		this.upperLeft = upLeft;
		this.upperRight = upRight;
		this.lowerLeft = lowLeft;
		this.lowerRight = lowRight;
		
		allMedia = new ArrayList<Media>();
	}
    
    /* (non-Javadoc)
	 * @see edu.jhu.cs.oose.montage.model.GridSquare#getUpperLeft()
	 */
    @Override
	public Coordinates getUpperLeft() {
		return upperLeft;
	}


    /* (non-Javadoc)
	 * @see edu.jhu.cs.oose.montage.model.GridSquare#getUpperRight()
	 */
	@Override
	public Coordinates getUpperRight() {
		return upperRight;
	}


	/* (non-Javadoc)
	 * @see edu.jhu.cs.oose.montage.model.GridSquare#getLowerLeft()
	 */
	@Override
	public Coordinates getLowerLeft() {
		return lowerLeft;
	}


	/* (non-Javadoc)
	 * @see edu.jhu.cs.oose.montage.model.GridSquare#getLowerRight()
	 */
	@Override
	public Coordinates getLowerRight() {
		return lowerRight;
	}

	/* (non-Javadoc)
	 * @see edu.jhu.cs.oose.montage.model.GridSquare#getMedia()
	 */
	@Override
	public List<Media> getMedia() {
    	return this.allMedia;
    }


	/* (non-Javadoc)
	 * @see edu.jhu.cs.oose.montage.model.GridSquare#toString()
	 */
	
	@Override
	public String toString() {
		return "GridSquare [upperLeft=" + upperLeft + ", upperRight="
				+ upperRight + ", lowerLeft=" + lowerLeft + ", lowerRight="
				+ lowerRight + "]";
	}

	@Override
	public int getID() {
		
		return id;
	}

	
	
}
