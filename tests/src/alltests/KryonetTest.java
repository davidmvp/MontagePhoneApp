package alltests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import edu.jhu.cs.oose.montage.client.kryonet.ClientThread;
import edu.jhu.cs.oose.montage.client.kryonet.KryoClient;
import edu.jhu.cs.oose.montage.model.iface.Newsfeed;
import edu.jhu.cs.oose.montage.model.impl.UninitializedFieldException;
import edu.jhu.cs.oose.montage.server.kryonet.KryoServer;

/**
 * Basics tests for the interaction between KryoServer and KryoClient
 * @author Greg Kogut
 *
 */
public class KryonetTest {

	private KryoClient client;
	@SuppressWarnings("unused")
	private KryoServer server;
	
	@Before
	public void setUpKryonet() {
		try {
			this.server = new KryoServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.client = null;
		try {
			this.client = new KryoClient("localhost");
			ClientThread thread = new ClientThread();
			thread.start();
		} catch (IOException e) {
			System.err.println("Cannot connect to server");
		}
	}
	
	@Test
	public void testGetNewsfeed() {
		boolean receivedNewsfeed = false;
		
		while (!receivedNewsfeed) {
			try {
				Newsfeed feed = this.client.getUser().getNewsfeed();
				assertEquals(true, this.client.isLoggedIn());
				receivedNewsfeed = true;
			} catch (UninitializedFieldException u) {
			}
		}
	}
}
