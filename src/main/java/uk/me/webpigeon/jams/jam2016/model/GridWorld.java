package uk.me.webpigeon.jams.jam2016.model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import uk.me.webpigeon.jams.jam2016.model.entities.AICar;
import uk.me.webpigeon.jams.jam2016.model.entities.Entity;

public class GridWorld{
	private Dimension size;
	private int[][] grid;
	private Point player;
	
	private List<Entity> entities = new ArrayList<Entity>();
	private int score;
	
	
	private Color[] types = {
			Color.GREEN,
			Color.BLACK,
			Color.YELLOW
	};
	
	public GridWorld(int width, int height) {
		this.size = new Dimension(width, height);
		this.grid = new int[width][height];
		this.player = new Point(0,0);
		this.entities = new ArrayList<Entity>();
		this.score = 0;
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
				
				g.setColor(Color.BLACK);
				g.drawRect(x*32, y*32, 32, 32);
			}
		}
		
		for(Entity entity : entities){
			entity.draw(g);
		}
	}
	
	public boolean isRoadType(int x, int y){
		if (x < 0 || y < 0 || x>= size.width || y >= size.height) {
			return false;
		}
		
		int type = getTileType(x,y);
		return type == 1 || type == 2;
	}
	
	public boolean isRoadType(Vector2D location){
		return isRoadType(location.getX(), location.getY());
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
					if(Math.random() > 0.95){
						// TODO Add aicar
						addEntity(new AICar(new Vector2D(x, y)));
					}
				}
			}
		}
	}
	
	public Collection<Entity> getEntityAt(int x, int y) {
		Collection<Entity> entities = new ArrayList<Entity>();
		System.out.println("entity check called");
		
		for (Entity entity : this.entities) {
			if (entity.isAt(x,y)) {
				System.out.println(x+","+y);
				entities.add(entity);
			} else {
				System.out.println(x+","+y+" "+entity.getPosition());
			}
		}
		return entities;
	}

	public int getScore() {
		return score;
	}

	public void incrementScore() {
		this.score++;
	}

	public boolean isViable(Vector2D nextPos) {
		if (!isRoadType(nextPos)){
			return false;
		}
		
		Collection<Entity> entities = getEntityAt(nextPos.getX(), nextPos.getY());
		return entities.isEmpty();
	}

}
