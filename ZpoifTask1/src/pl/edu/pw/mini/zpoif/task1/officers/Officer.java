package pl.edu.pw.mini.zpoif.task1.officers;

import java.util.Random;

import pl.edu.pw.mini.zpoif.task1.officers.equipment.Equipment;

public abstract class Officer {
	protected static final Random random = new Random();
	protected static final String GREETING = "Hello!";
	
	public abstract void init();
	
}
