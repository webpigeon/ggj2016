package uk.me.webpigeon.jams.jam2016;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;

import uk.me.webpigeon.jams.jam2016.model.Action;
import uk.me.webpigeon.jams.jam2016.model.ActionStack;
import uk.me.webpigeon.jams.jam2016.model.ForwardAction;
import uk.me.webpigeon.jams.jam2016.model.GridWorld;
import uk.me.webpigeon.jams.jam2016.model.ImageGallery;
import uk.me.webpigeon.jams.jam2016.model.RotateAction;
import uk.me.webpigeon.jams.jam2016.model.RotateOtherLeftAction;
import uk.me.webpigeon.jams.jam2016.model.Vector2D;
import uk.me.webpigeon.jams.jam2016.model.Wait;
import uk.me.webpigeon.jams.jam2016.model.World;
import uk.me.webpigeon.jams.jam2016.model.entities.ParkedCar;
import uk.me.webpigeon.jams.jam2016.model.entities.PlayerCar;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		System.out.println("Hello World!");
		System.out.println("Strawberry");
		System.out.println("Orange");
		System.out.println("Gooseberry");

		JFrame frame = new JFrame("Global Game Jam 2016");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(800, 600));

		ActionStack actionModel = new ActionStack();
		ButtonPanel buttons = new ButtonPanel(actionModel);
		buttons.addLegalAction(new ForwardAction());
		buttons.addLegalAction(new RotateAction());
		buttons.addLegalAction(new RotateOtherLeftAction());
		buttons.addLegalAction(new Wait());

		// build the world
		World world = new World();
		GameStepper stepper = new GameStepper(frame, world, actionModel);
		stepper.loadWorld();

		Box box = Box.createVerticalBox();
		JToolBar toolbar = new JToolBar();
		toolbar.add(App.buildButton("run", new GameStepControls(stepper)));
		toolbar.add(App.buildButton("clear", new GameStepControls(stepper)));
		toolbar.add(App.buildButton("simulate", new GameStepControls(stepper)));
		box.add(toolbar);
		JList<Action> list = new JList<Action>(actionModel);
		stepper.setList(list);
		box.add(list);

		frame.add(new JScrollPane(world));
		frame.add(new ButtonPanel(actionModel), BorderLayout.WEST);
		frame.add(buttons, BorderLayout.WEST);
		frame.add(box, BorderLayout.EAST);
		frame.pack();

		frame.setVisible(true);
	}

	public static JButton buildButton(String text, ActionListener listener) {
		JButton btn = new JButton(text);
		btn.setActionCommand(text);
		btn.addActionListener(listener);
		return btn;
	}
}
