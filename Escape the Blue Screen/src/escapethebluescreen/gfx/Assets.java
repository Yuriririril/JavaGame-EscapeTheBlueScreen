/*
 * This class is assigned to contain all graphics
 * to be used by the entire game. Graphics include
 * the entities, background images, and buttons to
 * be used to ensure a user friendly interface.
 * 
 * The graphics are declared as buffered images
 * which may either be stored in an array or not.
 */

package escapethebluescreen.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage[] background;
	public static BufferedImage computerDefault;
	public static BufferedImage[] computerRed, computerBlue;
	public static BufferedImage[] bug, virusLeft, virusRight, malware;
	public static BufferedImage[] bugKill, virusKill, malwareKill;
	public static BufferedImage[] blueScreen;
	
	public static BufferedImage mainMenu;
	
	public static void init() {
		
		SpriteSheet backgrounds = new SpriteSheet(ImageLoader.loadImage("/textures/Background.png"));
		background = new BufferedImage[152];
		for(int i = 0; i < 152; i ++) {
			background[i] = backgrounds.crop(0, 456-i*3, 700, 500);
		}
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/SpriteSheet.png"));
		
		computerDefault = sheet.crop(0, 1, 42, 38);
		
		computerRed = new BufferedImage[8];
		computerRed[0] = sheet.crop(0, 39, 42, 38);
		computerRed[1] = computerDefault;
		computerRed[2] = computerRed[0];
		computerRed[3] = computerRed[1];
		computerRed[4] = computerRed[0];
		computerRed[5] = computerRed[1];
		computerRed[6] = computerRed[1];
		computerRed[7] = computerRed[1];
		
		computerBlue = new BufferedImage[4];
		computerBlue[0] = computerDefault;
		computerBlue[1] = sheet.crop(0, 77, 42, 38);
		computerBlue[2] = computerBlue[0];
		computerBlue[3] = computerBlue[1];
		
		bug = new BufferedImage[8];
		bug[0] = sheet.crop(51, 7, 22, 27);
		bug[1] = sheet.crop(51, 34, 22, 27);
		bug[2] = sheet.crop(51, 61, 22, 27);
		bug[3] = sheet.crop(51, 88, 22, 27);
		bug[4] = bug[3];
		bug[5] = bug[2];
		bug[6] = bug[1];
		bug[7] = bug[0];
		
		bugKill = new BufferedImage[4];
		bugKill[0] = sheet.crop(124, 7, 22, 27);
		bugKill[1] = sheet.crop(124, 34, 22, 27);
		bugKill[2] = sheet.crop(124, 61, 22, 27);
		bugKill[3] = sheet.crop(124, 88, 22, 27);
		
		virusLeft = new BufferedImage[2];
		virusLeft[0] = sheet.crop(76, 7, 22, 27);
		virusLeft[1] = sheet.crop(76, 34, 22, 27);
		virusRight = new BufferedImage[2];
		virusRight[0] = sheet.crop(76, 61, 22, 27);
		virusRight[1] = sheet.crop(76, 88, 22, 27);
		
		malware = new BufferedImage[8];
		malware[0] = sheet.crop(100, 7, 22, 27);
		malware[1] = sheet.crop(100, 34, 22, 27);
		malware[2] = sheet.crop(100, 61, 22, 27);
		malware[3] = sheet.crop(100, 88, 22, 27);
		malware[4] = malware[3];
		malware[5] = malware[2];
		malware[6] = malware[1];
		malware[7] = malware[0];
		
		SpriteSheet blueScreens = new SpriteSheet(ImageLoader.loadImage("/textures/BlueScreen.png"));
		blueScreen = new BufferedImage[10];
		blueScreen[0] = blueScreens.crop(86, 87, 539, 313);
		blueScreen[1] = blueScreens.crop(0, 87, 539, 313);
		blueScreen[2] = blueScreens.crop(86, 56, 539, 313);
		blueScreen[3] = blueScreens.crop(45, 37, 539, 313);
		blueScreen[4] = blueScreens.crop(10, 10, 539, 313);
		blueScreen[5] = blueScreens.crop(84, 7, 539, 313);
		blueScreen[6] = blueScreens.crop(54, 63, 539, 313);
		blueScreen[7] = blueScreens.crop(38, 67, 539, 313);
		blueScreen[8] = blueScreens.crop(33, 0, 539, 313);
		blueScreen[9] = blueScreens.crop(86, 45, 539, 313);
		
		mainMenu = ImageLoader.loadImage("/textures/MainMenu.png");
	}
	
}
