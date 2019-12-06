package cyweather;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

interface iFace {
	
	void showNow();
}



abstract class State {
	public double latitude = Seed.lattitude;
	public double longitude = Seed.longitude;
	
	
}

public class City extends State implements iFace {
	String cityName;
	public static boolean flag = false;
	
	
	void setCity() {
		System.out.println("Enter the city, you want to search!");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		this.cityName = input;
	}
	
	public void showNow() {
		System.out.println("Latitude of the city " + this.latitude);
		System.out.println("Longitude of the city " + this.longitude);
		System.out.println("Name of the city " + this.cityName);
	}
	
	void getCity(String city) throws IOException {
		File file = new File("Cities.txt");
		String [] words = null;
		FileReader f1 = new FileReader(file);
		BufferedReader br = new BufferedReader(f1);
		String s;
		boolean flag = false;
		while((s=br.readLine())!=null) {
			words = s.split(" ");
			for (String word : words) {
				if(word.equals(city)) {
					flag = true;
					break;
				}
			}
		}
		
		if(flag) {
			System.out.println("The city found, starting execution");
			this.cityName = city;
			Seed.seedForecast(this.cityName);
		} else {
			System.out.println("City not found!");
		}
		
	}
}

