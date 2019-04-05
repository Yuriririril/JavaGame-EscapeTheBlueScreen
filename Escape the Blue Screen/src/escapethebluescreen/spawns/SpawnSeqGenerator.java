package escapethebluescreen.spawns;

import java.util.ArrayList;

import escapethebluescreen.Handler;
import escapethebluescreen.util.Utilities;

public class SpawnSeqGenerator {

	public static ArrayList<Spawn> getSpawnSequence(Handler handler, int mapId) {
		ArrayList<Spawn> spawnSequence = new ArrayList<Spawn>();
		
		int counter = 0;
		
		ArrayList<Integer> coordinates = new ArrayList<Integer>();
		ArrayList<Integer> xCoordinates = new ArrayList<Integer>();
		ArrayList<Integer> yCoordinates = new ArrayList<Integer>();
	
		String[] stringPattern = null;
		
		if(mapId == 1) {
			stringPattern = Utilities.split(Utilities.readFile("resource/maps/SpawnSeq1.ssq"));
		}
			
		for(int i = 0; i < stringPattern.length; i ++) {
			if(stringPattern[i] != "0") {
				coordinates.add(i);
				xCoordinates.add(i % 8);
				yCoordinates.add((stringPattern.length / 8) - (i / 8));
				counter ++;
			}
		}
		
		for(int i = 0; i < counter; i ++) {
			int spawnId = Integer.parseInt(stringPattern[coordinates.get(i)]);
			spawnSequence.add(new Spawn(handler, spawnId, 213 + (36 * xCoordinates.get(i)), yCoordinates.get(i) * 200));
		}

		return spawnSequence;
	}
	
}
