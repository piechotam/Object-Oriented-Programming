package pl.edu.pw.mini.zpoif.task4a.solution;

import java.lang.reflect.InvocationTargetException;

import pl.edu.pw.mini.zpoif.task4a.szybowiec.kabina.inne.Nakolannik;

public class Demonstrator {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
		System.out.println("---task1---");
		Solution.task1();
		System.out.println("---task2---");
		Solution.task2();
		System.out.println("---task3---");
		Solution.task3();
		System.out.println("---task4---");
		Solution.task4();
		System.out.println("---task5---");
		Solution.task5();
		System.out.println("---task6---");
		Solution.task6("JakiesImie", "JakiesNazwisko", Nakolannik.class.newInstance(), 20, "To jest moje nowe motto!");
		System.out.println("---task7---");
		Solution.task7();
		System.out.println("---task8---");
		Solution.task8();
	}

}
