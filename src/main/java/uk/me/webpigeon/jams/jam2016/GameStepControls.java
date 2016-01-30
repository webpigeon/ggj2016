package uk.me.webpigeon.jams.jam2016;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameStepControls implements ActionListener {
	private GameStepper stepper;
	
	public GameStepControls(GameStepper stepper) {
		this.stepper = stepper;
	}
	
	public void actionPerformed(ActionEvent e) {
		stepper.doTick();
	}

}
