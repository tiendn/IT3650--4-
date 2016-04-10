package samsung.java.socket.view;

import java.awt.event.ActionListener;

public interface INewSensorForm {
	
	/**
	 * ActionListener: Set quit recording
	 * @param listener
	 */
	public void setQuitButtonActionListener(ActionListener listener);
	/**
	 * ActionListener : Set start records data.
	 * @param listener
	 */
	public void setStartButtonActionListener(ActionListener listener);
        /**
         * ActionListener : Set stop records data.
         * @param listener 
         */
        public void setStopButtonActionListener(ActionListener listener);
	/**
	 * Get Sensor's Latitude value
	 * @return
	 */
	public double getLatitude();
	/**
	 * Get Sensor's Longitude value
	 * @return
	 */
	public double getLongitude();
	/**
	 * Get Sensor ID
	 * @return
	 */
	public String getSensorID();
        /**
         * Get Sensor Address
         * @return 
         */
        public String getSensorAddress();
	/**
	 * Close new Sensor Form
	 */
	public void closeForm();
}
