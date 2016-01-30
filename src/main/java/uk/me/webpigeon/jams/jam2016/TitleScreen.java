package uk.me.webpigeon.jams.jam2016;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;

public class TitleScreen extends JComponent {

	public TitleScreen() {
		super();
		this.setPreferredSize(new Dimension(800, 600));
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());

		// TODO render world

		g.setColor(Color.WHITE);
		g.drawString("Game Jam 2016", 100, 100);
	}

}
