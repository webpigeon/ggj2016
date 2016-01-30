package uk.me.webpigeon.jams.jam2016.model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import uk.me.webpigeon.jams.jam2016.model.entities.AICar;
import uk.me.webpigeon.jams.jam2016.model.entities.Entity;

public class GridWorld{
	private Dimension size;
	private int[][] grid;
	private Point player;
	
	private List<Entity> entities = new ArrayList<Entity>();
	
	private Color[] types = {
			Color.GREEN,
			Color.BLACK
	};
	
	public GridWorld(int width, int height) {
		this.size = new Dimension(width, height);
		this.grid = new int[width][height];
		this.player = new Point(0,0);
		this.entities = new ArrayList<Entity>();
	}
	
	public void addEntity(Entity entity) {
		entities.add(entity);
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
		for (int x=0; x<size.width; x++) {
			for (int y=0; y<size.height; y++) {
				int type = grid[x][y];
				
				g.setColor(types[type]);
				g.fillRect(x*32, y*32, 32, 32);
			}
		}
		
		for(Entity entity : entities){
			entity.draw(g);
		}
	}
	
	public boolean isRoadType(int x, int y){
		return getTileType(x, y) == 1;
	}

	public void update() {
		for(Entity entity : entities){
			entity.update(this);
		}	
	}
	
	public void initialiseAICars(){
		for(int x = 0; x < size.width; x++){
			for(int y = 0; y < size.height; y++){
				if(isRoadType(x, y)){
					if(Math.random() > 0.75){
						// TODO Add aicar
						addEntity(new AICar(new Vector2D(x, y)));
					}
				}
			}
		}
	}

}
