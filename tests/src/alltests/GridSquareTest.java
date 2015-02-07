package alltests;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import edu.jhu.cs.oose.montage.model.iface.GridSquare;
import edu.jhu.cs.oose.montage.model.iface.media.Media;
import edu.jhu.cs.oose.montage.model.impl.CoordinatesImpl;
import edu.jhu.cs.oose.montage.model.impl.GridSquareImpl;
import edu.jhu.cs.oose.montage.model.impl.media.TextPostImpl;

/**
 * Basics tests for GridSquareImpl.
 * @author Greg Kogut
 *
 */
public class GridSquareTest {
	private GridSquare square;
	
	@Before
	public void setUpGridSquare() {
		this.square = new GridSquareImpl(new CoordinatesImpl(0, 0),
			new CoordinatesImpl(1, 0),
			new CoordinatesImpl(0, 1),
			new CoordinatesImpl(1, 1));
	}
	
	@Test
	public void testBelongsHere() {
		assertEquals(true, this.square.belongsHere(0.5, 0.5));
	}
	
	@Test
	public void testAddMedia() {
		this.square.addMedia(new TextPostImpl("First item", new CoordinatesImpl(0, 0)));
		
		//should not be added to newsfeed
		this.square.addMedia(new TextPostImpl("Second item", new CoordinatesImpl(-1, -1)));
		
		Collection<Media> media = this.square.getMedia();
		
		assertEquals(1, media.size());
		assertEquals("First item", media.iterator().next().toString());
	}
}
