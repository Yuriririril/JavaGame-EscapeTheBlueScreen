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
		
		defaultAnimation = new Animation(200, Assets.blueScreen);
	}

	@Override
	public void tick() {
		if (GameState.paused == false) {
			defaultAnimation.tick();
		}
	}

	@Override
	public void render(Graphics graphics) {
		graphics.drawImage(defaultAnimation.getCurrentFrame(), (int) x, (int) y, null);
	}

}
