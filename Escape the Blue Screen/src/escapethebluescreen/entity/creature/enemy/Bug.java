/*
 * The bug class holds the bug entity.
 * 
 * It is the most basic enemy in the game.
 * 
 * Upon contact with the player, the player
 * loses the game.
 * 
 * It does not move side ways and can be killed
 * by collecting a debugger power up.
 */

package escapethebluescreen.entity.creature.enemy;

import java.awt.Graphics;
import java.awt.Rectangle;

import escapethebluescreen.Handler;
import escapethebluescreen.entity.powerup.Debugger;
import escapethebluescreen.gfx.Animation;
import escapethebluescreen.gfx.Assets;
import escapethebluescreen.states.GameState;

public class Bug extends Enemy {

	private Animation defaultAnimation;
	private Animation deathAnimation;
	private int deathYLocation = 520;
	
	public Bug(Handler handler, float x, float y) {
		super(handler, x, y, 22, 27);
		defaultAnimation = new Animation(125, Assets.bug, false);
		deathAnimation = new Animation(70, Assets.bugKill, true);
	}

	@Override
	public void tick() {
		hitBox = new Rectangle((int) (x + bounds.x), (int) (y + bounds.y), (int) (bounds.width), (int) (bounds.height));
		
		if (GameState.player.getHitBox().intersects(this.hitBox)) {
			GameState.player.setDead(true);
		}
		
		if (y <= 520 && !this.hitBox.intersects(Debugger.killArea)) {
			defaultAnimation.tick();
			y += 3;
		} else {
			if (y < 520) {
				deathYLocation = (int) y;
			}	
			y = 520;
		}
		
		if (deathYLocation < 520) {
			deathAnimation.tick();
			deathYLocation += 3;
		}
	}

	@Override
	public void render(Graphics graphics) {
		if (y > -4 && y <= 520) {
			graphics.drawImage(defaultAnimation.getCurrentFrame(), (int) x, (int) y, null);
		}

		graphics.drawImage(deathAnimation.getCurrentFrame(), (int) x, deathYLocation, null);
	}
	
}
