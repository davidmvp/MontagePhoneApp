package edu.jhu.cs.oose.montage.server;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.jhu.cs.oose.montage.model.hibernate.CoordinatesHib;
import edu.jhu.cs.oose.montage.model.hibernate.GridSquareHib;
import edu.jhu.cs.oose.montage.model.hibernate.media.MediaHib;
import edu.jhu.cs.oose.montage.model.hibernate.media.TextPostHib;
import edu.jhu.cs.oose.montage.model.iface.Coordinates;
import edu.jhu.cs.oose.montage.model.iface.GridSquare;
import edu.jhu.cs.oose.montage.model.iface.Newsfeed;
import edu.jhu.cs.oose.montage.model.iface.media.Media;
import edu.jhu.cs.oose.montage.model.impl.CoordinatesImpl;
import edu.jhu.cs.oose.montage.model.impl.GridSquareImpl;
import edu.jhu.cs.oose.montage.model.impl.NewsfeedImpl;
import edu.jhu.cs.oose.montage.model.impl.media.PhotoImpl;
import edu.jhu.cs.oose.montage.model.impl.media.TextPostImpl;

/**
 * Server class for Montage app.
 * @author Gregory Kogut
 * @author Andrew Ding
 * @author Tiffany Ko
 * @author Da Lu
 * @author Anthony Lee
 */
public class MontageServer {

	/**All grid square that this server is in charge of maintaining.*/
    private ArrayList<GridSquareImpl> allSpaces;
    /**All the UIDs this server knows about.*/
    private Set<String> userIDs;
    
    private boolean isPersistent;
    private DatabaseManager database;
    
    /**The GPS latitude start of our collection of gridsquares.*/
    private final double LATITUDE_START = 39.28;
    /**The GPS longitude start of our collection of gridsquares.*/
    private final double LONGITUDE_START = -76.65;

    /**
     * Creates a new Server object.
     */
    public MontageServer(boolean persistence) {
    	this.allSpaces = new ArrayList<GridSquareImpl>();
    	this.userIDs = new HashSet<String>();
    	
    	this.isPersistent = persistence;
    	
    	if (this.isPersistent) {
    		this.database = new DatabaseManager();
    	}
    	this.setUpGridSquares();
    }
    
    /**
     * Sets up our collection of gridsquares.
     */
    private void setUpGridSquares() {
    	for (int x = 0; x < 7; x++) {
    		for (int y = 0; y < 7; y++) {
    			Coordinates upperLeft = new CoordinatesImpl(LATITUDE_START + (0.01 * x),
    				LONGITUDE_START + (0.01*y));
    			Coordinates upperRight = new CoordinatesImpl(LATITUDE_START + (0.01 * (x+1)),
        			LONGITUDE_START + (0.01*y));
    			Coordinates lowerLeft = new CoordinatesImpl(LATITUDE_START + (0.01 * x),
    				LONGITUDE_START + (0.01 * (y+1)));
    			Coordinates lowerRight = new CoordinatesImpl(LATITUDE_START + (0.01 * (x+1)),
    				LONGITUDE_START + (0.01 * (y+1)));
    			Coordinates upperLeft1 = new CoordinatesHib(LATITUDE_START + (0.01 * x),
        				LONGITUDE_START + (0.01*y));
        			Coordinates upperRight1 = new CoordinatesHib(LATITUDE_START + (0.01 * (x+1)),
            			LONGITUDE_START + (0.01*y));
        			Coordinates lowerLeft1 = new CoordinatesHib(LATITUDE_START + (0.01 * x),
        				LONGITUDE_START + (0.01 * (y+1)));
        			Coordinates lowerRight1 = new CoordinatesHib(LATITUDE_START + (0.01 * (x+1)),
        				LONGITUDE_START + (0.01 * (y+1)));
        		database.updateCoordinate(upperLeft1);
        		database.updateCoordinate(upperRight1);
        		database.updateCoordinate(lowerLeft1);
        		database.updateCoordinate(lowerRight1);
    			GridSquareImpl square = new GridSquareImpl(upperLeft, upperRight,
        				lowerRight, lowerLeft);
    			GridSquareHib sq = new GridSquareHib(upperLeft1, upperRight1,
        				lowerRight1, lowerLeft1);
    			
    			this.allSpaces.add(square);
    			database.updateGridSquare(sq);
    		}
    	}
    }
    
    /**
     * Adds a UID to this server.
     * @param uid id of the user
     */
    public void addUser(String uid) {
    	if (this.userIDs.add(uid) && this.isPersistent) {
    		this.database.addUser(uid);
    	}
    }

    /**
     * Returns a Newsfeed.
     * @param latitude latitude of the coordinate
     * @param longitude longitude of the coordinate
     * @param sort The type of sorting for the Newsfeed.
     * @return The Newsfeed object.
     */
    public Newsfeed getNewsFeed(double latitude, double longitude, int sort) {
    	GridSquare square = this.findGridSquare(latitude, longitude);
    	Newsfeed ret = new NewsfeedImpl(0);
    	
    	if (square != null) {
    		Collection<Media> allMedia = square.getMedia();
        	
        	for (Media media : allMedia) {
        		ret.addToNewsfeed(media);
        	}	
    	}
    	
        return ret;
    }

    /**
     * Stores a media object in a given location.
     * @param media The media object to be stored.
     */
    public void storeMedia(Media media) {
    	/*
    	 * Find which GridSquare l goes in
    	 * do square.addMedia(media)
    	 */
    	
    	GridSquare square = findGridSquare(media);
    	if (square != null) {
    		square.addMedia(media);
    		
    		//TODO
    		if (media instanceof TextPostImpl && this.isPersistent) {
    			TextPostImpl t = (TextPostImpl) media;
    			this.database.addTextPost(t);

    		}
    		if (media instanceof PhotoImpl && this.isPersistent) {
    			PhotoImpl p =  (PhotoImpl) media;
    			this.database.addPhotoPost(p);
    			
    			

    		}

    	}
    	
    }

    /**
     * Updates the media object's fields.
     * @param media The media object to be updated.
     */
    public void updateMedia(Media media) {
    	/*
    	 * Find where media is and give it to GridSquare
    	 */
    	GridSquare square = findGridSquare(media);
    	
    	if (square != null) {
    		square.updateMedia(media);
    	}

    }
    
    /**
     * Find which grid square a certain piece of media belongs to.
     * @param m media to check
     * @return the gridsquare the media belongs to
     */
    private GridSquare findGridSquare(Media m) {

    	for (GridSquare square : this.allSpaces) {
    		if (square.belongsHere(m)) {
    			return square;
    		}
    	}
    	
    	return null;
    }
    
    /**
     * Finds which grid square a pair of coordinates belongs to.
     * @param lat latidue of the coordinate
     * @param longit longitude of the coordinate
     * @return the gridsquare the media belongs to
     */
    private GridSquare findGridSquare(double lat, double longit) {
    	for (GridSquare square : this.allSpaces) {
    		if (square.belongsHere(lat, longit)) {
    			return square;
    		}
    	}
    	
    	return null;
    }

    /**
     * Login to our app.
     * @param uid UID to check
     * @return true if we are allowing this user to login.
     */
	public boolean login(String uid) {
		//TODO check for bogus UIDs
		return this.userIDs.add(uid);
	}
    
}
