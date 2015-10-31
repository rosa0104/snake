import java.awt.Point;

public class GameMap {

	private int height;
	private int width;
	private Point playerPosition;

	public GameMap(int height, int width) {
		this.height = height;
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public char[][] getRepresentation() {
		char[][] rep = createEmptyGameMapRepresentation(height, width);
		if (playerPosition != null) {
			rep[playerPosition.x][playerPosition.y] = '&';
		}
		return rep;

	}
	
	public static char[][] createEmptyGameMapRepresentation(int height, int width) {
		char [][] newArray = new char[height][width];
		for(int i = 0; i< height; i++){
			for(int j = 0; j< width; j++){
				newArray[i][j] = '.';
			}
		}
 		return newArray;
	}

	public void setPlayerPosition(int i, int j) {
		this.playerPosition = new Point(i,j);
	}
}
