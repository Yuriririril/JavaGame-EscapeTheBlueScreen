/*
 * This class is assigned to generate a buffered
 * image from a bigger buffered image. Some of the
 * sprites used in the game are saved in a spritesheet
 * and are cropped.
 */

package escapethebluescreen.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	private BufferedImage sheet;
	
	public SpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;	
	}
	
	public BufferedImage crop(int x, int y, int width, int height) {
		return sheet.getSubimage(x, y, width, height);	
	}
	
}
