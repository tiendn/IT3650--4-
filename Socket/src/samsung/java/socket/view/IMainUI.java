package samsung.java.socket.view;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
public interface IMainUI {
	
	
	/**
	 * Set Enable Visible View Desktop
	 * @param boxSensor
	 */
	public void viewWeather(JComboBox<String> boxSensor);
	/**
	 * Get ComboBox
	 * @return
	 */
	public JComboBox<String> getBoxSensor();
	/**
	 * Show Table Data about the record.
	 * @param colName : Title
	 * @param rowData : Data
	 */
	public void showTable(String colName[], String rowData[][]);
	
	/**
	 * Close Main Form
	 */
	public void closeForm();
	
}
