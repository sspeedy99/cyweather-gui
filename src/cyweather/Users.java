package cyweather;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Users implements iFace {
	public int userId;
	public String userName;
	public String userCity;
	
	public void writeIntoFile() throws IOException{
		FileWriter fw = new FileWriter("Users.txt");
		fw.write(this.userId);
		fw.write(this.userName);
		fw.write(this.userCity);
		fw.close();
	}
	
	public void setDetails() throws IOException {
		this.userId = 1;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your name");
		this.userName = scan.nextLine();
		System.out.println("Enter your city");
		this.userCity = scan.nextLine();
		writeIntoFile();
		
	}
	
	public void showNow() {
		System.out.println("ID assigned  is :" + this.userId);
		System.out.println("User Name  is :" + this.userName);
		System.out.println("User city is :" + this.userCity);
	}
	
}
