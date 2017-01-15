package pack;

import java.util.Comparator;

public class SortByTitle implements Comparator<Seance>{

	@Override
	public int compare(Seance o1, Seance o2) {
		return o1.getMovie().getTitle().compareTo(o2.getMovie().getTitle());
	}

}
