package samsung.java.weather.model;

public interface ISensorList {
	public final String SENSOR_DIRECTORY = "src/samsung/java/database/";
	public final String SENSOR_FILE = "src/samsung/java/database/SensorList.txt";
//	private int timeUpdating = 10;
//	public void setTimeUpdating(int time);
	public boolean addSensor(ISensor sensor);
	public boolean checkID(String sensorID);
	public boolean checkPosition(double latitude, double longitude);
	public int getNumberOfSensors();
	public ISensor[] getSensorList();
}
