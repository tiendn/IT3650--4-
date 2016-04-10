package samsung.java.socket.view;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
/**
 * 
 * @author Dao Nam Tien
 * The New Sensor Form class inheriting the JFrame displays the new sensor form
 */
@SuppressWarnings("serial")
public class NewSensorForm extends JFrame implements INewSensorForm{
	private JTextField tfSensorID;
	private JTextField tfLongitude;
	private JTextField tfLatitude;
	private JButton btnStart;
	private JButton btnStop;
	private JButton btnCancel;
	/**
	 * The constructor show new sensor Form and get Data sent to The Controller
	 * 
	 */
	public NewSensorForm(){
		LookAndFeel old = UIManager.getLookAndFeel();
	    try {
	       UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    } 
	    catch (Throwable ex) {
	       old = null;
	    } 
	    JLabel lbSensorID = new JLabel(" Sensor ID ");
	    JLabel lbLatitude = new JLabel(" Latitude ");
	    JLabel lbLongitude = new JLabel(" Longitude ");
	    this.tfSensorID = new JTextField(4);
	    this.tfLatitude = new JTextField(16);
	    this.tfLongitude = new JTextField(16);
	    this.btnStart = new JButton(" Start ");
	    this.btnStop = new JButton(" Stop ");
		this.btnCancel = new JButton("Cancel");
		JPanel panelInfor = new JPanel(new GridLayout(4,2,10,5));
		panelInfor.add(lbSensorID);
		panelInfor.add(tfSensorID);
		panelInfor.add(lbLongitude);
		panelInfor.add(tfLongitude);
		panelInfor.add(lbLatitude);
		panelInfor.add(tfLatitude);
		JPanel panelButton = new JPanel(new GridLayout(1,3,10,5));
		panelButton.add(btnStart);
		panelButton.add(btnStop);
		panelButton.add(btnCancel);
		
		Container cp = this.getContentPane();
		FlowLayout f = new FlowLayout(FlowLayout.LEFT);
		cp.setLayout(f);
		cp.add(btnStart);
//		cp.se
		cp.add(panelInfor);
		panelInfor.setBounds(5, 5, 200, 200);
		cp.add(panelButton);
		panelButton.setBounds(5, 210, 200, 50);
		setTitle(" Create new sensor ");
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	/**
	 * (non-Javadoc)
	 * @see samsung.java.weather.view.INewSensorForm#getSensorID()
	 */
	@Override
	public String getSensorID(){
		return tfSensorID.getText();
	}
	/**
	 * (non-Javadoc)
	 * @see samsung.java.weather.view.INewSensorForm#getLatitude()
	 */
	@Override
	public double getLatitude(){
		double latitude = -1;
		if (!tfLatitude.getText().equals("")){
			try{
				latitude = Double.parseDouble(tfLatitude.getText());
			}
			catch(NumberFormatException nfe){
				System.out.println(nfe.getMessage());
			}
		}
		else {
			return 0;
		}
		
		return latitude;
	}
	/**
	 * (non-Javadoc)
	 * @see samsung.java.weather.view.INewSensorForm#getLongitude()
	 */
	@Override
	public double getLongitude(){
		double longitude = -1;
		if (!tfLatitude.getText().equals("")){
			try{
				longitude = Double.parseDouble(tfLongitude.getText());
			}
			catch(NumberFormatException nfe){
				System.out.println(nfe.getMessage());
			}
		}
		else {
			return 0;
		}
		
		return longitude;
	}
	/**
	 * (non-Javadoc)
	 * @see samsung.java.weather.view.INewSensorForm#setCancelButtonActionListener(ActionListener)
	 */
	@Override
	public void setCancelButtonActionListener(ActionListener listener){
		this.btnCancel.addActionListener(listener);
	}
	/**
	 * (non-Javadoc)
	 * @see samsung.java.weather.view.INewSensorForm#setCreateButtonActionListener(ActionListener)
	 */
	@Override
	public void setCreateButtonActionListener(ActionListener listener){
//		this.btnOK.addActionListener(listener);
	}	
	/**
	 * (non-Javadoc)
	 * @see samsung.java.weather.view.INewSensorForm#closeForm()
	 */
	@Override
	public void closeForm(){
		super.dispose();
	}
}
