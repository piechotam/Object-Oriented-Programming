package pl.edu.pw.mini.zpoif.task1.officers.politicians;

import java.time.LocalDate;

public class Envoy extends Politician {
	@Override
	public void checkTime() {
		class SmartWatchWithControl extends SmartWatch {
			@Override
			protected void printTime() {
				if (getCard().isValid()) {
					super.printTime();
				}
			}
		}
		 SmartWatchWithControl smartWatchWithControl = new SmartWatchWithControl();
		 smartWatchWithControl.printTime();
	}

	@Override
	public void init() {
		LocalDate date = LocalDate.now();
		
		int daysNumber = random.nextInt(5) + 1;
		if (random.nextBoolean()) {
			date.plusDays(daysNumber);
		}
		
		else {
			date.plusDays(-daysNumber);
		}
		
		setCard(new Card(date));
	}

}
