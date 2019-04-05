package escapethebluescreen.states;

import java.awt.Graphics;

import escapethebluescreen.Handler;

public abstract class State {
	
	public static State currentState = null;
	
	protected Handler handler;
	
	public State(Handler handler) {
		this.handler = handler;
	}
	
	public static void setState(State state) {
		currentState = state;
	}
	
	public static State getState() {
		return currentState;
	}

	public abstract void tick();
	
	public abstract void render(Graphics graphics);
	
}
