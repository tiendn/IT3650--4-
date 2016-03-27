package samsung.java.weather.view;

import java.awt.event.ActionListener;

public interface INewSensorForm {
	
	/**
	 * 
	 * @param listener
	 */
	public void setCancelButtonActionListener(ActionListener listener);
	/**
	 * 
	 * @param listener
	 */
	public void setCreateButtonActionListener(ActionListener listener);
	/**
	 * 
	 * @return
	 */
	public double getLatitude();
	/**
	 * 
	 * @return
	 */
	public double getLongitude();
	/**
	 * 
	 * @return
	 */
	public String getSensorID();
	/**
	 * 
	 */
	public void closeForm();
}
