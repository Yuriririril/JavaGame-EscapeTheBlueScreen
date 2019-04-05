/*
 * This class is assigned to launch the game entitled:
 * "Escape the Blue Screen"
 */

package escapethebluescreen;

public class Launcher {

	public static void main(String []args) {
		Game game = new Game("Escape the Blue Screen", 700, 500);
		//Game title: Escape the Blue Screen
		//Dimensions: width = 700, height = 500
		game.start();
	}
	
}
