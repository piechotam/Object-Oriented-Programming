package pl.edu.pw.mini.zpoif.task5.solution;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import pl.edu.pw.mini.zpoif.task5.GeneratorZawodowcow;
import pl.edu.pw.mini.zpoif.task5.osoba.Zawodowiec;
import pl.edu.pw.mini.zpoif.task5.solution.annotation.CiekawyOpis;
import pl.edu.pw.mini.zpoif.task5.solution.annotation.Funkcjonariusz;
import pl.edu.pw.mini.zpoif.task5.solution.annotation.PodkreslZnaczenie;
import pl.edu.pw.mini.zpoif.task5.solution.annotation.PoleZastrzezone;
import pl.edu.pw.mini.zpoif.task5.solution.annotation.WywolajJesliMaszPojedynczyArgument;
import pl.edu.pw.mini.zpoif.task5.solution.annotation.WywolajNRazy;
import pl.edu.pw.mini.zpoif.task5.solution.annotation.WywolanieRejestrowane;
import pl.edu.pw.mini.zpoif.task5.solution.annotation.Zastrzezony;

public class Solution {
	private List<Class<?>> znaneKlasy = GeneratorZawodowcow.generujZnaneKlasy();
	private List<Zawodowiec> listaZawodowcow = GeneratorZawodowcow.generujZawodowcow();
	
	public Zawodowiec createFunkcjonariusz() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		for (Class<?> class1 : znaneKlasy) {
			if (class1.isAnnotationPresent(Funkcjonariusz.class)) {
				return (Zawodowiec) class1.getDeclaredConstructor().newInstance();
			}
		}
		return null;
	}
	
	public Set<Zawodowiec> findZastrzezeni() {
		Set<Zawodowiec> foundZastrzezeni = new HashSet<Zawodowiec>();
		
		for (Zawodowiec zawodowiec : listaZawodowcow) {
			Class<? extends Zawodowiec> clazz = zawodowiec.getClass();
			if (clazz.isAnnotationPresent(Zastrzezony.class)) {
				foundZastrzezeni.add(zawodowiec);
			}
		}
		
		return foundZastrzezeni;
	}
	
	public void makeFieldsUpperCase() throws IllegalArgumentException, IllegalAccessException {
		for (Zawodowiec zawodowiec : listaZawodowcow) {
			Class<? extends Zawodowiec> clazz = zawodowiec.getClass();
			Field[] fields = clazz.getDeclaredFields();
			
			for (Field field : fields) {
				field.setAccessible(true);
				if (field.isAnnotationPresent(PodkreslZnaczenie.class) && field.getType().equals(String.class) && field.get(zawodowiec) != null) {
					String fieldValue = (String) field.get(zawodowiec);
					System.out.println("Pole obiektu " + zawodowiec + " przed: " + fieldValue);
					field.set(zawodowiec, fieldValue.toUpperCase());
					System.out.println("Pole obiektu " + zawodowiec + " po: " + (String) field.get(zawodowiec));
				}
			}
		}
	}
	
	public void hideZastrzezone() throws IllegalArgumentException, IllegalAccessException {
		for (Zawodowiec zawodowiec : listaZawodowcow) {
			Class<? extends Zawodowiec> clazz = zawodowiec.getClass();
			Field[] fields = clazz.getDeclaredFields();
			
			for (Field field : fields) {
				if (field.isAnnotationPresent(PoleZastrzezone.class)) {
					field.setAccessible(true);
					if (clazz.isAnnotationPresent(Zastrzezony.class)) {
						field.set(zawodowiec, "");
					}
					else {
						field.set(zawodowiec, "______");
					}
				}
			}
		}
	}
	
	public void invokeMethods() throws IllegalAccessException, InvocationTargetException {
		for (Zawodowiec zawodowiec : listaZawodowcow) {
			Class<? extends Zawodowiec> clazz = zawodowiec.getClass();
			Method[] methods = clazz.getDeclaredMethods();
			
			for (Method method : methods) {
				if (method.isAnnotationPresent(WywolajNRazy.class) && method.getParameterCount() == 0) {
					WywolajNRazy annotation = method.getAnnotation(WywolajNRazy.class);
					
					int randVal = new Random().nextInt(annotation.min() - 1, annotation.max());
					for (int i = 0; i < randVal; i++) {
						method.setAccessible(true);
						method.invoke(zawodowiec);
					}
					
					if (method.isAnnotationPresent(WywolanieRejestrowane.class)) {
						System.out.println("Liczba wywolan metody: " + randVal);
					}
				}
			}
		}
	}
	
	public void invokeOneParameterMethods() throws IllegalAccessException, InvocationTargetException {
		for (Zawodowiec zawodowiec : listaZawodowcow) {
			Class<? extends Zawodowiec> clazz = zawodowiec.getClass();
			Method[] methods = clazz.getDeclaredMethods();
			
			for (Method method : methods) {
				if (method.isAnnotationPresent(WywolajJesliMaszPojedynczyArgument.class) && method.getParameterCount() == 1) {
					Zawodowiec randomZawodowiec = listaZawodowcow.get((new Random()).nextInt(0, listaZawodowcow.size()));
					
					Class<?>[] parameterTypes = method.getParameterTypes();
					if (randomZawodowiec.getClass().equals(parameterTypes[0])) {
						method.setAccessible(true);
						method.invoke(zawodowiec, randomZawodowiec);
					}
				}
			}
		}
	}
	
	//Adnotacja ciekawy opis zostala uzyta to pol opisu u cywili
	//Ponizsza metoda przeszuka kolekcje obiektow w poszukiwaniu tych z polami o oznaczonym ciekawym opisie
	//Wypisze na konsoli wartosci opisu, a jesli flaga bardzoCiekawy jest true to wypisze UpperCasem
	
	public void printInterestingDescriptions() throws IllegalArgumentException, IllegalAccessException {
		for (Zawodowiec zawodowiec : listaZawodowcow) {
			Class<? extends Zawodowiec> clazz = zawodowiec.getClass();
			Field[] fields = clazz.getDeclaredFields();
			
			for (Field field : fields) {
				if (field.isAnnotationPresent(CiekawyOpis.class)) {
					field.setAccessible(true);
					String opis = (String) field.get(zawodowiec);
					
					CiekawyOpis annotation = field.getAnnotation(CiekawyOpis.class);
					if (annotation.bardzoCiekawy()) {
						System.out.println(opis.toUpperCase());
					}
					else {
						System.out.println(opis);
					}
				}
			}
		}
	}
}
