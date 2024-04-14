package pl.edu.pw.mini.zpoif.task5.osoba.cywil;

import pl.edu.pw.mini.zpoif.task5.solution.annotation.CiekawyOpis;

public class Kierowca extends Cywil {

	@CiekawyOpis(bardzoCiekawy = false)
	protected String opisZalet;

	public Kierowca() {
		
	}
	
	public Kierowca(String imie, String nazwisko, int wiek, String opisZalet) {
		super(imie, nazwisko, wiek);
		this.opisZalet = opisZalet;
	}

}
