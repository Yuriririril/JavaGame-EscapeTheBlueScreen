/*
 * The blue screen class holds the blue screen entity
 * which is the main antagonist of the game.
 * 
 * The blue screen has the ability to shoot beams that causes
 * the player to lose the game.
 */

package escapethebluescreen.entity.creature.enemy;

import java.awt.Graphics;

import escapethebluescreen.Handler;
import escapethebluescreen.gfx.Animation;
import escapethebluescreen.gfx.Assets;
import escapethebluescreen.states.GameState;

public class BlueScreen extends Enemy {
	
	private Animation defaultAnimation;
	
	public BlueScreen(Handler handler, float x, float y) {
		super(handler, x, y, 539, 313);
		this.handler = handler;
		
		defaultAnimation = new Animation(200, Assets.blueScreen, false);
	}

	@Override
	public void tick() {
		if (!GameState.paused) {
			defaultAnimation.tick();
		}
	}

	@Override
	public void render(Graphics graphics) {
		graphics.drawImage(defaultAnimation.getCurrentFrame(), (int) x, (int) y, null);
	}

}
