package uk.me.webpigeon.jams.jam2016.model;

public class Vector2D {
	private final int x, y;
	
	public static final Vector2D LEFT = new Vector2D(-1, 0);
	public static final Vector2D RIGHT = new Vector2D(1, 0);
	public static final Vector2D UP = new Vector2D(0, -1);
	public static final Vector2D DOWN = new Vector2D(0, 1);
	
	public Vector2D(){
		this.x = 0;
		this.y = 0;
	}
	
	public Vector2D(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public Vector2D add(Vector2D other){
		return new Vector2D(this.x + other.x, this.y + other.y);
	}
	
	public Vector2D subtract(Vector2D other){
		return new Vector2D(this.x - other.x, this.y - other.y);
	}
	
	public Vector2D multiply(double fac){
		return new Vector2D((int)(this.x * fac), (int)(this.y * fac));
	}
	
	public double distanceBetween(Vector2D other){
		return Math.hypot(x - other.x, y - other.y);
	}

}
