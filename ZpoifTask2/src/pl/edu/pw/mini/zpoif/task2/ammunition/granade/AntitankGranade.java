package pl.edu.pw.mini.zpoif.task2.ammunition.granade;

import pl.edu.pw.mini.zpoif.task2.randomSupplier.RandomSupplier;

public class AntitankGranade extends Granade {
	private int emission;
	private int penetrationLevel;
	
	public AntitankGranade() {
		super();
		this.emission = RandomSupplier.provideRandomEmissionGenerator(120, 350).get();
		this.penetrationLevel = RandomSupplier.provideRandomPenetrationLevel().get();
	}

	public int getEmission() {
		return emission;
	}

	public void setPenetrationLevel(int penetrationLevel) {
		this.penetrationLevel = penetrationLevel;
	}
}
