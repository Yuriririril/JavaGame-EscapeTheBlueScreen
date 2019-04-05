package escapethebluescreen.entity.creature.enemy;

import java.awt.Graphics;

import escapethebluescreen.Handler;
import escapethebluescreen.gfx.Animation;
import escapethebluescreen.gfx.Assets;

public class BlueScreen extends Enemy {
	
	private Animation shake;
	
	public BlueScreen(Handler handler, float x, float y) {
		super(handler, x, y, 539, 313);
		this.handler = handler;
		
		shake = new Animation(200, Assets.blueScreen);
	}

	@Override
	public void tick() {
		shake.tick();
	}

	@Override
	public void render(Graphics graphics) {
		graphics.drawImage(shake.getCurrentFrame(), (int) x, (int) y, null);
	}

}
