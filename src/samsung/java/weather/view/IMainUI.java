package samsung.java.weather.view;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;


public interface IMainUI {
	public void setExitActionListener(ActionListener listener);
	public void setChangeTimeActionListener(ActionListener listener);
	public void setNewSensorActionListener(ActionListener listener);
	public void setViewWeatherActionListener(ActionListener listener);
	public void viewWeather(JComboBox<String> boxSensor);
	public JComboBox<String> getBoxSensor();
	public void showTable(String colName[], String rowData[][]);
	public void setFileActionListener(ActionListener listener);
	public void closeForm();
	public void setItemChangedListener(ItemListener listener);
}
