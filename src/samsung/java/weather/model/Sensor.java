package samsung.java.weather.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.StringTokenizer;


public class Sensor extends Thread implements ISensor{
	private String sensorID;
	private double longitude;
	private double latitude;
	private int numberResults = 0;
	public Sensor(String sensorID, double longitude, double latitude){
		setSensorID(sensorID);
		setLongitude(longitude);
		setLatitude(latitude);
	}
	public void start(){
		super.start();
	}
	@Override
	public void run(){
		// Cho nay se co vong lap. Sau 1 khoang thoi gian duoc cai dat se sinh ra gia tri moi 
//		va goi writeFile
		while(1 != 0){
			try {
				sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss|yyyy-MM-dd");
			Date date = new Date();
			String time = timeFormat.format(date);
			Random rd = new Random();
			double tempMin = 5;
			double tempMax = 45;
			Double temperatureValue = tempMin + (tempMax - tempMin)*rd.nextDouble();
			double humidityMin = 50;
			double humidityMax = 100;
			Double humidityValue = humidityMin + (humidityMax - humidityMin)*rd.nextDouble();
			String temperature = temperatureValue.toString().substring(0, 5);
			String humidity = humidityValue.toString().substring(0, 5);
			String data = time + "|"+ temperature + "|" +humidity;
			writeFile(data);
		}
		
	}
	public int getNumberResults(){
		int n = this.numberResults;
		this.numberResults = 0;
		return n;
		
	}
	@Override
	public String[][] readFile(String sensorID){
		String[][] rowData = new String[1000][4];
		try(FileReader fr = new FileReader(ISensorList.SENSOR_DIRECTORY+sensorID+".txt")){
			BufferedReader br = new BufferedReader(fr);
			String line ;
			StringTokenizer tk;
			try{
				while ((line = br.readLine()) != null ){
					tk = new StringTokenizer(line,"|");
					for (int  j = 0 ; j <= 3; j++){
						rowData[this.numberResults][j] = tk.nextToken();
					}
					this.numberResults++;
				}
			}
			catch (RuntimeException re){
				System.out.println(re.getMessage());
			}
			br.close();
		}
		catch(IOException ioe){
			System.out.println(ioe.getMessage());
		}
		return rowData;
	}
	public void writeFile(String data){
		try(FileWriter fw = new FileWriter(ISensorList.SENSOR_DIRECTORY+ getSensorID() +".txt",true)){
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(data);
			bw.newLine();
			bw.close();
		} catch( IOException ioe){
			System.out.println(ioe.getMessage());
		}
	}
	public String getSensorID() {
		return sensorID;
	}
	public void setSensorID(String sensorID) {
		if (sensorID.length() == 4 )
			this.sensorID = sensorID;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
}
