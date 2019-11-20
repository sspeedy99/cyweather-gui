package cyweather;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

interface iFace {
	
	void showNow();
}

class CityNotFoundException extends Exception {
	int errorCode;
	String errorMsg;
	
	public CityNotFoundException() {
		this.errorCode = 101;
		this.errorMsg = "The city cannot be found!";
	}	
	
}

abstract class State {
	public int latitude;
	public int longitude;
	
	
	public State(int lat, int longi) {
		this.latitude = lat;
		this.longitude = longi;
	}
}

public class City extends State implements iFace {
	String cityName;
	
	public City(int lat, int longi, String cityName) {
		super(lat, longi);
		this.cityName = cityName;
	}
	
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
		} else {
			System.out.println("City not found!");
		}
		
	}
}

