import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

public class Item {

	protected List<Point> positions;

	public Item(int i, int j) {
		this.positions = new LinkedList<Point>();
		positions.add(0, new Point (i,j));
	}

	public List<Point> getPositions() {
		return positions;
	}
	
}
