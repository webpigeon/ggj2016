package uk.me.webpigeon.jams.jam2016.model;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

import javax.imageio.ImageIO;

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
 * 
 * @author piers
 *
 */
public class ImageGallery {
	private HashMap<Integer, BufferedImage> images = new HashMap<Integer, BufferedImage>();

	public ImageGallery(String resourceName) {
		// Use the file in the resource to tell you what the numbers mean
		InputStream is = ImageGallery.class.getClassLoader().getResourceAsStream(resourceName);
		Scanner scanner = new Scanner(is);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] parts = line.split(" ");
			// Format should be index space filename
			int index = Integer.parseInt(parts[0]);
			String fileName = "roads/" + parts[1];

			try {
				BufferedImage image = ImageIO.read(ImageGallery.class.getClassLoader().getResourceAsStream(fileName));
				images.put(index, image);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public BufferedImage get(int index) {
		// System.out.println("Asked for: " + index);
		if (images.containsKey(index)) {
			// System.out.println("Image: " + index + " requested succesfully");
			return images.get(index);
		}
		return null;
	}
}
