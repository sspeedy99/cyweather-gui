package cyweather;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Users {
	public static int userId;
	public static String userName;
	public static String userCity;
	
	public static void writeIntoFile() throws IOException{
		FileWriter fw = new FileWriter("Users.txt");
		fw.write(userId);
		fw.write(userName);
		fw.write(userCity);
		fw.close();
	}
	
	public static void setDetails() throws IOException {
		userId = 1;
		userName = Frame1.userName;
		userCity = Frame1.userCity;
		writeIntoFile();
		
	}
	
	/*public void showNow() {
		System.out.println("ID assigned  is :" + this.userId);
		System.out.println("User Name  is :" + this.userName);
		System.out.println("User city is :" + this.userCity);
	}*/
	
}
