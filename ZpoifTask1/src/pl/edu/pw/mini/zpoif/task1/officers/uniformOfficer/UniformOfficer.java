package pl.edu.pw.mini.zpoif.task1.officers.uniformOfficer;

import pl.edu.pw.mini.zpoif.task1.officers.Officer;

public abstract class UniformOfficer extends Officer {
	private Color color;
	
	public enum Color {
		NIEBIESKI, STALOWY, GRANATOWY;
	}
	
	public abstract void doJob();

	public void setColor(Color color) {
		this.color = color;
	}
}
