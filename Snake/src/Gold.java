import java.awt.Point;

public class Gold {

	private Point position;
	public boolean gefunden;

	public Gold(int i, int j) {
		this.position = new Point (i,j);
		gefunden = false;
	}

	public Point getPosition() {
		return this.position;
	}

	public void setPosition(int i, int j) {
		this.position = new Point(i,j);
	}

}
