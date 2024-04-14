package pl.edu.pw.mini.zpoif.task2.randomSupplier;

import java.util.Random;
import java.util.function.Supplier;

import pl.edu.pw.mini.zpoif.task2.ammunition.Shell.Caliber;

public class RandomSupplier {
	private static final Random random = new Random();
	private static int counter = 0; 
	
	public static Supplier<Caliber> provideRandomCaliberGenerator() {	
		counter = counter + 1;
		
		if (counter < 2000) {
			return () -> Caliber.values()[random.nextInt(4)];
		}
		
		else {
			return () -> Caliber.D;
		}
	}
	
	public static Supplier<Boolean> provideRandomSafeGenerator(boolean alwaysUnlocked) {
		if (alwaysUnlocked) {
			return () -> false; //nieprawda ze safe
		}
		
		else {
			if (random.nextInt(10) < 9) {
				return () -> true;
			}
			else {
				return () -> false;
			}
		}
	}
	
	public static Supplier<Integer> provideRandomEmissionGenerator(int a, int b) {
		return () -> random.nextInt(a, b + 1);
	}
	
	public static Supplier<Integer> provideRandomPenetrationLevel() {
		return () -> random.nextInt(30, 51);
	}
}
