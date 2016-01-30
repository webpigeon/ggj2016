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

public class GridWorld {
	private Dimension size;
	private int[][] grid;
	private Point player;

	private List<Entity> entities = new ArrayList<Entity>();
	private int score;
	private ImageGallery imageGallery;

	private Vector2D spawnPoint;
	private int par;

	private Color[] types = { Color.GREEN, Color.BLACK, Color.YELLOW };
	private boolean hasWon;
	private int npcs;

	public GridWorld(int width, int height) {
		this.size = new Dimension(width, height);
		this.grid = new int[width][height];
		this.player = new Point(0, 0);
		this.entities = new ArrayList<Entity>();
		this.score = 0;
		this.hasWon = false;
		this.spawnPoint = null;
		this.par = 0;
	}

	public void setPar(int par) {
		this.par = par;
	}

	public int getPar() {
		return par;
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
		for (int x = 0; x < size.width; x++) {
			for (int y = 0; y < size.height; y++) {
				int type = grid[x][y];

				if (imageGallery != null) {
					g.drawImage(imageGallery.get(type), x * World.TILE_SIZE, y * World.TILE_SIZE, World.TILE_SIZE,
							World.TILE_SIZE, null);
				} else {
					g.setColor(types[type]);
					g.fillRect(x * World.TILE_SIZE, y * World.TILE_SIZE, World.TILE_SIZE, World.TILE_SIZE);
				}
				g.setColor(Color.BLACK);
				g.drawRect(x * World.TILE_SIZE, y * World.TILE_SIZE, World.TILE_SIZE, World.TILE_SIZE);

			}
		}

		for (Entity entity : entities) {
			entity.draw(g, imageGallery);
		}
	}

	public boolean isRoadType(int x, int y) {
		if (x < 0 || y < 0 || x >= size.width || y >= size.height) {
			return false;
		}

		int type = getTileType(x, y);
		return type > 0;
	}

	public boolean isRoadType(Vector2D location) {
		return isRoadType(location.getX(), location.getY());
	}

	public void update() {
		for (Entity entity : entities) {
			entity.update(this);
		}
	}

	public void initialiseAICars(int npcs) {
		int npcsLeft = npcs;

		for (int x = 0; x < size.width; x++) {
			for (int y = 0; y < size.height; y++) {
				if (isRoadType(x, y) && npcsLeft > 0) {
					if (Math.random() > 0.95) {
						// TODO Add aicar
						addEntity(new AICar(new Vector2D(x, y)));
						npcsLeft--;
					}
				}
			}
		}
	}

	public Collection<Entity> getEntityAt(int x, int y) {
		Collection<Entity> entities = new ArrayList<Entity>();

		for (Entity entity : this.entities) {
			if (entity.isAt(x, y)) {
				entities.add(entity);
			} else {
			}
		}
		return entities;
	}

	public int getScore() {
		return score;
	}

	public void addScore(int extra) {
		this.score += extra;
	}

	public boolean isViable(Vector2D nextPos) {
		if (!isRoadType(nextPos)) {
			return false;
		}

		Collection<Entity> entities = getEntityAt(nextPos.getX(), nextPos.getY());
		return entities.isEmpty();
	}

	public void setGallery(ImageGallery gallery) {
		this.imageGallery = gallery;
	}

	public void setWinner() {
		this.hasWon = true;
	}

	public boolean hasWon() {
		return hasWon;
	}

	public void setSpawnPoint(int startX, int startY) {
		this.spawnPoint = new Vector2D(startX, startY);
	}

	public Vector2D getSpawnPoint() {
		return this.spawnPoint;
	}

}
