package uk.me.webpigeon.jams.jam2016.model;

public abstract class AbstractAction implements Action {
	private final String name;

	public AbstractAction(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

}
