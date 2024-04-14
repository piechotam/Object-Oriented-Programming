package pl.edu.pw.mini.zpoif.task5.osoba.cywil;

import pl.edu.pw.mini.zpoif.task5.solution.annotation.CiekawyOpis;
import pl.edu.pw.mini.zpoif.task5.solution.annotation.PodkreslZnaczenie;

public class Lekarz extends Cywil {
	
	@PodkreslZnaczenie
	@CiekawyOpis(bardzoCiekawy = true)
	protected String opisSukcesow;

	public Lekarz() {
		
	}
	
	public Lekarz(String imie, String nazwisko, int wiek, String opisSukcesow) {
		super(imie, nazwisko, wiek);
		this.opisSukcesow = opisSukcesow;
	}

}
