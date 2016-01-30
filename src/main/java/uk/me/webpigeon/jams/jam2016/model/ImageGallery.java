package uk.me.webpigeon.jams.jam2016.model;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

import uk.me.webpigeon.jams.jam2016.MapLoader;

/**
 * This class will hold all the graphics
 * 
 * except those graphics.
 * 
 * Hide those
 * 
 * cherish those
 * 
 * don't let go
 * @author piers
 *
 */
public class ImageGallery {
	private HashMap<Integer, BufferedImage> images = new HashMap<Integer, BufferedImage>();
	
	public ImageGallery(String resourceName){
		// Use the file in the resource to tell you what the numbers mean
		InputStream is = ImageGallery.class.getClassLoader().getResourceAsStream(resourceName);
		Scanner scanner = new Scanner(is);
		while(scanner.hasNextLine()){
			String line = scanner.nextLine();
			String[] parts = line.split(" ");
			// Format should be index space filename
			int index = Integer.parseInt(parts[0]);
			String fileName = parts[1];
		}
	}
	
	public BufferedImage get(int index){
		if(images.containsKey(index)){
			return images.get(index);
		}
		return null;
	}
}
