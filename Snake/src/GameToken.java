import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

public abstract class GameToken {

	protected List<Point> positions;

	public GameToken(int i, int j) {
		this.positions = new LinkedList<Point>();
		positions.add(0, new Point (i,j));
	}

	public List<Point> getPositions() {
		return positions;
	}

	public void render(char[][] rep) {
		for(Point p: positions){
			rep[p.x][p.y] = getIcon();
		}
		
	}

	protected abstract char getIcon();
	
}
