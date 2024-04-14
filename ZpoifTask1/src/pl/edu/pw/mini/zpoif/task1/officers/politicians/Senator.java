package pl.edu.pw.mini.zpoif.task1.officers.politicians;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Senator extends Politician {

	@Override
	public void checkTime() {
		List<SmartWatch> smartWatches = new LinkedList<>();
		
		for (int i = 0; i < 3; i++) {
			smartWatches.add(new SmartWatch());
		}
		
		smartWatches.get(random.nextInt(smartWatches.size())).printTime();
	}

	@Override
	public void init() {
		LocalDate date = LocalDate.now();
		
		date.plusDays(-random.nextInt(1, 11));
		setCard(new Card(date));
	}

}
