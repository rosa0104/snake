import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class Wall extends GameToken{

	private static final char WALL_ICON = 'X';
	private static Map<Point, Wall> walls = new HashMap<>();

	private Wall(int i, int j) {
		super(i, j);
	}

	@Override
	protected char getIcon() {
		return WALL_ICON;
	}
	

	public boolean equals(Wall otherWall){
		if (otherWall.positions.equals(this.positions))	{
			return true;
		}else{
			return false;
		}
	}

	public static Wall create(int i, int j) {
		Point p = new Point(i,j);
		if (walls.containsKey(p)){
			return walls.get(p);
		}else {
			Wall w = new Wall (i,j);
			walls .put(p, w);
			return  w;
		}
	}

}
