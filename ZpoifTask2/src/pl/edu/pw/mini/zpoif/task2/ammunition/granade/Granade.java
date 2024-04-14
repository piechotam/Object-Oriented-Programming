package pl.edu.pw.mini.zpoif.task2.ammunition.granade;

import pl.edu.pw.mini.zpoif.task2.ammunition.Ammunition;
import pl.edu.pw.mini.zpoif.task2.randomSupplier.RandomSupplier;

public abstract class Granade extends Ammunition {
	private static int idCounter = 0;
	
	private boolean safe;
	
	public Granade() {
		setId(idCounter);
		this.safe = RandomSupplier.provideRandomSafeGenerator(false).get();
	}

	public boolean isSafe() {
		return safe;
	}
}
