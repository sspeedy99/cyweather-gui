package cyweather;
import java.time.*;

abstract class Forecast {
	 public float currentTemprature;
	 public float maximumTemprature;
	 public float minimumTemprature;
	 public float averageTemprature;
	 public float humidity;
	 public float rainfall;
	 public String summary;
	 
	 public void getAvgTemp () {}
	 public void getAvgRain () {}
	 public void summ () {}
	 
}

public class DayForecast extends Forecast implements iFace {
	public LocalDate today;
	
	void setDate() {
		today = LocalDate.now();
	}
	
	public void getAvgTemp () {
		System.out.println("Average Temprature of the day is  :" + this.averageTemprature);
	}
	
	public void getAvgRain() {
		System.out.println("Average Rainfall of the day is  :" + this.rainfall);
	}
	
	public void summ() {
		System.out.println(this.summary);
	}
	
	public void showNow() {
		System.out.println("Good Morning, Here's your summary!");
		System.out.println("Today's date is :" + this.today);
		System.out.println("Current Temprature of the day is  :" + this.currentTemprature);
		System.out.println("Maximum Temprature of the day is  :" + this.maximumTemprature);
		System.out.println("Minimum Temprature of the day is  :" + this.minimumTemprature);
		System.out.println("Average Temprature of the day is  :" + this.averageTemprature);
		System.out.println("Humidity of the day is  :" + this.humidity);
		System.out.println("Average Rainfall of the day is  :" + this.rainfall);
		summ();
	
	}
}