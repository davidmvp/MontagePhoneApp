package edu.jhu.cs.oose.montage.server.kryonet;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import edu.jhu.cs.oose.montage.kryonet.request.LoginRequest;
import edu.jhu.cs.oose.montage.kryonet.request.NewsfeedRequest;
import edu.jhu.cs.oose.montage.kryonet.request.StoreMedia;
import edu.jhu.cs.oose.montage.kryonet.request.UpdateMedia;
import edu.jhu.cs.oose.montage.kryonet.response.LoginResponse;
import edu.jhu.cs.oose.montage.model.iface.Newsfeed;
import edu.jhu.cs.oose.montage.server.MontageServer;

/**
 * Network listener for a KryoServer
 * @author Greg Kout
 *
 */
public class ServerListener extends Listener {
	
	/**The underlying MontageServer that we relay requests to.*/
	private MontageServer server;
	
	/**
	 * ServerListener Constructor.
	 * @param server server we store data on
	 */
	public ServerListener(MontageServer server) {
		super();
		this.server = server;
	}

	@Override
	public void connected(Connection c) {
		System.out.println("A user has connected!");
		c.sendTCP(new String("You have logged in!"));
	}

	@Override
	public void disconnected(Connection c) {
		System.out.println("Server: A client disconnected");
	}

	@Override
 	public void received(Connection c, Object o) {
		if (o instanceof LoginRequest) {
			System.out.println("Received a request to login...");
			LoginRequest request = (LoginRequest) o;
			boolean loggedIn = this.server.login(request.getUid());
			
			LoginResponse response = new LoginResponse(loggedIn);
			
			c.sendTCP(response);
		} else if (o instanceof NewsfeedRequest) {
			System.out.println("Received a request for a newsfeed...");
			NewsfeedRequest request = (NewsfeedRequest) o;
			
			Newsfeed feed = this.server.getNewsFeed(request.getLatitude(),
					request.getLongitude(), request.getSort());
			
			c.sendTCP(feed);
			
			System.out.println("Sending newsfeed...");
		} else if (o instanceof StoreMedia) {
			System.out.println("Received a request to store Media...");
			StoreMedia sm = (StoreMedia) o;
			this.server.storeMedia(sm.getMedia());
		} else if (o instanceof UpdateMedia) {
			UpdateMedia um = (UpdateMedia) o;
			this.server.updateMedia(um.getMedia());
		} else {
			System.out.println("Received: " + o.toString());
		}
	}
}
