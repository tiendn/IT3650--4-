package samsung.java.weather.model;

public interface ISensor {
	public String getSensorID();
	public void setSensorID(String sensorID);
	public double getLongitude();
	public void setLongitude(double longitude);
	public double getLatitude();
	public void setLatitude(double latitude);
	public void start();
	public String[][] readFile(String sensorID);
	public int getNumberResults();
}
