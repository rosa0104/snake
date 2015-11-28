import static org.junit.Assert.*;

import org.junit.Test;

public class WallTest {

	@Test
	public void testThatWallEqualsOtherWall() {
		assertTrue(Wall.create(1,1).equals(Wall.create (1,1)));
	}
	
	@Test
	public void testThatWallDoesNotEqualOtherWall() {
		assertFalse(Wall.create(1,1).equals(Wall.create(0,0)));
	}

	@Test
	public void testThatWallIsIdenticalToAnOtherWall() {
		assertTrue(Wall.create(1,1)==Wall.create(1,1));
	}
}
