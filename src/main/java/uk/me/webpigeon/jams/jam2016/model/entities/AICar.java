package uk.me.webpigeon.jams.jam2016.model.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import uk.me.webpigeon.jams.jam2016.model.Direction;
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
		if (world.isViable(nextPos)) {
			System.out.println(world.isViable(nextPos));
			location = nextPos;
			return;
		}

		Vector2D rightPos = location.add(facing.getRightDirection().getVector());
		Vector2D leftPos = location.add(facing.getLeftDirection().getVector());

		if (world.isViable(leftPos)) {
			System.out.println(world.isViable(leftPos));
			facing = facing.getLeftDirection();
			return;
		}

		if (world.isViable(rightPos)) {
			System.out.println(world.isViable(rightPos));
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
