package alltests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.jhu.cs.oose.montage.model.iface.Newsfeed;
import edu.jhu.cs.oose.montage.model.impl.CoordinatesImpl;
import edu.jhu.cs.oose.montage.model.impl.media.TextPostImpl;
import edu.jhu.cs.oose.montage.server.MontageServer;

/**
 * Tests the functionality of MontageServer.java
 * @author Greg Kogut
 *
 */
public class MontageServerTest {

	private MontageServer appServer;
	
	@Before
	public void setUpServer() {
		this.appServer = new MontageServer(false);
	}
	
	@Test
	public void testStoreAndRetrieve() {
		this.appServer.storeMedia(new TextPostImpl("A new text post",
			new CoordinatesImpl(39.33, -76.61)));
		
		Newsfeed news = this.appServer.getNewsFeed(39.33, -76.61, 0);
		
		TextPostImpl t = (TextPostImpl) news.getCurrentNewsFeed().get(0);
		
		assertEquals("A new text post", t.toString());
	}
}
