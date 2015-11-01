import java.awt.Point;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameMap {

	private int height;
	private int width;
	private Point playerPosition;
	private Set<Gold> allGolds;
	private Set<Snake> allSnakes;
	private Point doorPosition;

	public GameMap(int height, int width) {
		this.height = height;
		this.width = width;
		this.allGolds = new HashSet<Gold>();
		this.allSnakes = new HashSet<Snake>();
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
		if (doorPosition != null) {
			rep[doorPosition.x][doorPosition.y] = '#';
		}
		for (Gold g: this.allGolds){
			List<Point>positions = g.getPositions();
			for(Point p: positions){
				rep[p.x][p.y] = '$';
			}
		}
		for (Snake s: this.allSnakes){
			List<Point>positions = s.getPositions();
			for(Point p: positions){
				rep[p.x][p.y] = 'S';
			}
		}
		return rep;

	}
	
	public static char[][] createEmptyGameMapRepresentation(int height, int width) {
		char [][] newArray = new char[width][height];
		for(int x = 0; x< width; x++){
			for(int y = 0; y< height; y++){
				newArray[x][y] = '.';
			}
		}
 		return newArray;
	}

	public void setPlayerPosition(int i, int j) {
		this.playerPosition = new Point(i,j);
	}

	public void setDoorPosition(int i, int j) {
		this.doorPosition = new Point(i,j);	
	}
	public void printGameMap(FileOutputStream fileOutputStream) throws IOException {
		PrintWriter write = new PrintWriter(fileOutputStream);
		char[][] content = getRepresentation();
		for(int y = 0; y< height; y++){
			for (int x = 0; x< width; x++){
				write.print(content[x][y]);
			}
			write.println();
		}
		write.flush();
	}

	public void addGolds(Set<Gold> allGolds) {
		this.allGolds.addAll(allGolds);
	}

	public void addSnakes(Set<Snake> allSnakes) {
		this.allSnakes.addAll(allSnakes);
	}

}
