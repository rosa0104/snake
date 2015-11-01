import java.awt.Point;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

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

	public void printGameMap(FileOutputStream fileOutputStream) throws IOException {
		PrintWriter write = new PrintWriter(fileOutputStream);
		char[][] content = getRepresentation();
		for(int i = 0; i< content.length; i++){

			write.println(content[i]);
		}
		write.flush();
	}
}
