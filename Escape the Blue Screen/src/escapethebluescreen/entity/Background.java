package escapethebluescreen.entity;

import java.awt.Graphics;

import escapethebluescreen.Handler;
import escapethebluescreen.gfx.Animation;
import escapethebluescreen.gfx.Assets;

public class Background extends Entity {
	
	private Animation scrollDown;

	public Background(Handler handler, float x, float y) {
		super(handler, x, y, 700, 500);
		this.handler = handler;
		
		scrollDown = new Animation(1, Assets.background);
	}

	@Override
	public void tick() {
		
		scrollDown.tick();
		
	}

	@Override
	public void render(Graphics graphics) {
		
		graphics.drawImage(scrollDown.getCurrentFrame(), (int) x, (int) y, null);
		
	}

}
