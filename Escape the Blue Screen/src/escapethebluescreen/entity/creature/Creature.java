/*
 * The creature class is a superclass under the entity class
 * that holds all enemy and player entity classes.
 */

package escapethebluescreen.entity.creature;

import escapethebluescreen.Handler;
import escapethebluescreen.entity.Entity;

public abstract class Creature extends Entity {

	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
	}

}
