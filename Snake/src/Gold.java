import java.awt.Point;

public class Gold extends Item {

	public boolean gefunden;

	public Gold(int i, int j) {
		super(i,j);
		gefunden = false;
	}


	public void setPosition(int i, int j) {
		this.position = new Point(i,j);
	}

}
