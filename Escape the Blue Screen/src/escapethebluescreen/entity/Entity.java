/*
 * The Entity class is the super class that holds all entities
 * that interacts with each other in the game.
 * 
 * Each entity has the following attributes:
 * 		1. x and y coordinates
 * 		2. height and width of the entire entity
 * 		3. location and dimension of the bounding box, which is
 * 			the actual size and location of the entity
 * 		4. location and dimension of the hitboxes, which is
 * 			generated by the bounding box, which is used for
 * 			entity collisions
 * 
 * Methods include:
 * 		1. getters for the attributes stated above
 * 		2. tick and render methods
 */

package escapethebluescreen.entity;

import java.awt.Graphics;
import java.awt.Rectangle;

import escapethebluescreen.Handler;

public abstract class Entity {
	
	protected Handler handler;
	protected float x, y;	//x and y coordinates of the entire entity
	protected int width, height;	//dimensions of the entire entity
	protected Rectangle bounds, hitBox;	//imaginary rectangles that defines the actual entity
	
	public Entity(Handler handler, float x, float y, int width, int height) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		bounds = new Rectangle(0, 0, width, height);
	}
	
	//methods
	
	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Rectangle getHitBox() {
		return hitBox;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public abstract void tick();

	public abstract void render(Graphics graphics);

}