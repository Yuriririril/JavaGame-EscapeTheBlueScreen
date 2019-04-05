package escapethebluescreen.entity.creature;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import escapethebluescreen.Handler;
import escapethebluescreen.gfx.Assets;
import escapethebluescreen.states.GameState;

public class Player extends Creature {
	
	private Handler handler;
	private int xMobility = 8, yMobility = 4;
	private int refreshCooldownTimer = 0;
	private boolean refreshed;

	public void setXMobility(int xMobility) {
		this.xMobility = xMobility;
	}

	public void setYMobility(int yMobility) {
		this.yMobility = yMobility;
	}

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, 42, 38);
		this.handler = handler;
		
		bounds.x = 8;
		bounds.y = 7;
		bounds.width = 26;
		bounds.height = 27;
	}

	@Override
	public void tick() {
		
		hitBox = new Rectangle((int) (x + bounds.x), (int) (y + bounds.y), (int) (bounds.width), (int) (bounds.height));
		
		//up control
		if(handler.getKeyManager().up) {
			if(y >= 150 && GameState.paused == false)
				y -= yMobility;
			else
				y -= 0;
		}
		
		//down control
		if(handler.getKeyManager().down) {
			if((int) (y + bounds.height) <= 350 && GameState.paused == false)
				y += yMobility;
			else
				y += 0;
		}
		
		//left control
		if(handler.getKeyManager().left) {
			if (x >= 200 && GameState.paused == false)
				x -= xMobility;
			else
				x -= 0;
		}
		
		//right control
		if(handler.getKeyManager().right) {
			if((int) (x + bounds.width) <= 480 && GameState.paused == false)
				x += xMobility;
			else
				x +=0;
		}
		
		//refresh skill (A), cooldown: 5 seconds
		if(refreshed == false && refreshCooldownTimer == 0 && handler.getKeyManager().a == true) {
			refreshed = true;
			refreshCooldownTimer += 1;
		}
		
		if(refreshCooldownTimer > 0 && refreshCooldownTimer <= 300)
			refreshCooldownTimer += 1;
		
		if(refreshCooldownTimer >= 300) {
			refreshed = false;
			refreshCooldownTimer = 0;
		}
		
	}

	@Override
	public void render(Graphics graphics) {
		
		graphics.drawImage(Assets.computer, (int) x, (int) y, null);
		graphics.drawRect((int) (x + bounds.x), (int) (y + bounds.y), (int) (bounds.width), (int) (bounds.height));
		
	}

}
