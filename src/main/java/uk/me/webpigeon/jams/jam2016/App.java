package uk.me.webpigeon.jams.jam2016;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

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
        
        DefaultListModel<String> actionModel = new DefaultListModel<String>();
        
        frame.add(new GridRenderer(gridWorld));
        frame.add(new ButtonPanel(actionModel), BorderLayout.WEST);
        frame.add(new JList<String>(actionModel), BorderLayout.EAST);
        frame.pack();
        
        frame.setVisible(true);
        
        while(true){
        	world.update();
        	Thread.sleep(2000);
        }
    }
}
