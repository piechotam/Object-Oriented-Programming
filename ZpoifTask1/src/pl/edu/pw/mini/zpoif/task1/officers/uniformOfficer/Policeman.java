package pl.edu.pw.mini.zpoif.task1.officers.uniformOfficer;

import pl.edu.pw.mini.zpoif.task1.officers.equipment.Equipment;

public class Policeman extends UniformOfficer {	
	private Radar radar;
	private Boolean radarTraining;
	
	public Policeman() {
		init();
	}
	
	public class Radar extends Equipment {
		public void checkSpeed() {
			if (radarTraining) {
				System.out.println(random.nextInt(81) + 20);
			}
			else {
				System.out.println("Brak przeszkolenia");
			}
		}
	}

	@Override
	public void doJob() {
		int randVal = random.nextInt(10);
		if (randVal < 6) {
			radar.checkSpeed();
		}
		else {
			System.out.println("Bez pomiaru");
		}
	}

	@Override
	public void init() {
		radar = new Radar();
		setColor(Color.NIEBIESKI);
		
		radarTraining = random.nextBoolean();
	}

}
