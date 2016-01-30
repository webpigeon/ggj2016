package uk.me.webpigeon.jams.jam2016.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

public class ActionStack implements ListModel<Action> {
	private List<Action> actions;
	private List<ListDataListener> listeners;
	private int current = 0;
	private boolean lock;
	
	public ActionStack() {
		this.actions = new ArrayList<Action>();
		this.listeners = new ArrayList<ListDataListener>();
		this.current = 0;
		this.lock = false;
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

	public Action nextAction() {
		Action action = actions.get(current);
		current++;
		return action;
	}

	public void add(Action action) {
		if (lock) {
			return;
		}
		
		actions.add(action);
		for (ListDataListener listener : listeners) {
			ListDataEvent event = new ListDataEvent(this, ListDataEvent.INTERVAL_ADDED, actions.size()-1, actions.size());
			listener.intervalAdded(event);
		}
	}

	public boolean hasMoreActions() {
		return current < actions.size();
	}

	public void clear() {
		int size = actions.size();
		actions.clear();
		current = 0;
		for (ListDataListener listener : listeners) {
			ListDataEvent event = new ListDataEvent(this, ListDataEvent.INTERVAL_REMOVED, 0, size);
			listener.intervalRemoved(event);
		}
	}

	public void lock() {
		this.lock = true;
	}
	
	public void unlock() {
		this.lock = false;
	}

}
