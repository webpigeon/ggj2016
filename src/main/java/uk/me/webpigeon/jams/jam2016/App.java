package uk.me.webpigeon.jams.jam2016;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JToolBar;

import uk.me.webpigeon.jams.jam2016.model.Action;
import uk.me.webpigeon.jams.jam2016.model.ForwardAction;
import uk.me.webpigeon.jams.jam2016.model.GridWorld;
import uk.me.webpigeon.jams.jam2016.model.World;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Hello World!" );
        System.out.println("Strawberry");
        System.out.println("Orange");
        System.out.println("Gooseberry");
        
        JFrame frame = new JFrame("Global Game Jam 2016");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 600));
        
        
        GridWorld gridWorld = MapLoader.loadWorld("chess");
        World world = new World(gridWorld);
        
        Box box = Box.createVerticalBox();
        JToolBar toolbar = new JToolBar();
        toolbar.add(new JButton("run"));
        toolbar.add(new JButton("clear"));
        box.add(toolbar);
        
        DefaultListModel<Action> actionModel = new DefaultListModel<Action>();
        ButtonPanel buttons = new ButtonPanel(actionModel);
        buttons.addLegalAction(new ForwardAction());
        
        box.add(new JList<Action>(actionModel));
        
<<<<<<< HEAD
        frame.add(world);
        frame.add(new ButtonPanel(actionModel), BorderLayout.WEST);
        frame.add(new JList<String>(actionModel), BorderLayout.EAST);
=======
        frame.add(new GridRenderer(world));
        frame.add(buttons, BorderLayout.WEST);
        frame.add(box, BorderLayout.EAST);
>>>>>>> fa5d3193e385cfd2aa8a64224d0082f2912f243d
        frame.pack();
        
        frame.setVisible(true);
        
        while(true){
        	world.update();
        	Thread.sleep(2000);
        	
        }
    }
}
