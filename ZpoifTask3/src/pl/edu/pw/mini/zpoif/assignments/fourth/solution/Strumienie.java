package pl.edu.pw.mini.zpoif.assignments.fourth.solution;

import java.util.List;
import java.util.Map;
import java.util.Set;

import pl.edu.pw.mini.zpoif.assignments.fourth.okrety.Korweta;
import pl.edu.pw.mini.zpoif.assignments.fourth.okrety.Okret;
import pl.edu.pw.mini.zpoif.assignments.fourth.okrety.OkretHydrograficzny;
import pl.edu.pw.mini.zpoif.assignments.fourth.okrety.OkretPodwodny;
import pl.edu.pw.mini.zpoif.assignments.fourth.okrety.przeciwminowe.Tralowiec;

public interface Strumienie {
	OkretHydrograficzny getOkretHydrograficznyONajwiekszejWypornosci();
	Set<Tralowiec> get3TralowceNazwaZY();
	OkretPodwodny getNajkrotszyPodwodnyBezMin();
	Korweta getKorwetyONajwiekszejIlosciWyrzutniRakiet();
	void printNazwyOkretowDesantowych();
	Set<Tralowiec> getTralowce();
	double getSredniaZasieguNiszczycieliOrazTralowcow();
	List<String> getNazwyOkretowDesantowychOZanurzeniuWiekszymNiz2();
	Map<String, Integer> getMapaOkretowPodwodnychBezMin();
	List<Okret> getKorwetyTralowceNiszczyciele();
}
