package escapethebluescreen.states;

import java.awt.Color;
import java.awt.Graphics;

import escapethebluescreen.Handler;
import escapethebluescreen.gfx.Assets;

public class MenuState extends State {

	public MenuState(Handler handler) {
		super(handler);
	}
	
	@Override
	public void tick() {	
		if(handler.getMouseManager().getLeftClick() == true
				&& handler.getMouseManager().getY() >= 223
				&& handler.getMouseManager().getY() <= 270) {
			State.setState(new GameState(handler));
		}
	}

	@Override
	public void render(Graphics graphics) {
		graphics.drawImage(Assets.mainMenu, 0, 0, null);
		
		if(handler.getMouseManager().getY() >= 223 && handler.getMouseManager().getY() <= 270) {
			graphics.setColor(Color.RED);
			graphics.drawRect(0, 223, 699, 47);
		}
		
		if(handler.getMouseManager().getY() >= 271 && handler.getMouseManager().getY() <= 318) {
			graphics.setColor(Color.RED);
			graphics.drawRect(0, 271, 699, 47);
		}
		
		if(handler.getMouseManager().getY() >= 319 && handler.getMouseManager().getY() <= 366) {
			graphics.setColor(Color.RED);
			graphics.drawRect(0, 319, 699, 47);
		}

		if(handler.getMouseManager().getY() >= 367 && handler.getMouseManager().getY() <= 414) {
			graphics.setColor(Color.RED);
			graphics.drawRect(0, 367, 699, 47);
		}	
		
		if(handler.getMouseManager().getY() >= 415 && handler.getMouseManager().getY() <= 462) {
			graphics.setColor(Color.RED);
			graphics.drawRect(0, 415, 699, 47);
		}	
	}

	
}
