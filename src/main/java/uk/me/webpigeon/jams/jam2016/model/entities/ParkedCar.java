package uk.me.webpigeon.jams.jam2016.model.entities;

import java.awt.Color;
import java.awt.Graphics2D;

import uk.me.webpigeon.jams.jam2016.model.Vector2D;

public class ParkedCar extends Entity {

	public ParkedCar(int x, int y) {
		super();
		this.location = new Vector2D(x, y);
	}
	
	@Override
	public void draw(Graphics2D g) {
		int padx = 4;
		
		g.setColor(Color.RED);
		g.fillRect(location.getX()*32+padx, location.getY()*32, 32-(padx*2), 32);
	}
	
}
