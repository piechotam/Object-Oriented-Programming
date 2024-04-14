package pl.edu.pw.mini.zpoif.task2.ammoChest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

import pl.edu.pw.mini.zpoif.task2.ammunition.Ammunition;
import pl.edu.pw.mini.zpoif.task2.ammunition.Shell;
import pl.edu.pw.mini.zpoif.task2.ammunition.granade.AntitankGranade;
import pl.edu.pw.mini.zpoif.task2.ammunition.granade.DefensiveGranade;
import pl.edu.pw.mini.zpoif.task2.ammunition.granade.OffensiveGranade;

public class AmmoChest {
	private List<Ammunition> ammunitions;
	
	public AmmoChest() {
		initializeAmmunitions();
	}
	
	public void initializeAmmunitions() {
		List<Ammunition> ammunitions = new ArrayList<Ammunition>();
		
		for (int i = 0; i < 20; i++) {
			ammunitions.add(new AntitankGranade());
			ammunitions.add(new DefensiveGranade());
			ammunitions.add(new OffensiveGranade());
		}
		
		for (int i = 0; i < 2000; i++) {
			ammunitions.add(new Shell());
		}
		
		Collections.shuffle(ammunitions);
		
		this.ammunitions = ammunitions;
	}
	
	public Set<AntitankGranade> getEcoArmourPiercingGrenades()  {
		Set<AntitankGranade> ecoAntiTankGranades = new HashSet<AntitankGranade>();
		
		ammunitions.forEach((ammunition) -> {
			if (ammunition instanceof AntitankGranade && ((AntitankGranade) ammunition).getEmission() <= 150) {
				ecoAntiTankGranades.add((AntitankGranade) ammunition);
			}
		});
		
		return ecoAntiTankGranades;
	}
	
	public void printUnlockedGrenades() {
		ammunitions.forEach((ammunition) -> {
			if (ammunition instanceof AntitankGranade && !((AntitankGranade) ammunition).isSafe()) {
				System.out.println("Ooops!");
			}
		});
	}
	
	public void printSummarizedCaliber() {
		class ShellConsumer implements Consumer<Ammunition> {
			private double caliberSum = 0;
			private int seenShells = 0;
			private int additionCounter = 0;
			
			@Override
			public void accept(Ammunition ammunition) 
			{
				if (ammunition instanceof Shell) 
				{
					seenShells = seenShells + 1;
					if (seenShells > 100 & additionCounter < 100) 
					{
						caliberSum = caliberSum + ((Shell) ammunition).getCaliber().getCaliberValue();
						additionCounter = additionCounter + 1;
					}
				}
			}
			
			public double getCaliberSum() {
				return caliberSum;
			}
		}
		
		ShellConsumer shellConsumer = new ShellConsumer();
		
		ammunitions.forEach(shellConsumer);
		
		System.out.println("Suma kalibrow: " + shellConsumer.getCaliberSum());
	}
	
	public void printBulletDetails() {
		ammunitions.forEach((ammunition) -> {
			if (ammunition instanceof Shell) {
				System.out.println((Shell) ammunition);
			}
		});
	}

	public List<Ammunition> getAmmunitions() {
		return ammunitions;
	}
}
