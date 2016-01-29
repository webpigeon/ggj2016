package uk.me.webpigeon.jams.jam2016;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

import uk.me.webpigeon.jams.jam2016.model.GridWorld;

public class GridRenderer extends JComponent {
	private GridWorld world;
	private Color[] types = {
			Color.BLACK,
			Color.WHITE
	};
	
	public GridRenderer(GridWorld world) {
		this.world = world;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		for (int x=0; x<world.getWidth(); x++) {
			for (int y=0; y<world.getHeight(); y++) {
				int type = world.getTileType(x,y);
				
				g.setColor(types[type]);
				g.fillRect(x*32, y*32, 32, 32);
			}
		}
		
		world.render((Graphics2D)g);
	}

}
