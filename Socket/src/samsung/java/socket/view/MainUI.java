package samsung.java.socket.view;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;

/**
 *
 * @author Dao Nam Tien
 *
 */
@SuppressWarnings("serial")
public class MainUI extends JFrame implements IMainUI {

    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem changeTime;
    private JMenuItem newSensor;
    private JMenuItem exitProgram;
    private JMenuItem recordingWeather;
    private JComboBox<String> boxSensor = new JComboBox<String>();
    private static JPanel panel;
    private JButton btnShowFile = new JButton();

    public MainUI() {
        LookAndFeel old = UIManager.getLookAndFeel();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Throwable ex) {
            old = null;
        }
//        menuBar = new JMenuBar();
        /**
         * File menu
         */
//        menu = new JMenu("File");
//        menu.setMnemonic(KeyEvent.VK_F);
//        menuBar.add(menu);
//        newSensor = new JMenuItem(" New Sensor ", KeyEvent.VK_N);
//        menu.add(newSensor);
//        menuBar.add(menu);
//        exitProgram = new JMenuItem(" Exit ");
//        menu.add(exitProgram);
//        menuBar.add(menu);

        /**
         * Edit Menu
         */
//        menu = new JMenu(" Edit ");
//        menu.setMnemonic(KeyEvent.VK_E);
//        menuBar.add(menu);
//        changeTime = new JMenuItem(" Change time-updating table", KeyEvent.VK_C);
//        menu.add(changeTime);
//        menuBar.add(menu);

        /**
         * View Menu
         */
//        menu = new JMenu(" View ");
//        menu.setMnemonic(KeyEvent.VK_V);
//        menuBar.add(menu);
//        recordingWeather = new JMenuItem("View weather");
//        menu.add(recordingWeather);
//        menuBar.add(menu);
//        menuBar.add(menu);

        /**
         *
         */
//        boxSensor = new JComboBox<>();
//        panel.add(boxSensor);
//        boxSensor.setBounds(40, 35, 80, 20);
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 10, 600, 450);
        ////
        btnShowFile = new JButton(" Show data ");
        JLabel label = new JLabel("Select a sensor");
        ////

        panel.add(btnShowFile);
        panel.add(label);
        ////

        btnShowFile.setBounds(150, 20, 100, 40);
        label.setBounds(40, 15, 100, 20);
        /**
         * Table data
         */
        String colName[] = {"Time", "Date", "Temperature", "Humidity"};
        String rowData[][] = {{" ", " ", " ", " "}};
        JTable table = new JTable(rowData, colName);
        table.getTableHeader().setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 14));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(40, 65, 500, 350);

        /**
         * Edit JFrame
         */
        panel.add(scrollPane);
        Container cp = this.getContentPane();
        cp.add(panel);
        validate();
        setJMenuBar(menuBar);
        setTitle(" Weather Sensor ");
        setSize(600, 480);
        setResizable(false);
        setIconImage(getIconImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * (non-Javadoc)
     *
     * @see samsung.java.weather.view.IMainUI#viewWeather(JComboBox)
     */
    @Override
    public void viewWeather(JComboBox<String> boxSensor) {
//        this.boxSensor = boxSensor;
//        panel.add(boxSensor);
//        boxSensor.setBounds(40, 35, 80, 20);
//        Container cp = this.getContentPane();
//        cp.setVisible(true);

    }

    /**
     * (non-Javadoc)
     *
     * @see samsung.java.weather.view.IMainUI#showTable(String[], String[][])
     */
    @Override
    public void showTable(String colName[], String rowData[][]) {
        panel.remove(2);
        JTable table = new JTable(rowData, colName);
        table.setEnabled(false);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(40, 65, 500, 350);
        panel.add(scrollPane);
        table.repaint();
        validate();
    }

    /**
     * (non-Javadoc)
     *
     * @see samsung.java.weather.view.IMainUI#getBoxSensor()
     */
    @Override
    public JComboBox<String> getBoxSensor() {
        return this.boxSensor;
    }


    /**
     * (non-Javadoc)
     *
     * @see samsung.java.weather.view.IMainUI#closeForm()
     */
    @Override
    public void closeForm() {
        super.dispose();
    }
   
}
