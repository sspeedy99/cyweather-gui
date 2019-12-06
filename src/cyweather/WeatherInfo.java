package cyweather;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.time.*;

@SuppressWarnings("serial")

public class WeatherInfo extends JFrame {

	private JPanel contentPane;
	private JTextField textField_latitude;
	private JTextField textField_longitude;
	private JTextField textField_currTemp;
	private JTextField textField_maxTemp;
	private JTextField textField_humid;
	private JTextField textField_avgTemp;
	private JTextField textField_minTemp;
	private JTextField textField_avgRain;
	private JTextField textField_date;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					WeatherInfo frame = new WeatherInfo();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public WeatherInfo(DayForecast df) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1082, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("         CyWeather");
		lblNewLabel.setForeground(SystemColor.activeCaptionText);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel.setBounds(341, 13, 436, 98);
		getContentPane().add(lblNewLabel);
		
		JLabel lblLatitude = new JLabel("Latitude");
		lblLatitude.setForeground(Color.BLACK);
		lblLatitude.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblLatitude.setBounds(138, 185, 126, 38);
		contentPane.add(lblLatitude);
		
		JLabel lblTodaysDate = new JLabel("Today's Date");
		lblTodaysDate.setForeground(Color.BLACK);
		lblTodaysDate.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblTodaysDate.setBounds(429, 124, 153, 38);
		contentPane.add(lblTodaysDate);
		
		JLabel lblLongitude = new JLabel("Longitude");
		lblLongitude.setForeground(Color.BLACK);
		lblLongitude.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblLongitude.setBounds(714, 185, 126, 38);
		contentPane.add(lblLongitude);
		
		JLabel lblHumidity = new JLabel("Avg Temp");
		lblHumidity.setForeground(Color.BLACK);
		lblHumidity.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblHumidity.setBounds(714, 269, 126, 38);
		contentPane.add(lblHumidity);
		
		JLabel lblMinTemp = new JLabel("Min Temp");
		lblMinTemp.setForeground(Color.BLACK);
		lblMinTemp.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblMinTemp.setBounds(714, 339, 126, 38);
		contentPane.add(lblMinTemp);
		
		JLabel lblAvgRain = new JLabel("Avg Rain");
		lblAvgRain.setForeground(Color.BLACK);
		lblAvgRain.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblAvgRain.setBounds(714, 405, 126, 38);
		contentPane.add(lblAvgRain);
		
		JLabel lblRealFeal = new JLabel("Real Feal");
		lblRealFeal.setForeground(Color.BLACK);
		lblRealFeal.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblRealFeal.setBounds(138, 269, 126, 38);
		contentPane.add(lblRealFeal);
		
		JLabel lblMaxTemp = new JLabel("Max Temp");
		lblMaxTemp.setForeground(Color.BLACK);
		lblMaxTemp.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblMaxTemp.setBounds(138, 339, 126, 38);
		contentPane.add(lblMaxTemp);
		
		JLabel lblHumidity_1 = new JLabel("Humidity");
		lblHumidity_1.setForeground(Color.BLACK);
		lblHumidity_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblHumidity_1.setBounds(138, 405, 126, 38);
		contentPane.add(lblHumidity_1);
		
		textField_latitude = new JTextField();
		textField_latitude.setColumns(10);
		textField_latitude.setBounds(252, 185, 190, 51);
		textField_latitude.setText(Double.toString(df.latitude));
		textField_latitude.setEditable(false);
		
		contentPane.add(textField_latitude);
		
		textField_longitude = new JTextField();
		textField_longitude.setColumns(10);
		textField_longitude.setBounds(828, 182, 183, 51);
		textField_longitude.setText(Double.toString(df.longitude));
		textField_longitude.setEditable(false);
		contentPane.add(textField_longitude);
		
		textField_currTemp = new JTextField();
		textField_currTemp.setColumns(10);
		textField_currTemp.setBounds(252, 269, 190, 51);
		textField_currTemp.setText(Double.toString(df.currentTemprature));
		textField_currTemp.setEditable(false);
		contentPane.add(textField_currTemp);
		
		textField_maxTemp = new JTextField();
		textField_maxTemp.setColumns(10);
		textField_maxTemp.setBounds(252, 336, 190, 51);
		textField_maxTemp.setText(Double.toString(df.maximumTemprature));
		textField_maxTemp.setEditable(false);
		contentPane.add(textField_maxTemp);
		
		textField_humid = new JTextField();
		textField_humid.setColumns(10);
		textField_humid.setBounds(252, 405, 190, 51);
		textField_humid.setText(Long.toString(df.humidity));
		textField_humid.setEditable(false);
		contentPane.add(textField_humid);
		
		textField_avgTemp = new JTextField();
		textField_avgTemp.setColumns(10);
		textField_avgTemp.setBounds(828, 256, 190, 51);
		textField_avgTemp.setText(Double.toString(df.averageTemprature));
		textField_avgTemp.setEditable(false);
		contentPane.add(textField_avgTemp);
		
		textField_minTemp = new JTextField();
		textField_minTemp.setColumns(10);
		textField_minTemp.setBounds(828, 339, 190, 51);
		textField_minTemp.setText(Double.toString(df.minimumTemprature));
		textField_minTemp.setEditable(false);
		contentPane.add(textField_minTemp);
		
		textField_avgRain = new JTextField();
		textField_avgRain.setColumns(10);
		textField_avgRain.setBounds(828, 405, 190, 51);
		textField_avgRain.setText(Double.toString(df.rainfall));
		textField_avgRain.setEditable(false);
		contentPane.add(textField_avgRain);
		
		textField_date = new JTextField();
		textField_date.setColumns(10);
		textField_date.setBounds(581, 113, 228, 51);
		textField_date.setText(df.today.toString());
		textField_date.setEditable(false);
		contentPane.add(textField_date);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Asus\\Desktop\\cyWeather\\screen-0.jpg"));
		lblNewLabel_1.setBounds(0, 0, 1064, 532);
		getContentPane().add(lblNewLabel_1);
	}
	

}
