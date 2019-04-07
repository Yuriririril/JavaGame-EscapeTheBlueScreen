/*
 * The firewall class holds the firewall entity.
 * 
 * Upon contact with the player, a barrier will be created
 * in front of the player which kills viruses and malwares.
 * 
 * The barrier will not dispel effects from malwares.
 */

package escapethebluescreen.entity.powerup;

import java.awt.Graphics;
import java.awt.Rectangle;

import escapethebluescreen.Handler;
import escapethebluescreen.states.GameState;

public class Firewall extends PowerUp {

	public static Rectangle killArea = new Rectangle(0, 500, 700, 25);
	private int buffTimer = 300;
	
	public Firewall(Handler handler, float x, float y) {
		super(handler, x, y);
	}
	
	@Override
	public void tick() {
		hitBox = new Rectangle((int) (x + bounds.x), (int) (y + bounds.y), (int) (bounds.width), (int) (bounds.height));
		
		if (GameState.player.getHitBox().intersects(this.hitBox)) {
			killArea.y = 200;
			buffTimer -= 1;
			y = 520;
		}
		
		if (buffTimer < 300)
			buffTimer -= 1;
		
		if (buffTimer == 0 || GameState.player.isDead()) {
			buffTimer = 300;
			killArea.y = 500;
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
		
		graphics.fillRect(0, killArea.y, 700, 25);
	}

	public void setBuffTimer(int buffTimer) {
		this.buffTimer = buffTimer;
	}

}
