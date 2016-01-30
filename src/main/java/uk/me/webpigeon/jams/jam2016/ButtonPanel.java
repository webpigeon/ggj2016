package uk.me.webpigeon.jams.jam2016;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JPanel;

import uk.me.webpigeon.jams.jam2016.model.Action;
import uk.me.webpigeon.jams.jam2016.model.ActionStack;

public class ButtonPanel extends JPanel implements ActionListener {
	private ActionStack model;
	private Map<String, Action> actionMap;
	
	
	public ButtonPanel(ActionStack actionModel){
		super();
		this.model = actionModel;
		this.actionMap = new HashMap<String, Action>();
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		add(App.buildButton("Forwards", this));
		add(App.buildButton("backwards", this));
		add(App.buildButton("Rotate 90", this));
		add(App.buildButton("Rotate 180", this));
	}
	
	public void addLegalAction(Action action){
		actionMap.put(action.getName(), action);
	}

	public void actionPerformed(ActionEvent arg0) {
		System.out.println("clicked "+arg0.getActionCommand());
		Action action = actionMap.get(arg0.getActionCommand());
		if (action != null) {
			model.add(action);
		}
	}

}
