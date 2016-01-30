package uk.me.webpigeon.jams.jam2016.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class ActionStack implements ListModel<Action> {
	private List<Action> actions;
	private List<ListDataListener> listeners;
	
	public ActionStack() {
		this.actions = new ArrayList<Action>();
		this.listeners = new ArrayList<ListDataListener>();
	}
	
	public void addListDataListener(ListDataListener arg0) {
		listeners.add(arg0);
	}

	public Action getElementAt(int id) {
		return actions.get(id);
	}

	public int getSize() {
		return actions.size();
	}

	public void removeListDataListener(ListDataListener arg0) {
		listeners.remove(arg0);
	}

}
