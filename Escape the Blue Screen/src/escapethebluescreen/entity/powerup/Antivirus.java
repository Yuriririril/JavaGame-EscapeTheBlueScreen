/*
 * The antivirus class holds the antivirus entity.
 * 
 * Upon contact with the player, a barrier will be created
 * around the user which protects the user from viruses and
 * malwares.
 * 
 * The barrier dispels the effects from malwares.
 */

package escapethebluescreen.entity.powerup;

import java.awt.Graphics;
import java.awt.Rectangle;

import escapethebluescreen.Handler;
import escapethebluescreen.states.GameState;

public class Antivirus extends PowerUp {

	public Antivirus(Handler handler, float x, float y) {
		super(handler, x, y);
	}
	
	@Override
	public void tick() {
		hitBox = new Rectangle((int) (x + bounds.x), (int) (y + bounds.y), (int) (bounds.width), (int) (bounds.height));
		
		if (GameState.player.getHitBox().intersects(this.hitBox)) {
			y = 520;
		}
		
		if(y <= 0) {
			y += 3;
		} else if(y <=520) {
			y += 5;
		}
	}

	@Override
	public void render(Graphics graphics) {
		if (y <= 520) {
			graphics.fillRect((int) x, (int) y, width, height);
		}
	}

}
