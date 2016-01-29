package uk.me.webpigeon.jams.jam2016.model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;

public class GridWorld extends World {
	private Dimension size;
	private int[][] grid;
	private Point player;
	
	public GridWorld(int width, int height) {
		this.size = new Dimension(width, height);
		this.grid = new int[width][height];
		this.player = new Point(0,0);
	}

	public void setTileAt(int x, int y, int tid) {
		grid[x][y] = tid;
	}
	
	public void setPosition(int x, int y) {
		player.x = x;
		player.y = y;
	}

	public int getWidth() {
		return size.width;
	}

	public int getHeight() {
		return size.height;
	}

	public int getTileType(int x, int y) {
		return grid[x][y];
	}

	public void render(Graphics2D g) {
		g.setColor(Color.BLUE);
		g.fillRect(player.x*32+5, player.y*32, 32-10, 32);
		
	}

}
