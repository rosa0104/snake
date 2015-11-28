import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

public class WallFactory {

	public Set<Wall> createWalls(Point point, Point point2) {
		int fromX=(int) Math.min(point.getX(), point2.getX());
		int toX=(int) Math.max(point.getX(), point2.getX());
		int fromY=(int) Math.min(point.getY(), point2.getY());
		int toY=(int) Math.max(point.getY(), point2.getY());
		Set<Wall> walls = new HashSet<Wall>();
		for(int i = fromX; i<= toX;i++){
			for (int j = fromY; j<= toY;j++){				
				Wall wall1 = Wall.create(i, j);
				walls.add(wall1);
			}
		}

		return walls;
	}

}
