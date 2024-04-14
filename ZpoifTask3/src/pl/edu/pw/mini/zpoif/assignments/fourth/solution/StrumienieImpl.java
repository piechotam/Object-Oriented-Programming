package pl.edu.pw.mini.zpoif.assignments.fourth.solution;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import pl.edu.pw.mini.zpoif.assignments.fourth.okrety.Korweta;
import pl.edu.pw.mini.zpoif.assignments.fourth.okrety.Okret;
import pl.edu.pw.mini.zpoif.assignments.fourth.okrety.OkretDesantowy;
import pl.edu.pw.mini.zpoif.assignments.fourth.okrety.OkretHydrograficzny;
import pl.edu.pw.mini.zpoif.assignments.fourth.okrety.OkretPodwodny;
import pl.edu.pw.mini.zpoif.assignments.fourth.okrety.generator.GeneratorOkretow;
import pl.edu.pw.mini.zpoif.assignments.fourth.okrety.przeciwminowe.NiszczycielMin;
import pl.edu.pw.mini.zpoif.assignments.fourth.okrety.przeciwminowe.Tralowiec;

public class StrumienieImpl implements Strumienie {
	private List<Okret> okrety;
	
	public StrumienieImpl() {
		okrety = GeneratorOkretow.generujOkrety();
	}
	
	@Override
	public OkretHydrograficzny getOkretHydrograficznyONajwiekszejWypornosci() {
		return okrety.stream()
				.filter(s -> (s instanceof OkretHydrograficzny))
				.map(s -> (OkretHydrograficzny) s)
				.max(Comparator.comparingInt(Okret::getWypornosc)).orElse(null);
	}

	@Override
	public Set<Tralowiec> get3TralowceNazwaZY() {
		return okrety.stream()
				.filter(s -> (s instanceof Tralowiec) & s.getNazwa().contains("y"))
				.map(s -> (Tralowiec) s)
				.limit(3)
				.collect(Collectors.toSet());
	}

	@Override
	public OkretPodwodny getNajkrotszyPodwodnyBezMin() {
		return okrety.stream()
				.filter(s -> (s instanceof OkretPodwodny))
				.map(s -> (OkretPodwodny) s)
				.filter(s -> !s.isPosiadaMiny())
				.min(Comparator.comparingDouble(OkretPodwodny::getDlugosc)).orElse(null);
	}

	@Override
	public Korweta getKorwetyONajwiekszejIlosciWyrzutniRakiet() {
		return okrety.stream()
				.skip(6)
				.filter(s -> (s instanceof Korweta) && s.getMocNapedu() <= 20000)
				.map(s -> (Korweta) s)
				.max(Comparator.comparingInt(Korweta::getLiczbaWyrzutniRakiet)).orElse(null);
	}

	@Override
	public void printNazwyOkretowDesantowych() {
		okrety.stream()
			.filter(s -> (s instanceof OkretDesantowy))
			.skip(2)
			.limit(3)
			.filter(s -> (s.getZasieg() >= 1000))
			.forEach(o -> System.out.println(o.getNazwa().toUpperCase()));
	}

	@Override
	public Set<Tralowiec> getTralowce() {
		return okrety.stream()
				.skip(9)
				.limit(20)
				.filter(s -> (s.getWypornosc() <= 500 & s.getDlugosc() >= 40))
				.filter(s -> (s instanceof Tralowiec))
				.map(s -> (Tralowiec) s)
				.skip(1)
				.limit(3)
				.collect(Collectors.toSet());
	}

	@Override
	public double getSredniaZasieguNiszczycieliOrazTralowcow() {
		return okrety.stream()
				.filter(s -> (s instanceof NiszczycielMin | s instanceof Tralowiec))
				.sorted(Comparator.comparingInt(Okret::getWypornosc))
				.limit(8)
				.skip(3)
				.collect(Collectors.summarizingInt(Okret::getZasieg)).getAverage();
	}

	@Override
	public List<String> getNazwyOkretowDesantowychOZanurzeniuWiekszymNiz2() {
		return okrety.stream()
				.filter(s -> (s instanceof OkretDesantowy))
				.map(s -> (OkretDesantowy) s)
				.filter(s -> s.getZanurzenie() > 2)
				.limit(5)
				.map(s -> s.getNazwa())
				.distinct()
				.collect(Collectors.toList());
	}

	@Override
	public Map<String, Integer> getMapaOkretowPodwodnychBezMin() {
		return okrety.stream()
				.filter(s -> (s instanceof OkretPodwodny))
				.map(s -> (OkretPodwodny) s)
				.filter(s -> !s.isPosiadaMiny())
				.sorted(Comparator.comparingInt(OkretPodwodny::getLiczbaTorped).reversed())
				.limit(2)
				.collect(Collectors.toMap(Okret::getNazwa, OkretPodwodny::getMocNapedu,
						(current, replacement) -> replacement));
	}

	@Override
	public List<Okret> getKorwetyTralowceNiszczyciele() {		
		return okrety.stream()
				.filter(s -> ((s instanceof Korweta & ((Korweta) s).getLiczbaWyrzutniRakiet() > 2)
						| (s instanceof Tralowiec & !((Tralowiec) s).isTralMalomagnetyczny())
						| (s instanceof NiszczycielMin & s.getWypornosc() <= 1000)))
				.sorted((s1, s2) -> {
					if (s1 instanceof Korweta) {
						return -1;
					}
					else return 1;	
				})
				.collect(Collectors.toList());
	}
}
