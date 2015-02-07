package edu.jhu.cs.oose.montage.client.kryonet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

//import javax.media.jai.CoordinateImage;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;

import edu.jhu.cs.oose.montage.kryonet.request.LoginRequest;
import edu.jhu.cs.oose.montage.kryonet.request.NewsfeedRequest;
import edu.jhu.cs.oose.montage.kryonet.request.StoreMedia;
import edu.jhu.cs.oose.montage.kryonet.request.UpdateMedia;
import edu.jhu.cs.oose.montage.kryonet.response.LoginResponse;
import edu.jhu.cs.oose.montage.model.iface.User;
import edu.jhu.cs.oose.montage.model.iface.media.Media;
import edu.jhu.cs.oose.montage.model.impl.CoordinatesImpl;
import edu.jhu.cs.oose.montage.model.impl.NewsfeedImpl;
import edu.jhu.cs.oose.montage.model.impl.UserImpl;
import edu.jhu.cs.oose.montage.model.impl.media.MediaImpl;
import edu.jhu.cs.oose.montage.model.impl.media.PhotoImpl;
import edu.jhu.cs.oose.montage.model.impl.media.TextPostImpl;

/**
 * A top level class for a montage client.
 * @author Greg Kogut
 *
 */
public class KryoClient {
	/**The underlying kryonet client.*/
	private Client client;
	private static int tcpPort = 20000;
	private static String host;// = "localhost";
	/**Handles the networking stuff.*/
	private ClientListener listener;
	/**Underlying user from our model.*/
	private User user;

	/**
	 * KryoClient constructor.
	 * @param hostName computer to connect to.
	 * @throws IOException throws ioexception
	 */
	public KryoClient(String hostName) throws IOException {
		this.client = new Client(10000000, 5000000);
		host = hostName;
		registerPackets();
		
		this.user = new UserImpl();
		
		this.listener = new ClientListener(this.user);
		
		client.addListener(this.listener);
		
		//client.setTimeout(0);
		//client.setKeepAliveTCP(1000);
		
		//new Thread(client).start();
		client.start();
		
		client.connect(5000, host, tcpPort);

	}
	
	/**
	 * Register different types of packets we expect to receive.
	 */
	private void registerPackets() {
		Kryo kryo = this.client.getKryo();
		
		kryo.register(NewsfeedImpl.class);
		kryo.register(ArrayList.class);
		kryo.register(MediaImpl.class);
		kryo.register(TextPostImpl.class);
		kryo.register(PhotoImpl.class);
		kryo.register(byte[].class);
		kryo.register(GregorianCalendar.class);
		
		kryo.register(CoordinatesImpl.class);
		
		kryo.register(LoginRequest.class);
		kryo.register(NewsfeedRequest.class);
		kryo.register(StoreMedia.class);
		kryo.register(UpdateMedia.class);
		
		kryo.register(LoginResponse.class);
	}
	
	/**
	 * Get the underlying kryonet client.
	 * @return
	 */
	public Client getClient() {
		return this.client;
	}
	
	/**
	 * Stop the kryonet client.
	 */
	public void stop() {
		this.client.stop();
	}
	
	/**
	 * Get the user from our model.
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	
	/**
	 * Checks to see if the user is logged into the server.
	 * @return true if logged in, false if not
	 */
	public boolean isLoggedIn() {
		return this.listener.isLoggedIn();
	}
	
	/**
	 * Sends a newsfeed request to the server
	 */
	public void askForNewsfeed() {
		this.listener.askForNewsfeed(this.client);
	}
	
	/**
	 * Updates a particular media with an upvote, downvote, etc.
	 * @param m media to update
	 */
	public void updateMedia(Media m) {
		this.listener.pushUpdatedMediaRequest(this.client, m);
	}
	
	/**
	 * Store a newly generated piece of media on the server.
	 * @param m media to store
	 */
	public void storeMedia(Media m) {
		this.listener.pushStoreMediaRequest(this.client, m);
	}
	
	/*public static void main(String[] args) throws IOException, InterruptedException {
				
		System.out.println("The client program is now waiting for a packet...");
		
		KryoClient myClient = new KryoClient("localhost");
		
		ClientThread thread = new ClientThread(myClient);
		thread.start();
		
		//myClient.askForNewsfeed();
		myClient.storeMedia(new TextPostImpl("text", new CoordinatesImpl(39.33, -76.61)));
		//myClient.askForNewsfeed();
	}*/
	
}
