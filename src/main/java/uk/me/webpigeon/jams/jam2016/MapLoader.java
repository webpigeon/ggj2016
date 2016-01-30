package uk.me.webpigeon.jams.jam2016;

import java.io.InputStream;
import java.util.Scanner;

import uk.me.webpigeon.jams.jam2016.model.GridWorld;

public class MapLoader {

	public static final GridWorld loadWorld(String filename) {
		InputStream is = MapLoader.class.getClassLoader().getResourceAsStream(filename);
		
		Scanner scanner = new Scanner(is);
		
		//figure out the map size
		int width = scanner.nextInt();
		int height = scanner.nextInt();
		scanner.nextLine();
		
		GridWorld world = new GridWorld(width, height);
		
		//load in the tiles
		for (int y=0; y<height; y++) {
			Scanner line = new Scanner(scanner.nextLine());
			for (int x=0; x<width; x++) {
				System.out.println(x+","+y);
				world.setTileAt(x,y,line.nextInt());
			}
			line.close();
		}
		scanner.close();
		
		world.initialiseAICars();
		
		return world;
	}
	
}
