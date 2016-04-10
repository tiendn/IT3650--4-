package samsung.java.socket.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;

import samsung.java.socket.view.ClientUI;
import samsung.java.socket.view.IClientUI;

public class ClientController {

    private static IClientUI clientUI;

    public static void main(String[] args) {
        clientUI = new ClientUI();
        clientUI.setConnectActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                Socket clientSocket = null;
                try {
                    String serverAddress = clientUI.getServerAddress();
                    int serverPort = clientUI.getServerPort();
                    System.out.println(serverPort);
                    if (isError(serverAddress, serverPort)) {
                        System.err.println("Error!");
                    } else {
                        // Loi nhap sai gia tri --> Die chuong trinh
                        clientSocket = new Socket(serverAddress, serverPort);
                        clientUI.close();
                        new NewSensorFormController();
                    }
//                    clientSocket.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }

            }
        });
        clientUI.setQuitActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                clientUI.close();
            }
        });
    }

    public static boolean isError(String address, int port) {
        if (address.equals("") && port == 0) {
            JOptionPane.showMessageDialog(null, " Please fill server address");
            return true;
        } else if (port == -1) {
            JOptionPane.showMessageDialog(null, " Please fill server port again ");
            return true;
        }
        return false;
    }
}
