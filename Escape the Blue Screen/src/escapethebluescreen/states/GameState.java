/*
 * This class creates a new game state object.
 * 
 * It contains the interface of the entire game 
 * state itself.
 */

package escapethebluescreen.states;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import escapethebluescreen.Handler;
import escapethebluescreen.entity.Background;
import escapethebluescreen.entity.creature.Player;
import escapethebluescreen.entity.creature.enemy.BlueScreen;
import escapethebluescreen.spawns.Spawn;
import escapethebluescreen.spawns.SpawnSeqGenerator;

public class GameState extends State {
	
	private boolean pausable = true;
	public static boolean paused;
	private int fromPauseIdleTime = 0;
	
	public static Player player;
	private Background background;
	private BlueScreen blueScreen;
	
	private ArrayList<Spawn> spawns;

	public GameState(Handler handler) {
		super(handler);
		player = new Player(handler, 333, 350);
		background = new Background(handler, 0, 0);
		blueScreen = new BlueScreen(handler, 81, 380);
		
		spawns = SpawnSeqGenerator.getSpawnSequence(handler, 1);
	}
	
	@Override
	public void tick() {
		player.tick();
		background.tick();
		blueScreen.tick();
		
		for (Spawn e: spawns) {
			e.tick();
		}
		
		if (((handler.getMouseManager().getLeftClick()
				&& handler.getMouseManager().getX() >= 500
				&& handler.getMouseManager().getX() <= 700
				&& handler.getMouseManager().getY() >= 400
				&& handler.getMouseManager().getY() <= 500)
				|| handler.getKeyManager().space)
				&& pausable) {
			pausable = false;
			if (!paused) {
				paused = true;
			}
			else {
				paused = false;
			}
		}
		
		if (!pausable) {
			fromPauseIdleTime += 1;
		}
		
		if (fromPauseIdleTime >= 30) {
			pausable = true;
			fromPauseIdleTime = 0;
		}
	}

	@Override
	public void render(Graphics graphics) {
		background.render(graphics);
		
		for (Spawn e: spawns) {
			e.render(graphics);
		}
		
		player.render(graphics);
		blueScreen.render(graphics);
		
		if (handler.getMouseManager().getX() >= 500 && handler.getMouseManager().getX() <= 700
				&& handler.getMouseManager().getY() >= 400 && handler.getMouseManager().getY() <= 500) {
			graphics.setColor(Color.RED);
			graphics.drawRect(500, 400, 200, 100);
		}
	}

}
