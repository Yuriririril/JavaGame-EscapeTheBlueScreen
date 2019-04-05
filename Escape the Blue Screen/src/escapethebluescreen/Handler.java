/*
 * This class is assigned to freely pass variables
 * and methods from one class to another.
 */

package escapethebluescreen;

import escapethebluescreen.input.KeyManager;
import escapethebluescreen.input.MouseManager;

public class Handler {
	
	private Game game;
	
	public Handler(Game game) {
		this.game = game;
	}
	
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	
	public MouseManager getMouseManager() {
		return game.getMouseManager();
	}
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
}
