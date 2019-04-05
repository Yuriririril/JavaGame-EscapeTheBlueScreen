package escapethebluescreen.spawns;

import java.awt.Graphics;

import escapethebluescreen.Handler;
import escapethebluescreen.entity.DeathBeam;
import escapethebluescreen.entity.creature.enemy.Bug;
import escapethebluescreen.entity.creature.enemy.Malware;
import escapethebluescreen.entity.creature.enemy.Virus;

public class Spawn {
	
	private Virus virus;
	private Bug bug;
	private Malware malware;
	private DeathBeam deathBeam;
	
	private int id;
	
	public Spawn(Handler handler, int id, int x, int delay) {
		bug = new Bug(handler, x, -40 - delay);
		virus = new Virus(handler, x, -40 - delay);
		malware = new Malware(handler, x, -40 - delay);
		
		this.id = id;
	}
	
	public void tick() {
		switch(id) {
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
		}
	}
	
	public void render(Graphics graphics) {
		switch(id) {
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
		}
	}

}
