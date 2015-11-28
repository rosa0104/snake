import static org.junit.Assert.*;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class WallFactoryTest {
@Test
public void testThatWallfactoryProducesLinesOfWalls() throws Exception {
	//arrange
	Set<Wall> expectedWalls = new HashSet<Wall>();
	Wall wall1 = Wall.create(13,0);
	expectedWalls.add(wall1);
	Wall wall2 = Wall.create(13,1);
	expectedWalls.add(wall2);
	Wall wall3 = Wall.create(13,2);
	expectedWalls.add(wall3);
	
	//act
	Set<Wall> resultSet = new WallFactory().createWalls(new Point(13,0), new Point(13,2));

	//assert
	assertTrue(expectedWalls.equals(resultSet)); 
}
@Test
public void testThatWallfactoryProducesLinesOfWallsFromHigherToLowerCoordinates() throws Exception {
	//arrange
	Set<Wall> expectedWalls = new HashSet<Wall>();
	Wall wall1 = Wall.create(13,0);
	expectedWalls.add(wall1);
	Wall wall2 = Wall.create(13,1);
	expectedWalls.add(wall2);
	Wall wall3 = Wall.create(13,2);
	expectedWalls.add(wall3);

	
	//act
	Set<Wall> resultSet = new WallFactory().createWalls(new Point(13,2), new Point(13,0));
	
	//assert
	assertTrue(expectedWalls.equals(resultSet)); 
}
}
