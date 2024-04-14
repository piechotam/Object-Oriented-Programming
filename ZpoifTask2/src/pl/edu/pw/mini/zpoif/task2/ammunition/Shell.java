package pl.edu.pw.mini.zpoif.task2.ammunition;

public class Shell extends Ammunition {
	private static int idCounter = 0;
	
	private Caliber caliber;
	
	public enum Caliber {
		A(5.56), B(7.62), C(9.0), D(12.7);
		
		private double value;
		
		Caliber(double e) {
			value = e;
		}
		
		public double getCaliberValue() {
			return value;
		}
	}
	
	public Shell() {
		this.setId(idCounter);
		idCounter = idCounter + 1;
	}

	public Caliber getCaliber() {
		return caliber;
	}

	public void setCaliber(Caliber caliber) {
		this.caliber = caliber;
	}

	@Override
	public String toString() {
		return "Shell [caliber=" + caliber.getCaliberValue() + "]";
	}
}
