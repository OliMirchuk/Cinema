package pack;


import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Cinema {
	private Map<Days,Schedule>cinema;
	
	public Cinema() {
		cinema = new TreeMap<Days, Schedule>();
		cinema.put(Days.ПОНЕДІЛОК, new Schedule());
		cinema.put(Days.ВІВТОРОК, new Schedule());
		cinema.put(Days.СЕРЕДА, new Schedule());
		cinema.put(Days.ЧЕТВЕР, new Schedule());
		cinema.put(Days.ПЯТНИЦЯ, new Schedule());
		cinema.put(Days.СУБОТА, new Schedule());
		cinema.put(Days.НЕДІЛЯ, new Schedule());
		
		
	}

	Scanner sca = new Scanner(System.in);
	
	public void addMovie(){
		System.out.println("Щоб додати фільм, оберіть день коли він буде йти:");
		Days[]day = Days.values();
		String myDay = null;
		for (Days days : day) {
			System.out.print(days.name()+" ");
		}System.out.println();
		try {
			myDay = sca.next().toUpperCase();
		Set<Entry<Days, Schedule>> set = cinema.entrySet();
		for (Entry<Days, Schedule> entry : set) {
			if(entry.getKey().name().equals(myDay)){
				Schedule sch = entry.getValue();
				sch.addSeance();
			}
		}
		} catch (NullPointerException e) {
			System.out.println();
		}
		Set<Entry<Days, Schedule>> set = cinema.entrySet();
		for (Entry<Days, Schedule> entry : set) {
			if(entry.getKey().name().equals(myDay)){
			System.out.println(entry.getKey().name()+" ");
			Schedule sch = entry.getValue();
			sch.see();
			}
		}
	}
	public void addThisSeanse(){
		System.out.println("Щоб додати сеанс фільму, вкажіть день показу:");
		Days[]day = Days.values();
		String myDay = null;
		for (Days days : day) {
			System.out.print(days.name()+" ");
		}System.out.println();
		try {
			myDay = sca.next().toUpperCase();
		Set<Entry<Days, Schedule>> set = cinema.entrySet();
		for (Entry<Days, Schedule> entry : set) {
			if(entry.getKey().name().equals(myDay)){
				Schedule sch = entry.getValue();
				if(sch.seances.isEmpty()){
				sch.addSeance();
				}else{
				sch.see();
				System.out.println("Oберіть фільм, сеанс якого буде додано:");
				String title = sca.next();
				if(sch.seances.iterator().next().getMovie().getTitle().equalsIgnoreCase(title)){
				System.out.println("Введіть початок нового сеансу (в форматі год:хв):");
				String timeSt = sca.next();
				String[]mass = timeSt.split(":");
				int hourSt = Integer.parseInt(mass[0]);
				int minSt = Integer.parseInt(mass[1]);
				Time startTime =new Time(hourSt, minSt);
				Time getDuration = sch.seances.iterator().next().getMovie().getDuration();
				Movie movie = new Movie(title, getDuration);
				if((hourSt*60)+minSt>
						(sch.seances.iterator().next().getEndTime().getHour()*60)+sch.seances.iterator().next().getEndTime().getMin()){
				Seance seance = new Seance(movie, startTime);
				if(seance.getStartTime().getHour()*60+seance.getStartTime().getMin()>600&&(seance.getStartTime().getHour()*60+seance.getStartTime().getMin()<1380)){
				if(seance.getEndTime().getHour()*60+seance.getEndTime().getMin()<1380){
				if(sch.seances.add(seance)){
					System.out.println("Сеанс додано");
				}else{
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
				}else{
					System.out.println("Сеанс не можливо додати, тому-що ще не закінчився попередній");
				}
			}
			}
		}
		}
		} catch (NullPointerException e) {
			System.out.println();
		}
		Set<Entry<Days, Schedule>> set = cinema.entrySet();
		for (Entry<Days, Schedule> entry : set) {
			if(entry.getKey().name().equals(myDay)){
			System.out.println(entry.getKey().name()+" ");
			Schedule sch = entry.getValue();
			sch.see();
			}
		}
		}
	public void removeThisSeanse(){
		System.out.println("Щоб видалити сеанс фільму, вкажіть день показу:");
		Days[]day = Days.values();
		String myDay = null;
		for (Days days : day) {
			System.out.print(days.name()+" ");
		}System.out.println();
		try {
			myDay = sca.next().toUpperCase();
		Set<Entry<Days, Schedule>> set = cinema.entrySet();
		for (Entry<Days, Schedule> entry : set) {
			if(entry.getKey().name().equals(myDay)){
				Schedule sch = entry.getValue();
				sch.removeSeance();
			}
		}
		} catch (NullPointerException e) {
			System.out.println();
		}
		Set<Entry<Days, Schedule>> set = cinema.entrySet();
		for (Entry<Days, Schedule> entry : set) {
			if(entry.getKey().name().equals(myDay)){
			System.out.println(entry.getKey().name()+" ");
			Schedule sch = entry.getValue();
			sch.see();
			}
		}
		}
	public void removeMovie(){
		System.out.println("Щоб видалити фільму, вкажіть його назву:");
		allMov();
		String myDay = null;
		try {
			myDay = sca.next();
		Set<Entry<Days, Schedule>> set = cinema.entrySet();
		for (Entry<Days, Schedule> entry : set) {
			Schedule sch = entry.getValue();
			boolean asd = false;
			Iterator<Seance>ss =sch.seances.iterator();
			while(ss.hasNext()){
				Seance aa = ss.next();
				if(aa.getMovie().getTitle().equalsIgnoreCase(myDay)){
					ss.remove();
					asd = true;
			}
			}if(asd){
				System.out.println(" видалено.");
			}	
		}
		} catch (NullPointerException e) {
			System.out.println();
		}catch (NoSuchElementException e) {
			System.out.println();
		}
		Set<Entry<Days, Schedule>> set = cinema.entrySet();
		for (Entry<Days, Schedule> entry : set) {
			System.out.print(entry.getKey().name()+" ");
			Schedule sch = entry.getValue();
			sch.see();
			System.out.println();
			
		}
		}
	public void allMovie(){
		Set<Entry<Days, Schedule>> set = cinema.entrySet();
		for (Entry<Days, Schedule> entry : set) {
			System.out.print(entry.getKey().name()+" ");
			Schedule sch = entry.getValue();
			sch.see();
			System.out.println();
			
		}
	}
	public void allMov(){
		Set<Entry<Days, Schedule>> set = cinema.entrySet();
		for (Entry<Days, Schedule> entry : set) {
			Schedule sch = entry.getValue();
			sch.see();
			
			
		}
	}
}
