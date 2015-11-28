import java.awt.Point;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameMap {

	private static final char EMPTY_FIELD = '.';
	private int height;
	private int width;
	private Point playerPosition;
	private Set<Gold> allGolds;
	private Set<Snake> allSnakes;
	private Set<Wall> allWalls;
	private Point doorPosition;

	public GameMap(int width, int height) {
		this.height = height;
		this.width = width;
		this.allGolds = new HashSet<Gold>();
		this.allSnakes = new HashSet<Snake>();
		this.allWalls = new HashSet<Wall>();
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public char[][] getRepresentation() {
		char[][] rep = createEmptyGameMapRepresentation(width,height);
		if (playerPosition != null) {
			rep[playerPosition.x][playerPosition.y] = '&';
		}
		if (doorPosition != null) {
			rep[doorPosition.x][doorPosition.y] = '#';
		}
		for (GameToken t: this.getTokens()){
			t.render(rep);
		}

		return rep;

	}
	
	public static char[][] createEmptyGameMapRepresentation(int width, int height) {
		char [][] newArray = new char[width][height];
		for(int x = 0; x< width; x++){
			for(int y = 0; y< height; y++){
				newArray[x][y] = EMPTY_FIELD;
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
	public void printGameMap(OutputStream fileOutputStream) throws IOException {
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

	public void addWalls(Set<Wall> allWalls) {
		this.allWalls.addAll(allWalls);
	}
	
	public Set<Snake>  getSnakes() {
		return allSnakes;
	}

	public Set<Gold> getGolds() {
		return allGolds;
	}

	public Point getPlayerPosition() {
		return playerPosition;
	}

	public Point getDoorPosition() {
		return doorPosition;
	}
	
	public Set<GameToken> getTokens() {
		Set<GameToken> allTokens = new HashSet <GameToken>();
		allTokens.addAll(allGolds);
		allTokens.addAll(allSnakes);
		allTokens.addAll(allWalls);
		return allTokens;
	}


}
