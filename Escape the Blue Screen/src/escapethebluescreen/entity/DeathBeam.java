/*
 * This class generates the death beam logic.
 * 
 * The death beam is a beam that is shot by the blue screen.
 * 
 * If the player gets in contact with the beam, the player loses
 * the game.
 */

package escapethebluescreen.entity;

import java.awt.Graphics;
import java.awt.Rectangle;

import escapethebluescreen.Handler;
import escapethebluescreen.states.GameState;

public class DeathBeam extends Entity {

	private int yReference = 510;
	
	public DeathBeam(Handler handler, float x, float y) {
		super(handler, x, y, 22, 520);
		
		bounds.x = 1;
		bounds.y = 0;
		bounds.width = 20;
		bounds.height = 520;
	}

	@Override
	public void tick() {
		if (y >= -10)
			yReference = (int) (510 - (10 * y));
		
		hitBox = new Rectangle((int) (x + bounds.x), yReference, (int) (bounds.width), (int) (bounds.height));
		
		if (GameState.player.getHitBox().intersects(this.hitBox))
			GameState.player.setDead(true);
		
		if (!GameState.paused) {
			y += 3;
		}
	}

	@Override
	public void render(Graphics graphics) {
		if (y <= 520) {
			graphics.fillRect((int) (x + bounds.x), yReference, (int) (bounds.width), (int) (bounds.height));
		}
	}

}
