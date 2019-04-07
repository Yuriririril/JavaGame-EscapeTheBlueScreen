/*
 * This class is assigned to generate an animation
 * through an array of buffered images.
 * 
 * Animations can be classified into two:
 * 		-looping animation
 * 		-non looping animation
 * 
 * Setting the "limited" variable to false will give
 * a looping animation. Otherwise, a non looping
 * animation.
 */

package escapethebluescreen.gfx;

import java.awt.image.BufferedImage;

public class Animation {
	
	private int speed, index;
	private long lastTime, timer;
	private boolean limited;
	private BufferedImage[] frames;
	
	public Animation(int speed, BufferedImage[] frames, boolean limited) {
		this.speed = speed;
		this.frames = frames;
		this.limited = limited;
		
		index = 0;
		timer = 0;
		lastTime = System.currentTimeMillis();
	}
	
	public void tick() {
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if (timer > speed) {
			index++;
			timer = 0;
			if (!limited && index >= frames.length)
				index = 0;
		}
	}
	
	public BufferedImage getCurrentFrame() {
		try {
			return frames[index];
		} catch (Exception e) {
			return null;
		}
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
