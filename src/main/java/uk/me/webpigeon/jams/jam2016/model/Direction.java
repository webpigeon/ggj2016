package uk.me.webpigeon.jams.jam2016.model;

public enum Direction {
	NORTH(Vector2D.UP),
	SOUTH(Vector2D.DOWN),
	EAST(Vector2D.LEFT),
	WEST(Vector2D.RIGHT);

	private final Vector2D direction;
	
	private Direction(Vector2D d){
		this.direction = d;
	}
	
	public Vector2D getVector() {
		return direction;
	}
	
}
