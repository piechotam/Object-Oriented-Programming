package pl.edu.pw.mini.zpoif.task1;

import java.util.HashSet;
import java.util.Set;

import pl.edu.pw.mini.zpoif.task1.officers.uniformOfficer.Policeman;

public class Demonstrator {
	public static void main(String[] args) {
		Policeman policeman = new Policeman();
		Set<Policeman.Radar> radars = new HashSet<>();
		
		for (int i = 0; i < 5; i++) {
			radars.add(policeman.new Radar());
		}
		
		for (Policeman.Radar radar : radars) {
			radar.checkSpeed();
		}

	}
}
