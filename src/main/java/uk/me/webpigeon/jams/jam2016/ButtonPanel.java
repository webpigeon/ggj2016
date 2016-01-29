package uk.me.webpigeon.jams.jam2016;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel implements ActionListener {
	private DefaultListModel<String> model;
	
	public ButtonPanel(DefaultListModel<String> model){
		super();
		this.model = model;
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		add(buildButton("Fowards", this));
		add(buildButton("backwards", this));
		add(buildButton("Rotate 90", this));
		add(buildButton("Rotate 180", this));
	}
	
	private static JButton buildButton(String text, ActionListener listener) {
		JButton btn = new JButton(text);
		btn.setActionCommand(text);
		btn.addActionListener(listener);
		return btn;
	}

	public void actionPerformed(ActionEvent arg0) {
		System.out.println("clicked "+arg0.getActionCommand());
		model.addElement(arg0.getActionCommand());
	}

}
