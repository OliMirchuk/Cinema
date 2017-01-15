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
	System.out.println("������ ����� ������:");
	String title = sca.next();
	System.out.println("������ ��������� ������ (� ������ ���:��): ");
	String timeTr = sca.next();
	String[]mas = timeTr.split(":");
	int hour = Integer.parseInt(mas[0]);
	int min = Integer.parseInt(mas[1]);
	Time duration =new Time(hour,min);
	System.out.println("������ ������� ������ (� ������ ���:��):");
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
		System.out.println("����� ������");
	}
		else{
		System.out.println("����� �� ������� ��������!");
	}
	}else{
		System.out.println("����� �� ������� ������, ����-�� �� �� ������� ���������� �� �������� ���������");
	}
	}else if(seance.getStartTime().getHour()*60+seance.getStartTime().getMin()<600){
		System.out.println("ʳ������� �� �� ��������");
	}else if(seance.getStartTime().getHour()*60+seance.getStartTime().getMin()>1380){
		System.out.println("ʳ������� ��� �������");
	}
}
	 
	public void removeSeance() {
		see();
		System.out.println("������ ����� �� ������ ���� ����� ������:");
		String title = sca.next();
		System.out.println("������ ������� ������ (� ������ ���:��):");
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
			System.out.println("����� ��������.");
		}else{
			System.out.println("������ ������ �� ����!");
		}
		}
	public void see(){
		Iterator<Seance>seans = seances.iterator();
		while (seans.hasNext()) {
			Seance seance2 = seans.next();
			System.out.println("����� "+seance2.getMovie().getTitle()+", c���� ����� - "+seance2.getMovie().getDuration().getHour()+" ������ "+seance2.getMovie().getDuration().getMin()+
					" ������,  ������� o "+seance2.getStartTime().getHour()+":"+seance2.getStartTime().getMin()+" ����� o "+seance2.getEndTime().getHour()+":"+seance2.getEndTime().getMin());
			
		}
	}
	
}
