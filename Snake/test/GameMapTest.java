import static org.junit.Assert.*;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class GameMapTest {

	private static final int STANDARD_WIDTH = 60;
	private static final int STANDARD_HEIGHT = 20;
	public static GameMap map;
	
	
	@Before
	public void setUp(){
		map = new GameMap(STANDARD_WIDTH,STANDARD_HEIGHT);
		map.setPlayerPosition(5,5);		
		map.setDoorPosition(59,8);		
		Set<Gold> allGolds = initGold();
		map.addGolds(allGolds);
		Set<Snake> allSnakes = initSnake();
		map.addSnakes(allSnakes);
	}
	
	@Test
	public void testThatGameMapHasTheSetDimensions() throws Exception {
		//arrange

		//act
		int height = map.getHeight(); 
		int width = map.getWidth(); 
		
		//assert
		assertEquals(STANDARD_HEIGHT, height);
		assertEquals(STANDARD_WIDTH, width);
	}
	
	
	@Test
	public void testThatEmptyGameMapIsArrayOfDots() throws Exception {
		//arrange
		map = new GameMap(STANDARD_WIDTH,STANDARD_HEIGHT);
		//act
		char[][] rep = map.getRepresentation();
		//assert
		assertEqualArray(GameMap.createEmptyGameMapRepresentation(STANDARD_WIDTH,STANDARD_HEIGHT), rep);
	}
	
	@Test
	public void testThatGameMapRecognizesPlayerPosition() throws Exception {
		//arrange

		//act
		char[][] rep = map.getRepresentation();
		//assert
		assertEquals('&', rep[5][5]);
	}
	
	@Test
	public void testThatGameMapRecognizesDoorPosition() throws Exception {
		//arrange
		
		//act
		char[][] rep = map.getRepresentation();
		//assert
		assertEquals('#', rep[59][8]);
	}
	
	@Test
	public void testPrintGameMap() throws Exception {
		//arrange
		File testOutputFile = new File("testOutput.txt");
		
		//act
		map.printGameMap(new FileOutputStream(testOutputFile));
		//assert
		String expectedFileContent = FileUtil.readFile("expectedOutput.txt");
		String actualFileContent = FileUtil.readFile(testOutputFile);
		assertEquals(expectedFileContent, actualFileContent);
	}
	
	@Test
	public void testThatGameMapRecognizesGoldPositions() throws Exception {
		//arrange

		//act

		//assert
		assertEquals('$', map.getRepresentation()[6][6]);
	}
	
	@Test
	public void testThatGameMapRecognizesSnakePositions() throws Exception {
		//arrange
		
		//act
		
		//assert
		assertEquals('S', map.getRepresentation()[15][6]);
	}


	private static void assertEqualArray(char[][] firstArray, char[][] secondArray) {
		assertEquals(firstArray.length, secondArray.length);
		assertEquals(firstArray[0].length, secondArray[0].length);
		
		for(int i = 0; i< firstArray.length; i++){
			for(int j = 0; j< firstArray[0].length; j++){
				if (firstArray[i][j] != secondArray[i][j]){
					fail();
				};
			}
		}
	}

	private HashSet<Gold> initGold() {
		HashSet<Gold> newSet = new HashSet<Gold>();
		Gold gold1 = new Gold(6,6);
		newSet.add(gold1);
		Gold gold2 = new Gold(7,7);
		newSet.add(gold2);
		Gold gold3 = new Gold(9,7);
		newSet.add(gold3);
		return newSet;
	}

	private Set<Snake> initSnake() {
		HashSet<Snake> newSet = new HashSet<Snake>();
		Snake snake1 = new Snake(15,6);
		newSet.add(snake1);
		Snake snake2 = new Snake(19,1);
		newSet.add(snake2);
		return newSet;
	}
}
