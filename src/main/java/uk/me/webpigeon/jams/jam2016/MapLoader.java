package uk.me.webpigeon.jams.jam2016;

import java.io.InputStream;
import java.util.Scanner;

import uk.me.webpigeon.jams.jam2016.model.ActionStack;
import uk.me.webpigeon.jams.jam2016.model.GridWorld;
import uk.me.webpigeon.jams.jam2016.model.ImageGallery;
import uk.me.webpigeon.jams.jam2016.model.Vector2D;
import uk.me.webpigeon.jams.jam2016.model.entities.PlayerCar;

public class MapLoader {

	public static final GridWorld loadWorld(String filename) {
		InputStream is = MapLoader.class.getClassLoader().getResourceAsStream(filename);
		
		Scanner scanner = new Scanner(is);
		
		//figure out the map size
		int width = scanner.nextInt();
		int height = scanner.nextInt();
		int startX = scanner.nextInt();
		int startY = scanner.nextInt();
		int npcs = scanner.nextInt();
		scanner.nextLine();
		
		GridWorld world = new GridWorld(width, height);
		world.setSpawnPoint(startX, startY);

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
		
		world.initialiseAICars(npcs);
		
		return world;
	}
	
	public static final void buildWorld(GridWorld world, ActionStack actionModel){
        ImageGallery imageGallery = new ImageGallery("graphics");
        world.setGallery(imageGallery);
		
        Vector2D startPos = world.getSpawnPoint();
        world.addEntity(new PlayerCar(startPos.getX(), startPos.getY(), actionModel));
	}
	
}
