package pl.edu.pw.mini.zpoif.task1.officers.politicians;

import java.time.LocalDate;
import java.time.LocalTime;

import pl.edu.pw.mini.zpoif.task1.officers.Officer;
import pl.edu.pw.mini.zpoif.task1.officers.equipment.Equipment;

public abstract class Politician extends Officer {
	private Card card;
	
	public Politician() {
		init();
	}
	
	protected class Card extends Equipment {
		private LocalDate expiryDate;
		
		public Card(LocalDate date) {
			expiryDate = date;
		}
		
		protected boolean isValid() {
			return expiryDate.isBefore(LocalDate.now());
		}
	}
	
	protected class SmartWatch extends Equipment {
		protected void printTime() {
			System.out.println(GREETING + " " + LocalTime.now());
		}
	}
	
	public abstract void checkTime();

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}
	
}
