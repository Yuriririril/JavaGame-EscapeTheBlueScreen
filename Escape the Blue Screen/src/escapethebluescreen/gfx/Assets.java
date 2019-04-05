package escapethebluescreen.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage[] background;
	public static BufferedImage computer;
	public static BufferedImage[] bug, virusLeft, virusRight, malware;
	public static BufferedImage[] blueScreen;
	
	public static BufferedImage mainMenu;
	
	public static BufferedImage nullImage;
	
	public static void init() {
		
		SpriteSheet backgrounds = new SpriteSheet(ImageLoader.loadImage("/textures/Background.png"));
		background = new BufferedImage[152];
		for(int i = 0; i < 152; i ++) {
			background[i] = backgrounds.crop(0, 456-i*3, 700, 500);
		}
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/SpriteSheet.png"));
		
		computer = sheet.crop(0, 0, 42, 38);
		
		bug = new BufferedImage[8];
		bug[0] = sheet.crop(51, 7, 22, 27);
		bug[1] = sheet.crop(51, 34, 22, 27);
		bug[2] = sheet.crop(51, 61, 22, 27);
		bug[3] = sheet.crop(51, 88, 22, 27);
		bug[4] = bug[3];
		bug[5] = bug[2];
		bug[6] = bug[1];
		bug[7] = bug[0];
		
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
		
		nullImage = ImageLoader.loadImage("/textures/NullImage.png");
	}
	
	
}
