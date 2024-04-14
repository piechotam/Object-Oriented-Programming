package pl.edu.pw.mini.zpoif.task5.solution;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import pl.edu.pw.mini.zpoif.task5.osoba.Zawodowiec;

public class Demonstrator {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Solution solution = new Solution();
		System.out.println("-----task1-----");
		Zawodowiec zawodowiec = solution.createFunkcjonariusz();
		System.out.println(zawodowiec);
		System.out.println("-----task2-----");
		Set<Zawodowiec> foundZastrzezeni = solution.findZastrzezeni();
		System.out.println(foundZastrzezeni);
		System.out.println("-----task3-----");
		solution.makeFieldsUpperCase();
		System.out.println("-----task4-----");
		solution.hideZastrzezone();
		System.out.println("-----task5&6-----");
		solution.invokeMethods();
		System.out.println("-----task7-----");
		solution.invokeOneParameterMethods();
		System.out.println("-----task8-----");
		solution.printInterestingDescriptions();
	}

}
