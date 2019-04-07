/*
 * The enemy class is a super class under the creature
 * class and holds the following classes:
 * 		-bug class
 * 		-virus class
 * 		-malware class
 * 		-blue screen class
 * 
 * Being in contact with an enemy will cause a negative
 * effect on the player's gameplay.
 */

package escapethebluescreen.entity.creature.enemy;

import escapethebluescreen.Handler;
import escapethebluescreen.entity.creature.Creature;

public abstract class Enemy extends Creature {

	public Enemy(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		
		bounds.x = 1;
		bounds.y = 1;
		bounds.width = 20;
		bounds.height = 25;
	}

}
