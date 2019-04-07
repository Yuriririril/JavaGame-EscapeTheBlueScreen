/*
 * The refresh class holds the refresh entity.
 * 
 * The refresh power up gives the player the access to the 
 * refresh skill whenever there is a charge available.
 * 
 * The refresh power up can be collected up to five times.
 * 
 * The refresh skill is activated by the user via
 * the "A" key and will only dispel the effects of a
 * malware.
 * 
 * Upon activation, a charge is consumed.
 */

package escapethebluescreen.entity.powerup;

import java.awt.Graphics;
import java.awt.Rectangle;

import escapethebluescreen.Handler;
import escapethebluescreen.states.GameState;

public class Refresh extends PowerUp {

	public Refresh(Handler handler, float x, float y) {
		super(handler, x, y);
	}
	
	@Override
	public void tick() {
		hitBox = new Rectangle((int) (x + bounds.x), (int) (y + bounds.y), (int) (bounds.width), (int) (bounds.height));
		
		if (GameState.player.getHitBox().intersects(this.hitBox)) {
			if (GameState.player.getRefreshCharges() == 5)
				GameState.player.setRefreshCharges(GameState.player.getRefreshCharges());
			else 
				GameState.player.setRefreshCharges(GameState.player.getRefreshCharges() + 1);
			
			y = 520;
		}
		
		if (y <= 0) {
			y += 3;
		} else if (y <=520) {
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
