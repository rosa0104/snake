import static org.junit.Assert.*;

import org.junit.Test;

public class GameMapTest {

	
	@Test
	public void testThatGameMapHasTheSetDimensions() throws Exception {
		//arrange
		GameMap map = new GameMap(30,20);
		
		//act
		int height = map.getHeight(); 
		int width = map.getWidth(); 
		
		//assert
		assertEquals(30, height);
		assertEquals(20, width);
	}
	
	
	@Test
	public void testThatEmptyGameMapIsArrayOfDots() throws Exception {
		//arrange
		GameMap map = new GameMap(30,20);
		//act
		char[][] rep = map.getRepresentation();
		//assert
		assertEqualArray(GameMap.createEmptyGameMapRepresentation(30,20), rep);
	}
	
	@Test
	public void testThatGameMapRecognizesPlayerPosition() throws Exception {
		//arrange
		GameMap map = new GameMap(30,20);
		//act
		map.setPlayerPosition(5,5);
		char[][] rep = map.getRepresentation();
		//assert
		assertEquals('&', rep[5][5]);
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
