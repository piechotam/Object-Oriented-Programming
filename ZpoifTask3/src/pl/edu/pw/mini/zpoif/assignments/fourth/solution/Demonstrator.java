package pl.edu.pw.mini.zpoif.assignments.fourth.solution;

public class Demonstrator {

	public static void main(String[] args) {
		StrumienieImpl strumienieImpl = new StrumienieImpl();
		
		System.out.println(strumienieImpl.getOkretHydrograficznyONajwiekszejWypornosci());
		System.out.println("----------------------");
		System.out.println(strumienieImpl.get3TralowceNazwaZY());
		System.out.println("----------------------");
		System.out.println(strumienieImpl.getNajkrotszyPodwodnyBezMin());
		System.out.println("----------------------");
		System.out.println(strumienieImpl.getKorwetyONajwiekszejIlosciWyrzutniRakiet());
		System.out.println("----------------------");
		strumienieImpl.printNazwyOkretowDesantowych();
		System.out.println("----------------------");
		System.out.println(strumienieImpl.getTralowce());
		System.out.println("----------------------");
		System.out.println(strumienieImpl.getSredniaZasieguNiszczycieliOrazTralowcow());
		System.out.println("----------------------");
		System.out.println(strumienieImpl.getNazwyOkretowDesantowychOZanurzeniuWiekszymNiz2());
		System.out.println("----------------------");
		System.out.println(strumienieImpl.getMapaOkretowPodwodnychBezMin());
		System.out.println("----------------------");
		System.out.println(strumienieImpl.getKorwetyTralowceNiszczyciele());
		
	}

}
