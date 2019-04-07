/*
 * The debugger class holds the debugger entity.
 * 
 * Upon contact with the player, all bugs that is on the
 * screen are eliminated.
 */

package escapethebluescreen.entity.powerup;

import java.awt.Graphics;
import java.awt.Rectangle;

import escapethebluescreen.Handler;
import escapethebluescreen.states.GameState;

public class Debugger extends PowerUp {

	public static Rectangle killArea = new Rectangle(0, 500, 700, 500);
	private int buffTimer = 3;
	
	public Debugger(Handler handler, float x, float y) {
		super(handler, x, y);
	}
	
	@Override
	public void tick() {
		hitBox = new Rectangle((int) (x + bounds.x), (int) (y + bounds.y), (int) (bounds.width), (int) (bounds.height));
		
		if (GameState.player.getHitBox().intersects(this.hitBox)) {
			killArea.y = 0;
			buffTimer -= 1;
			y = 520;
		}
		
		if (buffTimer < 3)
			buffTimer -= 1;
		
		if (buffTimer == 0) {
			buffTimer = 3;
			killArea.y = 500;
		}
		
		if (y <= 0) {
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
