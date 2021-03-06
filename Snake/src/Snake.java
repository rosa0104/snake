import java.awt.Point;

public class Snake extends GameToken {
	
	private static final int SNAKE_STANDARD_SIZE = 3;
	public static final char SNAKE_ICON = 'S';
	private int length;

	public Snake(int i, int j) {
		super(i,j);
		length = SNAKE_STANDARD_SIZE;
	}

	public void moveTowards(Point playerPosition) {
		if (playerPosition.x < getHeadPosition().x){
			move(new Point(getHeadPosition().x + -1, getHeadPosition().y));
		} else if (playerPosition.x > getHeadPosition().x) {
			move(new Point(getHeadPosition().x + 1, getHeadPosition().y));
		}

		if (playerPosition.y < getHeadPosition().y){
			move(new Point(getHeadPosition().x, getHeadPosition().y -1));
		} else if (playerPosition.y > getHeadPosition().y) {
			move(new Point(getHeadPosition().x, getHeadPosition().y +1));
		}
	}

	private void move(Point nextHeadPos) {
		Point nextHeadPosition = nextHeadPos;
		this.positions.add(0,nextHeadPosition);
		if (this.positions.size() > length){
			this.positions.remove(this.positions.size() -1);
		}
	}

	private Point getHeadPosition() {
		return getPositions().get(0);
	}

	public void shrink() {
		if (length > 1) {
			this.length--;
		}
	}

	public void grow() {
		if (length < 15) {
			this.length++;
		}
	}

	@Override
	protected char getIcon() {
		return SNAKE_ICON;
	}



}
