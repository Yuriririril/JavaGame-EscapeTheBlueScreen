/*
 * This class is assigned to generate a buffered
 * image by providing a string variable that
 * indicates the directory where the images are stored.
 * 
 * All images are saved in the textures folder
 * under the resource folder.
 */

package escapethebluescreen.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {

	public static BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(ImageLoader.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		return null;
	}
	
}
