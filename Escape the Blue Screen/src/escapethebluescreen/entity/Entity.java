/*
 * The Entity class is the super class that holds all entities
 * that interacts with each other in the game.
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
	
	//getters and setters
	
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
