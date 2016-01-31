package uk.me.webpigeon.jams.jam2016.model.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import uk.me.webpigeon.jams.jam2016.model.GridWorld;
import uk.me.webpigeon.jams.jam2016.model.ImageGallery;
import uk.me.webpigeon.jams.jam2016.model.Vector2D;
import uk.me.webpigeon.jams.jam2016.model.World;

public class AICar extends Entity {

	public AICar(Vector2D location) {
		this.location = location;
	}

	@Override
	public void update(GridWorld world) {

		Vector2D nextPos = location.add(facing.getVector());
		
		// Check the right - nextPos needs to be viable and right needs to be road and not viable to wait
		Vector2D nextAndRightPos = nextPos.add(facing.getRightDirection().getVector());
		if(world.isViable(nextPos) && world.isRoadType(nextAndRightPos) && !world.isViable(nextAndRightPos)){
			System.out.println("Gave way to the good chap on the right");
			return;
		}
		
		if (world.isViable(nextPos)) {
			location = nextPos;
			return;
		}

		Vector2D rightPos = location.add(facing.getRightDirection().getVector());
		Vector2D leftPos = location.add(facing.getLeftDirection().getVector());

		if (world.isViable(leftPos)) {
			facing = facing.getLeftDirection();
			return;
		}

		if (world.isViable(rightPos)) {
			facing = facing.getRightDirection();
			return;
		}
	}

	@Override
	public void draw(Graphics2D g, ImageGallery ig) {
		double degrees = (facing.ordinal() * Math.PI) / 2;

		int graphicalX = location.getX() * World.TILE_SIZE;
		int graphicalY = location.getY() * World.TILE_SIZE;
		int halfSize = World.TILE_SIZE / 2;

		g.setColor(Color.RED);
		g.drawRect(graphicalX, graphicalY, World.TILE_SIZE, World.TILE_SIZE);

		g.translate(graphicalX + halfSize, graphicalY + halfSize);
		g.rotate(degrees);

		BufferedImage car = ig.get(-98);
		g.drawImage(car, -halfSize, -halfSize, null);

		// g.setColor(Color.CYAN);
		// g.fillRect(-16+padx, -13, 32-(padx*2), 16);

		g.rotate(-degrees);
		g.translate(-graphicalX - halfSize, -graphicalY - halfSize);
	}
}
