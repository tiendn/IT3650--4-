package samsung.java.weather.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import samsung.java.weather.model.ISensor;
import samsung.java.weather.model.ISensorList;
import samsung.java.weather.model.SensorList;
import samsung.java.weather.view.IMainUI;
import samsung.java.weather.view.MainUI;

public class MainUIController {
	private IMainUI mainUI;
	private ISensorList ssList;
	private String[] currentSensorID ;
	private int numberThreadTable = 0;

	/**
	 * 
	 */
	public MainUIController() {
		mainUI = new MainUI();
		ssList = new SensorList();
		ISensor[] sensorList = ssList.getSensorList();
		currentSensorID = new String[ssList.getNumberOfSensors()+1];
		Thread[] tableThread = new Thread[ssList.getNumberOfSensors()+1];
		mainUI.setViewWeatherActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
				JComboBox<String> list = new JComboBox<>();
				for (int i = 0; i < ssList.getNumberOfSensors(); i++) {
					model.addElement(sensorList[i].getSensorID());
				}
				list.setModel(model);
				mainUI.viewWeather(list);
			}
		});
		mainUI.setExitActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainUI.closeForm();
			}
		});
		mainUI.setNewSensorActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new NewSensorFormController();
				mainUI.closeForm();
			}
		});
		mainUI.setChangeTimeActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String timeUpdate = JOptionPane
						.showInputDialog("Enter new time-updating : ");
				System.out.println(timeUpdate);
				// Set time ..
			}
		});
		mainUI.setFileActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
//				numberThreadTable++;
//				currentSensorID[numberThreadTable] = (String)selected;
				String colName[] = { "Time", "Date", "Temperature", "Humidity" };
				JComboBox<String> comboBox = mainUI.getBoxSensor();
				String sensorID = (String) comboBox.getSelectedItem();
				if (numberThreadTable >= 1)
				{
					for (int i = 1; i <= numberThreadTable ; i++ ){
						if (!sensorID.equals(currentSensorID[i])){
							// Cap nhat them sensor ID 
							if (numberThreadTable < ssList.getNumberOfSensors()){
								currentSensorID[++numberThreadTable] = sensorID;
								// Tao luong cho id do'
								tableThread[numberThreadTable] = new Thread(){
									@Override
									public void run(){
									while(1 != 0){
//										JComboBox<String> comboBox = mainUI.getBoxSensor();
//										Object selected = comboBox.getSelectedItem();
										for (int i = 0; i < ssList.getNumberOfSensors(); i++) {
											if (sensorID.equals(sensorList[i].getSensorID())) {
												String[][] buffer = sensorList[i].readFile(sensorList[i].getSensorID());
												int n = sensorList[i].getNumberResults();
												String[][] rowData = new String[n+1][4];
												for (int j = 0 ; j <= n ; j++){
													for (int k = 0 ; k <= 3 ; k ++)
														rowData[j][k] = buffer[j][k];
												}
												mainUI.showTable(colName, rowData);
												break;
											}
										}
											try {
												sleep(10000);
											} catch (InterruptedException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
										}
									}
								};
								tableThread[numberThreadTable].start();
							}
							
								
						} 
						else{
							// Neu luong da duoc chay tu truoc
							
							while(1 != 0){
//								String colName[] = { "Time", "Date", "Temperature", "Humidity" };
//								JComboBox<String> comboBox2 = mainUI.getBoxSensor();
//								String sensorID = (String) comboBox2.getSelectedItem();
								for (int i2 = 0; i2 < ssList.getNumberOfSensors(); i2++) {
									if (sensorID.equals(sensorList[i2].getSensorID())) {
										
										String[][] buffer = sensorList[i2].readFile(sensorList[i2].getSensorID());
										int n = sensorList[i2].getNumberResults();
										String[][] rowData = new String[n+1][4];
										for (int j = 0 ; j <= n ; j++){
											for (int k = 0 ; k <= 3 ; k ++)
												rowData[j][k] = buffer[j][k];
										}
										mainUI.showTable(colName, rowData);
										break;
									}
								}
								for (int j = 1 ; j<= numberThreadTable ; j++){
									if (sensorID.equals(tableThread[j].getName())){
										try {
											tableThread[j].sleep(10000);
										} catch (InterruptedException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
									}
								}
										
								}
					}
							break;
						}
					
						} else {
							// Neu chua co luong nao
//							JComboBox<String> comboBox = mainUI.getBoxSensor();
//							Object selected = comboBox.getSelectedItem();
							currentSensorID[++numberThreadTable] = sensorID; 
							tableThread[numberThreadTable] = new Thread(){
								@Override
								public void run(){
								while(1 != 0){
									String colName[] = { "Time", "Date", "Temperature", "Humidity" };
									JComboBox<String> comboBox = mainUI.getBoxSensor();
									Object selected = comboBox.getSelectedItem();
									for (int i = 0; i < ssList.getNumberOfSensors(); i++) {
										if (selected.equals(sensorList[i].getSensorID())) {
											String[][] buffer = sensorList[i].readFile(sensorList[i].getSensorID());
											int n = sensorList[i].getNumberResults();
											String[][] rowData = new String[n+1][4];
											for (int j = 0 ; j <= n ; j++){
												for (int k = 0 ; k <= 3 ; k ++)
													rowData[j][k] = buffer[j][k];
											}
											mainUI.showTable(colName, rowData);
											break;
										}
									}
										try {
											sleep(10000);
										} catch (InterruptedException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
									}
								}
							};
							tableThread[numberThreadTable].start();
						}
				}
				
				
		}); 
		mainUI.setItemChangedListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				Thread thread = new Thread(){
					@Override
					public void run(){
					while(1 != 0){
						JOptionPane.showMessageDialog(null, "fdgfdgd");
						mainUI.getBoxSensor();
						
						String colName[] = { "Time", "Date", "Temperature", "Humidity" };
						JComboBox<String> comboBox = mainUI.getBoxSensor();
						Object selected = comboBox.getSelectedItem();
						for (int i = 0; i < ssList.getNumberOfSensors(); i++) {
							if (selected.equals(sensorList[i].getSensorID())) {
								String[][] buffer = sensorList[i].readFile(sensorList[i].getSensorID());
								int n = sensorList[i].getNumberResults();
								String[][] rowData = new String[n+1][4];
								for (int j = 0 ; j <= n ; j++){
									for (int k = 0 ; k <= 3 ; k ++)
										rowData[j][k] = buffer[j][k];
								}
								mainUI.showTable(colName, rowData);
								break;
							}
						}
							try {
								sleep(10000);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				};
				thread.start();
			}
		}); 
	}
}
