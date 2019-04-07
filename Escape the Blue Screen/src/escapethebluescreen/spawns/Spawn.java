/*
 * All classes under the enemy class and the
 * powerup class are accessed by the spawn class.
 * 
 * The spawn class will initiate the positions of
 * all enemies and powerups that will be active during
 * the game.
 */

package escapethebluescreen.spawns;

import java.awt.Graphics;

import escapethebluescreen.Handler;
import escapethebluescreen.entity.DeathBeam;
import escapethebluescreen.entity.creature.enemy.Bug;
import escapethebluescreen.entity.creature.enemy.Malware;
import escapethebluescreen.entity.creature.enemy.Virus;
import escapethebluescreen.entity.powerup.Debugger;
import escapethebluescreen.entity.powerup.Firewall;
import escapethebluescreen.entity.powerup.Refresh;
import escapethebluescreen.states.GameState;

public class Spawn {
	
	private Virus virus;
	private Bug bug;
	private Malware malware;
	private DeathBeam deathBeam;
	private Debugger debugger;
	private Firewall firewall;
	private Refresh refresh;
	
	private int id;
	
	public Spawn(Handler handler, int id, int x, int delay) {
		bug = new Bug(handler, x, -40 - delay);
		virus = new Virus(handler, x, -40 - delay);
		malware = new Malware(handler, x, -40 - delay);
		deathBeam = new DeathBeam(handler, x, -40 - delay);
		debugger = new Debugger(handler, x, -40 - delay);
		firewall = new Firewall(handler, x, -40 - delay);
		refresh = new Refresh(handler, x, -40 - delay);
		
		this.id = id;
	}
	
	public void tick() {
		if (!GameState.paused) {
			switch (id) {
			case 1:
				bug.tick();
				break;
			case 2:
				virus.tick();
				break;
			case 3:
				malware.tick();
				break;
			case 4:
				deathBeam.tick();
				break;
			case 5:
				debugger.tick();
				break;
			case 7:
				firewall.tick();
				break;
			case 8:
				refresh.tick();
				break;
			}
		}
	}
	
	public void render(Graphics graphics) {
		switch (id) {
		case 1:
			bug.render(graphics);
			break;
		case 2:
			virus.render(graphics);
			break;
		case 3:
			malware.render(graphics);
			break;
		case 4:
			deathBeam.render(graphics);
			break;
		case 5:
			debugger.render(graphics);
			break;
		case 7:
			firewall.render(graphics);
			break;
		case 8:
			refresh.render(graphics);
			break;
		}
	}

}
