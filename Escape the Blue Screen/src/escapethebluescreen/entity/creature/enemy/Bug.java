package escapethebluescreen.entity.creature.enemy;

import java.awt.Graphics;
import java.awt.Rectangle;

import escapethebluescreen.Handler;
import escapethebluescreen.gfx.Animation;
import escapethebluescreen.gfx.Assets;
import escapethebluescreen.states.GameState;
import escapethebluescreen.states.MenuState;
import escapethebluescreen.states.State;

public class Bug extends Enemy {

	private Animation defaultAnimation;
	
	public Bug(Handler handler, float x, float y) {
		super(handler, x, y, 22, 27);
		defaultAnimation = new Animation(125, Assets.bug);
	}

	@Override
	public void tick() {
		hitBox = new Rectangle((int) (x + bounds.x), (int) (y + bounds.y), (int) (bounds.width), (int) (bounds.height));
		
		if(GameState.player.getHitBox().intersects(this.hitBox)) {
			State.setState(new MenuState(handler));
		}
		
		if (y <= 520 && GameState.paused == false) {
			defaultAnimation.tick();
			y += 3;
		}
	}

	@Override
	public void render(Graphics graphics) {
		if (y > -4 && y <= 520) {
			graphics.drawImage(defaultAnimation.getCurrentFrame(), (int) x, (int) y, null);
		}
	}

}
