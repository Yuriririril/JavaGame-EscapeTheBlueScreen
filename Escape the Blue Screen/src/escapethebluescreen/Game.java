/*
 * This class defines the entire game.
 * 
 * It is responsible for defining the user inputs and
 * creating the game timer.
 * 
 * It contains all states of the game including the following:
 * 		-main menu state (initial state)
 * 		-game state
 * 		-tutorial state
 * 		-about state
 * 		-game over state
 * 		-leader board state
 */

package escapethebluescreen;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import escapethebluescreen.display.Display;
import escapethebluescreen.gfx.Assets;
import escapethebluescreen.input.KeyManager;
import escapethebluescreen.input.MouseManager;
import escapethebluescreen.states.GameState;
import escapethebluescreen.states.MenuState;
import escapethebluescreen.states.State;
import escapethebluescreen.states.TutorialState;

public class Game implements Runnable {
	
	private Display display;
	public String title;
	public int width, height;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bufferStrategy;
	private Graphics graphics;
	
	private KeyManager keyManager;
	private MouseManager mouseManager;
	
	private Handler handler;
	
	public GameState gameState;
	public MenuState menuState;
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();	
	}
	
	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init();
		
		handler = new Handler(this);
		
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		State.setState(menuState);
	}
	
	private void tick() {
		keyManager.tick();
		
		if(State.getState() != null)
			State.getState().tick();	
	}
	
	private void render() {
		bufferStrategy = display.getCanvas().getBufferStrategy();
		
		if(bufferStrategy == null) {
			
			display.getCanvas().createBufferStrategy(3);
			return;
			
		}
		
		graphics = bufferStrategy.getDrawGraphics();
		
		graphics.clearRect(0, 0, width, height);
		
		if(State.getState() != null)
			State.getState().render(graphics);
		
		bufferStrategy.show();
		graphics.dispose();
	}
	
	public void run() {
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			lastTime = now;
			
			if(delta >= 1) {
				tick();
				render();
				delta--;
			}
		}
		
		stop();
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}

	public MouseManager getMouseManager() {
		return mouseManager;
	}
	
	public synchronized void start() {
		if(running)
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running)
			return;
		
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
