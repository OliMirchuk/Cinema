package pack;

public class Seance {
	private Movie movie;
	private Time startTime;
	private Time endTime;
	
	public Seance(Movie movie, Time startTime) {
		super();
		this.movie = movie;
		if((startTime.getHour()*60+startTime.getMin())<600){
			System.out.println("Кінотеатр ще не відкрито.");
		}else if((startTime.getHour()*60+startTime.getMin())>1380){
			System.out.println("Кінотеатр уже закрито.");
		}else{
		this.startTime = startTime;
		}
		int time = movie.getDuration().getMin()+startTime.getMin()
		+((movie.getDuration().getHour()+startTime.getHour())*60);
		int hour = time/60;
		int min = time%60;
		this.endTime = new Time(hour, min);
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Time getStartTime() {
		return startTime;
	}
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	public Time getEndTime() {
		return endTime;
	}
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
	@Override
	public String toString() {
		return "movie=" + movie + ", startTime=" + startTime + ", endTime=" + endTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((movie == null) ? 0 : movie.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seance other = (Seance) obj;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (movie == null) {
			if (other.movie != null)
				return false;
		} else if (!movie.equals(other.movie))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		return true;
	}
	
	
}
