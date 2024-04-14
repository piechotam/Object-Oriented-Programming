package pl.edu.pw.mini.zpoif.task4a.solution;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import pl.edu.pw.mini.zpoif.task4a.Generator;
import pl.edu.pw.mini.zpoif.task4a.szybowiec.Bocian;
import pl.edu.pw.mini.zpoif.task4a.szybowiec.Szybowiec;
import pl.edu.pw.mini.zpoif.task4a.szybowiec.kabina.KabinaInstruktora;
import pl.edu.pw.mini.zpoif.task4a.szybowiec.kabina.KabinaUcznia;
import pl.edu.pw.mini.zpoif.task4a.szybowiec.kabina.TabliczkaInformacyjna;
import pl.edu.pw.mini.zpoif.task4a.szybowiec.kabina.inne.Instruktor;
import pl.edu.pw.mini.zpoif.task4a.szybowiec.kabina.inne.Nakolannik;
import pl.edu.pw.mini.zpoif.task4a.szybowiec.kabina.inne.Uczen;
import pl.edu.pw.mini.zpoif.task4a.szybowiec.kabina.uchwyt.Uchwyt;
import pl.edu.pw.mini.zpoif.task4a.szybowiec.kabina.uchwyt.Uchwyt.Kolor;
import pl.edu.pw.mini.zpoif.task4a.szybowiec.kabina.uchwyt.UchwytHamulcaKola;
import pl.edu.pw.mini.zpoif.task4a.szybowiec.kabina.uchwyt.UchwytWywietrznika;

public class Solution {	
	public static void task1() throws InstantiationException, IllegalAccessException {
		Class<Nakolannik> cl = Nakolannik.class;
		Nakolannik nakolannik = cl.newInstance();
	}
	
	public static void task2() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		KabinaUcznia kabinaUcznia = getKabinaUczniaUsingReflection();
		
		Field field1 = kabinaUcznia.getClass().getDeclaredField("uchwytWywietrznika");
		field1.setAccessible(true);
		UchwytWywietrznika uchwytWywietrznika = (UchwytWywietrznika) field1.get(kabinaUcznia);
		
		uchwytWywietrznika.getClass().getDeclaredMethod("pociagnij", int.class).invoke(uchwytWywietrznika, 10);
		uchwytWywietrznika.getClass().getDeclaredMethod("popchnij", int.class).invoke(uchwytWywietrznika, 10);
	}
	
	@SuppressWarnings("deprecation")
	public static void task3() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		KabinaUcznia kabinaUcznia = getKabinaUczniaUsingReflection();
		
		Field field1 = kabinaUcznia.getClass().getSuperclass().getDeclaredField("uchwytHamulcaKola");
		field1.setAccessible(true);
		UchwytHamulcaKola uchwytHamulcaKola = (UchwytHamulcaKola) field1.get(kabinaUcznia);
		
		Field field2 = uchwytHamulcaKola.getClass().getDeclaredField("hamulecKola");
		field2.setAccessible(true);
		System.out.println("Hamulec przed: " + field2.get(uchwytHamulcaKola));
		field2.set(uchwytHamulcaKola, field2.getType().newInstance());
		System.out.println("Hamulec po: " + field2.get(uchwytHamulcaKola));
	}
	
	@SuppressWarnings("deprecation")
	public static void task4() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		KabinaUcznia kabinaUcznia = getKabinaUczniaUsingReflection();
		
		Field[] kabinaUczniaFields = kabinaUcznia.getClass().getDeclaredFields();
		Field[] kabinaUczniaFieldsFromSuper = kabinaUcznia.getClass().getSuperclass().getDeclaredFields();
		
		lookForUchwyts(kabinaUczniaFields, kabinaUcznia);
		lookForUchwyts(kabinaUczniaFieldsFromSuper, kabinaUcznia);
	}
	
	public static void task5() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		KabinaInstruktora kabinaInstruktora = getKabinaInstruktoraUsingReflection();
		
		Field field1 = kabinaInstruktora.getClass().getSuperclass().getDeclaredField("tabliczkaInformacyjna");
		field1.setAccessible(true);
		TabliczkaInformacyjna tabliczkaInformacyjna = (TabliczkaInformacyjna) field1.get(kabinaInstruktora);
		
		Field field2 = tabliczkaInformacyjna.getClass().getDeclaredField("nrSeryjny");
		field2.setAccessible(true);
		
		Field field3 = tabliczkaInformacyjna.getClass().getDeclaredField("predkoscDopuszczalna");
		field3.setAccessible(true);
		int predkoscDopuszczalna = field3.getInt(field3);
		
		System.out.println("Nr seryjny przed: " + field2.getInt(tabliczkaInformacyjna));
		field2.set(tabliczkaInformacyjna, predkoscDopuszczalna);
		System.out.println("Nr seryjny po: " + field2.getInt(tabliczkaInformacyjna));
	}
	
	public static void task6(String name, String surname, Nakolannik nakolannik, int numberOfFlights, String motto) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, InstantiationException, InvocationTargetException, NoSuchMethodException {
		KabinaInstruktora kabinaInstruktora = getKabinaInstruktoraUsingReflection();
		
		Field field1 = kabinaInstruktora.getClass().getSuperclass().getDeclaredField("pilot");
		field1.setAccessible(true);
		
		if (Modifier.isAbstract(Uczen.class.getSuperclass().getModifiers())) {
			Uczen uczen = Uczen.class.getDeclaredConstructor(String.class, String.class, Nakolannik.class).newInstance(name, surname, nakolannik);
			Field field2 = uczen.getClass().getDeclaredField("licznikLotowSamodzielnych");
			field2.setAccessible(true);
			field2.set(uczen, numberOfFlights);
			
			Field field3 = uczen.getClass().getSuperclass().getDeclaredField("prywatneMotto");
			field3.setAccessible(true);
			field3.set(uczen, motto);
			
			System.out.println("Pilot w kabinie przed: " + field1.get(kabinaInstruktora));
			field1.set(kabinaInstruktora, uczen);
			System.out.println("Pilot w kabinie po: " + field1.get(kabinaInstruktora));
		}
	}
	
	public static void task7() {
		Class<? super Bocian> c = Bocian.class.getSuperclass();
		while (c != null) {
			Constructor[] constructors = c.getDeclaredConstructors();
			for (Constructor constructor : constructors) {
				if (constructor.getParameterCount() == 2) {
					System.out.println(constructor);
				}
			}
			
			c = c.getSuperclass();
		}
	}
	
	public static void task8() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, InvocationTargetException {
		KabinaInstruktora kabinaInstruktora = getKabinaInstruktoraUsingReflection();
		
		Field field1 = kabinaInstruktora.getClass().getSuperclass().getDeclaredField("pilot");
		field1.setAccessible(true);
		Instruktor instruktor = (Instruktor) field1.get(kabinaInstruktora);
		
		Method[] methods = instruktor.getClass().getDeclaredMethods();
		
		for (Method method : methods) {
			if (Modifier.isPublic(method.getModifiers()) & method.getDeclaringClass().equals(Instruktor.class) & method.getReturnType() != void.class) {
				method.setAccessible(true);
				if (method.getParameterCount() == 1) {
					method.invoke(instruktor, true);
				}
				else if (method.getParameterCount() == 2) {
					method.invoke(instruktor, true, true);
				}
			}
		}
	}
	
	public static KabinaUcznia getKabinaUczniaUsingReflection() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Szybowiec puchacz = Generator.utworzPuchacza();
		
		Field field1 = puchacz.getClass().getDeclaredField("kabinaPierwsza");
		field1.setAccessible(true);
		KabinaUcznia kabinaUcznia = (KabinaUcznia) field1.get(puchacz);
		
		return kabinaUcznia;
	}
	
	public static KabinaInstruktora getKabinaInstruktoraUsingReflection() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Szybowiec puchacz = Generator.utworzPuchacza();
		
		Field field1 = puchacz.getClass().getDeclaredField("kabinaDruga");
		field1.setAccessible(true);
		KabinaInstruktora kabinaInstruktora = (KabinaInstruktora) field1.get(puchacz);
		
		return kabinaInstruktora;
	}
	
	@SuppressWarnings("deprecation")
	public static void lookForUchwyts(Field[] fields, KabinaUcznia kabinaUcznia) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		for (Field field : fields) {
			if (field.getName().startsWith("uchwyt") && !field.isAccessible()) {
				field.setAccessible(true);
				Uchwyt uchwyt = (Uchwyt) field.get(kabinaUcznia);
				
				Field kolorField = uchwyt.getClass().getSuperclass().getDeclaredField("kolorUchwytu");
				kolorField.setAccessible(true);
				Kolor kolor = (Kolor) kolorField.get(uchwyt);
				
				if (kolor == Kolor.BRAZOWY) {
					System.out.println(field.getType().getSimpleName());
				}
			}
		}
	}
}
