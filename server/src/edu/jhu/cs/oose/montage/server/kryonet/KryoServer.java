package edu.jhu.cs.oose.montage.server.kryonet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Server;

import edu.jhu.cs.oose.montage.kryonet.request.LoginRequest;
import edu.jhu.cs.oose.montage.kryonet.request.NewsfeedRequest;
import edu.jhu.cs.oose.montage.kryonet.request.StoreMedia;
import edu.jhu.cs.oose.montage.kryonet.request.UpdateMedia;
import edu.jhu.cs.oose.montage.kryonet.response.LoginResponse;
import edu.jhu.cs.oose.montage.model.impl.CoordinatesImpl;
import edu.jhu.cs.oose.montage.model.impl.NewsfeedImpl;
import edu.jhu.cs.oose.montage.model.impl.media.MediaImpl;
import edu.jhu.cs.oose.montage.model.impl.media.PhotoImpl;
import edu.jhu.cs.oose.montage.model.impl.media.TextPostImpl;
import edu.jhu.cs.oose.montage.server.MontageServer;

/**
 * A top level server class that uses kryonet as well as our model code.
 * @author Greg Kogut
 *
 */
public class KryoServer {
	/**Underlying kryonet server object.*/
	private Server server;
	/**Server from our model.*/
	private MontageServer appServer;
	private static int tcpPort = 20000;

	/**
	 * KryoServer Constructor
	 * @throws IOException throws IOException if we cannot bind to a port
	 */
	public KryoServer() throws IOException {
		server = new Server(20000000, 10000000);
		registerPackets();
		server.start();
		server.bind(tcpPort);
		this.appServer = new MontageServer(true);
		server.addListener(new ServerListener(this.appServer));
		
		System.out.println("Starting up server!");
	}
	
	/**
	 * Register packets we expect to deal with.
	 */
	private void registerPackets() {
		Kryo kryo = this.server.getKryo();
		
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
	 * Main method to run the kryoserver.
	 * @param args arguments
	 * @throws IOException if the server cannot bind to a port
	 */
	public static void main(String[] args) throws IOException {
		
		
		try {
			new KryoServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
