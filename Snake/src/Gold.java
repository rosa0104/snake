import java.awt.Point;

public class Gold extends GameToken {

	public static final char GOLD_ICON = '$';
	public boolean gefunden;

	public Gold(int i, int j) {
		super(i,j);
		gefunden = false;
	}


	public void setPositions(int i, int j) {
		this.positions.set(0, new Point(i,j));
	}

	@Override
	protected char getIcon() {
		return GOLD_ICON;
	}

}
