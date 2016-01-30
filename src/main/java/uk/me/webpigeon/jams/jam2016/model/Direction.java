package uk.me.webpigeon.jams.jam2016.model;

public enum Direction {
	NORTH(Vector2D.UP), EAST(Vector2D.RIGHT), SOUTH(Vector2D.DOWN), WEST(Vector2D.LEFT);

	private final Vector2D direction;

	private Direction(Vector2D d) {
		this.direction = d;
	}

	public Vector2D getVector() {
		return direction;
	}

	public Direction getLeftDirection() {
		return getRotation(1);
	}

	public Direction getBackDirection() {
		return getRotation(2);
	}

	public Direction getRightDirection() {
		return getRotation(3);
	}

	public Direction getRotation(int turns) {
		int n = Direction.values().length;
		return Direction.values()[(ordinal() - turns + n) % n];
	}

}
