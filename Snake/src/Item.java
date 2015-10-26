import java.awt.Point;

public class Item {

	protected Point position;

	public Item(int i, int j) {
		this.position = new Point (i,j);
	}

	public Point getPosition() {
		return position;
	}
	
}
