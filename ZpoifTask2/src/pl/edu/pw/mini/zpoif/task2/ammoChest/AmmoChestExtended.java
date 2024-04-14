package pl.edu.pw.mini.zpoif.task2.ammoChest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import pl.edu.pw.mini.zpoif.task2.ammunition.Ammunition;
import pl.edu.pw.mini.zpoif.task2.ammunition.Shell;
import pl.edu.pw.mini.zpoif.task2.ammunition.Shell.Caliber;
import pl.edu.pw.mini.zpoif.task2.ammunition.granade.AntitankGranade;

public class AmmoChestExtended extends AmmoChest {
	
	public AmmoChestExtended() {
		super();
	}
	
	public void upgradeCaliberToNewOne(Caliber newCaliber) {
		List<Ammunition> ammunitions = getAmmunitions();
		
		ammunitions.forEach((ammunition) -> {
			if (ammunition instanceof Shell && ((Shell) ammunition).getCaliber().getCaliberValue() > 5.56) {
				((Shell) ammunition).setCaliber(newCaliber);
			}
		});
	}
	
	public void replaceValueToFakePenetrationFactor() {
		List<Ammunition> ammunitions = getAmmunitions();
		int newPenetration = new Random().nextInt(120, 351);
		
		ammunitions.forEach((ammunition) -> {
			if (ammunition instanceof AntitankGranade) {
				((AntitankGranade) ammunition).setPenetrationLevel(newPenetration);
			}
		});
	}
	
	public void getSummarizedCO2Emission() {
		List<Ammunition> ammunitions = getAmmunitions();
		List<Integer> emmisions = new ArrayList<Integer>();
		
		ammunitions.forEach((ammunition) -> {
			if (ammunition instanceof AntitankGranade) {
				emmisions.add(((AntitankGranade) ammunition).getEmission());
			}
		});
		
		int sumOfEmmisions = 0;
		for (int emmision : emmisions) {
			sumOfEmmisions = sumOfEmmisions + emmision;
		}
		
		System.out.println("Suma emisji CO2: " + sumOfEmmisions);
	}
}
