package uk.me.webpigeon.jams.jam2016;

import java.io.InputStream;
import java.util.Scanner;

import uk.me.webpigeon.jams.jam2016.model.ActionStack;
import uk.me.webpigeon.jams.jam2016.model.Direction;
import uk.me.webpigeon.jams.jam2016.model.GridWorld;
import uk.me.webpigeon.jams.jam2016.model.ImageGallery;
import uk.me.webpigeon.jams.jam2016.model.Vector2D;
import uk.me.webpigeon.jams.jam2016.model.entities.AICar;
import uk.me.webpigeon.jams.jam2016.model.entities.Entity;
import uk.me.webpigeon.jams.jam2016.model.entities.PlayerCar;
import uk.me.webpigeon.jams.jam2016.model.entities.TrafficLight;

public class MapLoader {

	public static final GridWorld loadWorld(String filename) {
		InputStream is = MapLoader.class.getClassLoader().getResourceAsStream(filename);

		Scanner scanner = new Scanner(is);

		// figure out the map size
		int width = scanner.nextInt();
		int height = scanner.nextInt();
		int startX = scanner.nextInt();
		int startY = scanner.nextInt();
		int npcs = scanner.nextInt();
		int par = scanner.nextInt();
		scanner.nextLine();

		GridWorld world = new GridWorld(width, height);
		world.setSpawnPoint(startX, startY);
		world.setPar(par);

		// load in the tiles
		for (int y = 0; y < height; y++) {
			Scanner line = new Scanner(scanner.nextLine());
			for (int x = 0; x < width; x++) {
				world.setTileAt(x, y, line.nextInt());
			}
			line.close();
		}
		
		//load the entities
		while(scanner.hasNextLine()){
			Scanner line = new Scanner(scanner.nextLine());
			
			String type = line.next();
			Vector2D location = new Vector2D(line.nextInt(), line.nextInt());
			
			if ("lights".equals(type)) {
				int activeTime = line.nextInt();
				int nonActiveTime = line.nextInt();
				world.addEntity(new TrafficLight(location, activeTime, nonActiveTime));
			} else if ("npc".equals(type)) {
				Direction facing = Direction.valueOf(line.next());
				Entity npc = new AICar(location);
				npc.setFacing(facing);
				world.addEntity(npc);
			}
			
			line.close();
		}
		scanner.close();

		world.initialiseAICars(npcs);

		return world;
	}

	public static final void buildWorld(GridWorld world, ActionStack actionModel) {
		ImageGallery imageGallery = new ImageGallery("graphics");
		world.setGallery(imageGallery);

		Vector2D startPos = world.getSpawnPoint();
		world.addEntity(new PlayerCar(startPos.getX(), startPos.getY(), actionModel));
	}

}
