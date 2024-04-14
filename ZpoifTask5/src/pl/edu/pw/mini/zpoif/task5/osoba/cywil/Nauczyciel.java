package pl.edu.pw.mini.zpoif.task5.osoba.cywil;

import pl.edu.pw.mini.zpoif.task5.solution.annotation.CiekawyOpis;
import pl.edu.pw.mini.zpoif.task5.solution.annotation.Funkcjonariusz;
import pl.edu.pw.mini.zpoif.task5.solution.annotation.PodkreslZnaczenie;

@Funkcjonariusz
public class Nauczyciel extends Cywil{
	@PodkreslZnaczenie
	@CiekawyOpis(bardzoCiekawy = true)
	protected String opisSukcesow;

	public Nauczyciel() {
		
	}
	
	public Nauczyciel(String imie, String nazwisko, int wiek, String opisSukcesow) {
		super(imie, nazwisko, wiek);
		this.opisSukcesow = opisSukcesow;
	}
	
}
