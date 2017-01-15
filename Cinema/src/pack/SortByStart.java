package pack;

import java.util.Comparator;

public class SortByStart implements Comparator<Seance> {

	@Override
	public int compare(Seance o1, Seance o2) {
		int startO1 =o1.getStartTime().getHour()*60+o1.getStartTime().getMin();
		int startO2 =o2.getStartTime().getHour()*60+o2.getStartTime().getMin();
			return startO1-startO2;
	}

}
