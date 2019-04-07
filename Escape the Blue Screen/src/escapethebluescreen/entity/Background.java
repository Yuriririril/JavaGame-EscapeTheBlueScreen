/*
 * This class controls the speed at which the background moves downward.
 */

package escapethebluescreen.entity;

import java.awt.Graphics;

import escapethebluescreen.Handler;
import escapethebluescreen.gfx.Animation;
import escapethebluescreen.gfx.Assets;
import escapethebluescreen.states.GameState;

public class Background extends Entity {
	
	private Animation defaultAnimation;

	public Background(Handler handler, float x, float y) {
		super(handler, x, y, 700, 500);
		this.handler = handler;
		

		defaultAnimation = new Animation(1, Assets.background, false);
	}

	@Override
	public void tick() {
		if (!GameState.paused)
			defaultAnimation.tick();
	}

	@Override
	public void render(Graphics graphics) {
		graphics.drawImage(defaultAnimation.getCurrentFrame(), (int) x, (int) y, null);
	}

}
