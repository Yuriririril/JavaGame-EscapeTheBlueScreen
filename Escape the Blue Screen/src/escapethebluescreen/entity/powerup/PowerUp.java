/*
 * The powerup class is a super class under the entity
 * class and holds the following classes:
 * 		-debugger class
 * 		-antivirus class
 * 		-firewall class
 * 		-refresh class
 * 
 * Being in contact with an enemy will cause a positive
 * effect on the player's gameplay.
 */

package escapethebluescreen.entity.powerup;

import escapethebluescreen.Handler;
import escapethebluescreen.entity.Entity;

public abstract class PowerUp extends Entity {

	public PowerUp(Handler handler, float x, float y) {
		super(handler, x, y, 22, 27);
		
		bounds.x = 1;
		bounds.y = 1;
		bounds.width = 20;
		bounds.height = 20;
	}
	
}
