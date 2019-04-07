/*
 * The key manager class gets user input from
 * the key board.
 * 
 * The active controls on the keyboard
 * are the directional keys, the "A" key, and the
 * spacebar.
 */

package escapethebluescreen.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
	
	private boolean[] keys;
	public boolean up, down, left, right, a, space;
	
	public KeyManager() {
		keys = new boolean[256];		
	}
	
	public void tick() {
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		a = keys[KeyEvent.VK_A];
		space = keys[KeyEvent.VK_SPACE];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
