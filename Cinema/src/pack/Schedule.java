package pack;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Schedule {
	Comparator<Seance> compar = new SortByTitle();
	 Set<Seance> seances;

Schedule() {
		seances = new TreeSet<Seance>(compar.thenComparing(new SortByStart()));
	}
	Scanner sca = new Scanner(System.in);
	
	public void addSeance() {
	System.out.println("Введіть назву фільму:");
	String title = sca.next();
	System.out.println("Введіть тривалість фільму (в форматі год:хв): ");
	String timeTr = sca.next();
	String[]mas = timeTr.split(":");
	int hour = Integer.parseInt(mas[0]);
	int min = Integer.parseInt(mas[1]);
	Time duration =new Time(hour,min);
	System.out.println("Введіть початок сеансу (в форматі год:хв):");
	String timeSt = sca.next();
	String[]mass = timeSt.split(":");
	int hourSt = Integer.parseInt(mass[0]);
	int minSt = Integer.parseInt(mass[1]);
	Time startTime =new Time(hourSt, minSt);
	Movie movie = new Movie(title, duration);
	Seance seance = new Seance(movie, startTime);
	if((seance.getStartTime().getHour()*60+seance.getStartTime().getMin()>600)&&(seance.getStartTime().getHour()*60+seance.getStartTime().getMin()<1380)){
		if(seance.getEndTime().getHour()*60+seance.getEndTime().getMin()<1380){
		if(seances.add(seance)){
		System.out.println("Сеанс додано");
	}
		else{
		System.out.println("Сеанс не можливо створити!");
	}
	}else{
		System.out.println("Сеанс не можливо додати, тому-що він не встигне закінчитись до закриття кінотеатру");
	}
	}else if(seance.getStartTime().getHour()*60+seance.getStartTime().getMin()<600){
		System.out.println("Кінотеатр ще не відкрився");
	}else if(seance.getStartTime().getHour()*60+seance.getStartTime().getMin()>1380){
		System.out.println("Кінотеатр вже закрито");
	}
}
	 
	public void removeSeance() {
		see();
		System.out.println("Оберіть фільм та введіть його назву фільму:");
		String title = sca.next();
		System.out.println("Введіть початок сеансу (в форматі год:хв):");
		String timeSt = sca.next();
		String[]mass = timeSt.split(":");
		int hourSt = Integer.parseInt(mass[0]);
		int minSt = Integer.parseInt(mass[1]);
		Iterator<Seance>iter = seances.iterator();
		boolean asd = false;
		while (iter.hasNext()) {
			Seance sea = iter.next();
			if(sea.getMovie().getTitle().equals(title)&&(sea.getStartTime().getHour()==hourSt)&&(sea.getStartTime().getMin()==minSt)){
				iter.remove();
				asd = true;
			}	
			}
		if(asd){
			System.out.println("Сеанс видалено.");
		}else{
			System.out.println("Такого сеансу не існує!");
		}
		}
	public void see(){
		Iterator<Seance>seans = seances.iterator();
		while (seans.hasNext()) {
			Seance seance2 = seans.next();
			System.out.println("фільм "+seance2.getMovie().getTitle()+", cеанс триває - "+seance2.getMovie().getDuration().getHour()+" години "+seance2.getMovie().getDuration().getMin()+
					" хвилин,  початок o "+seance2.getStartTime().getHour()+":"+seance2.getStartTime().getMin()+" кінець o "+seance2.getEndTime().getHour()+":"+seance2.getEndTime().getMin());
			
		}
	}
	
}
