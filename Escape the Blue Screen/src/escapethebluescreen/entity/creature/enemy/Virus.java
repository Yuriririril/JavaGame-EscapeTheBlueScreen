package escapethebluescreen.entity.creature.enemy;

import java.awt.Graphics;
import java.awt.Rectangle;

import escapethebluescreen.Handler;
import escapethebluescreen.gfx.Animation;
import escapethebluescreen.gfx.Assets;
import escapethebluescreen.states.GameState;
import escapethebluescreen.states.MenuState;
import escapethebluescreen.states.State;

public class Virus extends Enemy {
	
	private Animation animationLeft;
	private Animation animationRight;
	private int xMobility = 5;
	private int direction = 1;

	public Virus(Handler handler, float x, float y) {
		super(handler, x, y, 22, 27);
		this.handler = handler;
		
		animationLeft = new Animation(20, Assets.virusLeft);
		animationRight = new Animation(20, Assets.virusRight);
	}

	@Override
	public void tick() {
		hitBox = new Rectangle((int) (x + bounds.x), (int) (y + bounds.y), (int) (bounds.width), (int) (bounds.height));
		
		if(GameState.player.getHitBox().intersects(this.hitBox)) {
			State.setState(new MenuState(handler));
		}	
	}

	@Override
	public void render(Graphics graphics) {
		if (y > -4 && y <= 520) {
			if (direction == 1)
				graphics.drawImage(animationLeft.getCurrentFrame(), (int) x, (int) y, null);
			if (direction == 0)
				graphics.drawImage(animationRight.getCurrentFrame(), (int) x, (int) y, null);
		}
	}

}
