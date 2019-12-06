package cyweather;
import java.time.*;


abstract class Forecast {
	 public double currentTemprature = Seed.currentTemp;
	 public double maximumTemprature = Seed.maximumTemp;
	 public double minimumTemprature = Seed.minimumTemp;
	 public double averageTemprature = Seed.averageTemp;
	 public long humidity = Seed.humid;
	 public double rainfall = Seed.rain;
	 public double latitude = Seed.lattitude;
	 public double longitude = Seed.longitude;
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
		System.out.println("Current Temprature of the day is  :" + this.currentTemprature + "C");
		System.out.println("Maximum Temprature of the day is  :" + this.maximumTemprature + "C");
		System.out.println("Minimum Temprature of the day is  :" + this.minimumTemprature + "C");
		System.out.println("Average Temprature of the day is  :" + this.averageTemprature + "C");
		System.out.println("Humidity of the day is  :" + this.humidity + "%");
		System.out.println("Average Rainfall of the day is  :" + this.rainfall + "mm");
		summ();
	
	}
}