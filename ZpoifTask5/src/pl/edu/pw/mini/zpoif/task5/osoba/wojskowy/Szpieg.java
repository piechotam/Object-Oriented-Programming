package pl.edu.pw.mini.zpoif.task5.osoba.wojskowy;

import pl.edu.pw.mini.zpoif.task5.solution.annotation.Funkcjonariusz;
import pl.edu.pw.mini.zpoif.task5.solution.annotation.PoleZastrzezone;
import pl.edu.pw.mini.zpoif.task5.solution.annotation.WywolajJesliMaszPojedynczyArgument;
import pl.edu.pw.mini.zpoif.task5.solution.annotation.Zastrzezony;

@Funkcjonariusz
@Zastrzezony
public class Szpieg extends Wojskowy {
	public Szpieg() {
		
	}
	
	@PoleZastrzezone
	protected String pseudonim;

	public Szpieg(String imie, String nazwisko, int wiek, String pseudonim) {
		super(imie, nazwisko, wiek);
		this.pseudonim = pseudonim;
	}

	@WywolajJesliMaszPojedynczyArgument
	private void porozmawiajZ(OficerKontrwywiadu oficerKontrwywiadu) {
		System.out.println("Rozmawiam z " + oficerKontrwywiadu);
	}
	
}
