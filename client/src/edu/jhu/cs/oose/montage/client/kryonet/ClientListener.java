package edu.jhu.cs.oose.montage.client.kryonet;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import edu.jhu.cs.oose.montage.kryonet.request.LoginRequest;
import edu.jhu.cs.oose.montage.kryonet.request.NewsfeedRequest;
import edu.jhu.cs.oose.montage.kryonet.request.StoreMedia;
import edu.jhu.cs.oose.montage.kryonet.request.UpdateMedia;
import edu.jhu.cs.oose.montage.kryonet.response.LoginResponse;
import edu.jhu.cs.oose.montage.model.iface.Newsfeed;
import edu.jhu.cs.oose.montage.model.iface.User;
import edu.jhu.cs.oose.montage.model.iface.media.Media;
import edu.jhu.cs.oose.montage.model.impl.NewsfeedImpl;

/**
 * Networking backend for a KryoClient.
 * @author Greg Kogut
 *
 */
public class ClientListener extends Listener {
	
	/**User object from our model.*/
	private User user;
	private boolean loggedIn;
	
	/**
	 * ClientListener Constructor.
	 * @param u user that this listener is responsible for
	 */
	public ClientListener(User u) {
		this.user = u;
		this.loggedIn = false;
	}
	
	@Override
	public void connected(Connection c) {
		System.out.println("Connected to a server");
		c.sendTCP(new LoginRequest(this.user.getUId()));
	}

	@Override
	public void disconnected(Connection c) {
		System.out.println("Disconnected from a server...");
		System.exit(1);
	}

	@Override
	public void received(Connection c, Object o) {
		if (o instanceof LoginResponse) {
			LoginResponse response = (LoginResponse) o;
			
			if (response.isSuccessfulLogin()) {
				System.out.println("User " + this.user.getUId()
						+ " successfully logged in");
				this.loggedIn = true;
				askForNewsfeed(c);
				
			} else {
				System.out.println("Invalid user ID " + this.user.getUId());
				System.exit(1);
			}
		} else if (o instanceof NewsfeedImpl) {
			Newsfeed feed = (Newsfeed) o;
			
			this.user.setNewsfeed(feed);
			
			System.out.println("Received a newsfeed from the server: " + feed.toString());			
		}
		
	}
	
	/**
	 * Request a newsfeed from the server.
	 * @param c connection to the server
	 */
	public void askForNewsfeed(Connection c) {
		c.sendTCP(new NewsfeedRequest(this.user.getLatitude(),
				this.user.getLongitude(), 0));
	}
	
	/**
	 * Request to update a piece of media.
	 * @param c connection to the server
	 * @param m media to push
	 */
	public void pushUpdatedMediaRequest(Connection c, Media m) {
		c.sendTCP(new UpdateMedia(m));
	}
	
	/**
	 * Request to store a piece of media.
	 * @param c connection to the server
	 * @param m media to store
	 */
	public void pushStoreMediaRequest(Connection c, Media m) {
		c.sendTCP(new StoreMedia(m));
	}
	
	/**
	 * Checks to see if we are logged in.
	 * @return true if we are logged in, false otherwise
	 */
	public boolean isLoggedIn() {
		return loggedIn;
	}

}
