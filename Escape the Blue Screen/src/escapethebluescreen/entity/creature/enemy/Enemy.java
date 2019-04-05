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
