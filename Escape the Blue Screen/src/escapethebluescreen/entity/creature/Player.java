/*
 * The player class holds the player entity.
 * 
 * The player is controlled by the user.
 * 
 * If the player dies, the user is redirected to the
 * game over state of the game.
 */

package escapethebluescreen.entity.creature;

import java.awt.Graphics;
import java.awt.Rectangle;

import escapethebluescreen.Handler;
import escapethebluescreen.gfx.Animation;
import escapethebluescreen.gfx.Assets;
import escapethebluescreen.states.GameState;
import escapethebluescreen.states.MenuState;
import escapethebluescreen.states.State;

public class Player extends Creature {
	
	private Handler handler;
	private int xMobility = 8, yMobility = 4;
	private int refreshCooldownTimer = 0;
	private int refreshCharges = 0;
	private boolean refreshed;
	private boolean dead = false;
	
	private Animation malwareAnimation;
	private Animation refreshAnimation;

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, 42, 38);
		this.handler = handler;
		
		malwareAnimation = new Animation(125, Assets.computerRed, false);
		refreshAnimation = new Animation(125, Assets.computerBlue, true);
		
		bounds.x = 8;
		bounds.y = 7;
		bounds.width = 26;
		bounds.height = 27;
	}

	@Override
	public void tick() {
		
		hitBox = new Rectangle((int) (x + bounds.x), (int) (y + bounds.y), (int) (bounds.width), (int) (bounds.height));
		
		if (xMobility == 4 && yMobility == 2) {
			malwareAnimation.tick();
		}
		
		//up control
		if (handler.getKeyManager().up) {
			if (y >= 200 && !GameState.paused)
				y -= yMobility;
			else
				y -= 0;
		}
		
		//down control
		if (handler.getKeyManager().down) {
			if ((int) (y + bounds.height) <= 350 && !GameState.paused)
				y += yMobility;
			else
				y += 0;
		}
		
		//left control
		if (handler.getKeyManager().left) {
			if (x >= 200 && !GameState.paused)
				x -= xMobility;
			else
				x -= 0;
		}
		
		//right control
		if (handler.getKeyManager().right) {
			if ((int) (x + bounds.width) <= 480 && !GameState.paused)
				x += xMobility;
			else
				x +=0;
		}
		
		//refresh skill (A), cooldown: 5 seconds
		if (!refreshed && refreshCooldownTimer == 0 && handler.getKeyManager().a
				&& refreshCharges > 0) {
			refreshed = true;
			refreshAnimation.setIndex(0);
			refreshCooldownTimer += 1;
			refreshCharges -= 1;
			xMobility = 8;
			yMobility = 4;
		}
		
		if (refreshed) {
			refreshAnimation.tick();
		}	
		
		if (refreshCooldownTimer > 0 && refreshCooldownTimer <= 300)
			refreshCooldownTimer += 1;
		
		if (refreshCooldownTimer >= 300) {
			refreshed = false;
			refreshCooldownTimer = 0;
		}
		
		if (dead) {
			State.setState(new MenuState(handler));
		}
		
	}

	@Override
	public void render(Graphics graphics) {
		if (refreshed && refreshAnimation.getCurrentFrame() != null) {
				graphics.drawImage(refreshAnimation.getCurrentFrame(), (int) x, (int) y, null);
		} else {
			graphics.drawImage(Assets.computerDefault, (int) x, (int) y, null);
		}
		
		if (xMobility == 4 && yMobility == 2){
			graphics.drawImage(malwareAnimation.getCurrentFrame(), (int) x, (int) y, null);
		}
	}
	
	public void setXMobility(int xMobility) {
		this.xMobility = xMobility;
	}

	public void setYMobility(int yMobility) {
		this.yMobility = yMobility;
	}

	public int getRefreshCharges() {
		return refreshCharges;
	}

	public void setRefreshCharges(int refreshCharges) {
		this.refreshCharges = refreshCharges;
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

}
