package cyweather;
import java.io.IOException;
import java.util.Scanner;


public class Weather {
	public static void main(String [] args) {
		//System.out.println("hello");
		City city = new City();
		Users user = new Users();
		try {
			user.setDetails();
			user.showNow();
			} catch (IOException e) {
			System.out.println(e);
			}
		
		try {
		System.out.println("Enter the city to find its weather");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		city.getCity(input);
	}
		catch (IOException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		DayForecast df = new DayForecast();
		df.setDate();
		city.showNow();
		df.showNow();
		
		
	}
}

