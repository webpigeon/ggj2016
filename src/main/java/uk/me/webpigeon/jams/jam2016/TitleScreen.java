package uk.me.webpigeon.jams.jam2016;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class TitleScreen extends JComponent implements MouseListener {
	private JFrame frame;
	
	public TitleScreen(JFrame frame) {
		super();
		this.frame = frame;
		this.setPreferredSize(new Dimension(800, 600));
		this.addMouseListener(this);
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());

		// TODO render world

		g.setColor(Color.WHITE);
		g.drawString("Game Jam 2016", 100, 100);
	}

	public void mouseClicked(MouseEvent arg0) {
		frame.remove(this);
		App.runGame(frame);
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
