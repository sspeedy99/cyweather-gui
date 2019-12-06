package cyweather;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Button;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

@SuppressWarnings("unused")

public class Frame1 {

	private JFrame frame;
	private  JTextField textFieldName;
	private  JTextField textFieldUserCity;
	private JTextField textFieldCityToSeach;
	
	public static String userName;
	public static String userCity;
	public static String searchCity;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.setBounds(100, 100, 1082, 579);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnSubmt = new JButton("Submit");
		btnSubmt.setForeground(new Color(0, 0, 0));
		btnSubmt.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnSubmt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				City city = new City();
				
				userName = textFieldName.getText();
				userCity = textFieldUserCity.getText();
				searchCity = textFieldCityToSeach.getText();
				try {
				Users.setDetails();
				city.getCity(searchCity);
				DayForecast df = new DayForecast();
				df.setDate();
				df.showNow();
				frame.dispose();
				WeatherInfo wetInf = new WeatherInfo(df);
				wetInf.setVisible(true);
				//JOptionPane.showMessageDialog(null, "All fields are working");
				} catch (Exception e) 
				{ JOptionPane.showMessageDialog(null, "Something went wrong, please try again later"); }
				
			}
		});
		btnSubmt.setBounds(432, 426, 256, 51);
		frame.getContentPane().add(btnSubmt);
		
		JLabel lblNewLabelUser = new JLabel("Your Name");
		lblNewLabelUser.setForeground(SystemColor.activeCaptionText);
		lblNewLabelUser.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabelUser.setBounds(317, 204, 126, 38);
		frame.getContentPane().add(lblNewLabelUser);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(522, 191, 276, 51);
		frame.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblYourCity = new JLabel("Your City");
		lblYourCity.setForeground(SystemColor.activeCaptionText);
		lblYourCity.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblYourCity.setBounds(317, 258, 126, 38);
		frame.getContentPane().add(lblYourCity);
		
		textFieldUserCity = new JTextField();
		textFieldUserCity.setColumns(10);
		textFieldUserCity.setBounds(522, 255, 276, 51);
		frame.getContentPane().add(textFieldUserCity);
		
		JLabel lblNewLabel = new JLabel("         CyWeather");
		lblNewLabel.setForeground(SystemColor.activeCaptionText);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel.setBounds(385, 26, 436, 98);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblSearchCity = new JLabel("Search City");
		lblSearchCity.setForeground(Color.BLACK);
		lblSearchCity.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblSearchCity.setBounds(317, 324, 126, 38);
		frame.getContentPane().add(lblSearchCity);
		
		textFieldCityToSeach = new JTextField();
		textFieldCityToSeach.setColumns(10);
		textFieldCityToSeach.setBounds(522, 321, 276, 51);
		frame.getContentPane().add(textFieldCityToSeach);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Asus\\Desktop\\cyWeather\\screen-0.jpg"));
		lblNewLabel_1.setBounds(0, 0, 1064, 532);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
