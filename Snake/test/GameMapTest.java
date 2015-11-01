import static org.junit.Assert.*;

import java.io.File;
import java.io.FileOutputStream;

import org.junit.Before;
import org.junit.Test;

public class GameMapTest {

	private static final int STANDARD_WIDTH = 60;
	private static final int STANDARD_HEIGHT = 20;
	public static GameMap map;
	
	
	@Before
	public void setUp(){
		map = new GameMap(STANDARD_HEIGHT,STANDARD_WIDTH);
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

		//act
		char[][] rep = map.getRepresentation();
		//assert
		assertEqualArray(GameMap.createEmptyGameMapRepresentation(STANDARD_HEIGHT,STANDARD_WIDTH), rep);
	}
	
	@Test
	public void testThatGameMapRecognizesPlayerPosition() throws Exception {
		//arrange

		//act
		map.setPlayerPosition(5,5);
		char[][] rep = map.getRepresentation();
		//assert
		assertEquals('&', rep[5][5]);
	}
	
	@Test
	public void testPrintGameMap() throws Exception {
		//arrange
		File testOutputFile = new File("testOutput.txt");
		map.setPlayerPosition(5,5);
		//act
		map.printGameMap(new FileOutputStream(testOutputFile));
		//assert
		String expectedFileContent = FileUtil.readFile("expectedOutput.txt");
		String actualFileContent = FileUtil.readFile(testOutputFile);
		assertEquals(expectedFileContent, actualFileContent);
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



}
