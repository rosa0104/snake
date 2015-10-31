import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class PointTest {
@Test
public void testPointEquals() throws Exception {
	//arrange
	Point a = new Point(9,7);
	Gold b = new Gold(9,7);
	
	//act
	boolean result = b.getPositions().contains(a);
	
	//assert
	assertTrue(result);
	
	
}
}
