package samsung.java.socket.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import samsung.java.socket.view.IServerUI;
import samsung.java.socket.view.ServerUI;

public class ServerController {

    private static IServerUI serverUI;
    private static int status = -1;
    private static final int START = 1;
    private static final int STOP = 0;
    private static MainUIController mainUI;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                serverUI = new ServerUI(); // Let the constructor do the job
                serverUI.setStartActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TODO Auto-generated method stub
                        int serverPort = serverUI.getServerPort();
                        if (isError(serverPort)) {
                            System.err.println("Error!");
                        } else {
                            Thread serverStart = new Thread() {
                                @Override
                                public void run() {
                                    try (ServerSocket servSocket = new ServerSocket(serverPort)) {
                                        mainUI = new MainUIController();
                                        status = START;
                                        while (true) {
                                            Socket connSocket = servSocket.accept();
                                            System.out.println("Accepted client: "
                                                    + connSocket.getInetAddress().getHostAddress());
                                            try (BufferedReader in = new BufferedReader(new InputStreamReader(connSocket.getInputStream()));
                                                    PrintWriter out = new PrintWriter(new OutputStreamWriter(connSocket.getOutputStream()))) {
                                                String message;
                                                while ((message = in.readLine()) != null) {
                                                    System.out.println("Receive from client: " + message);
                                                    out.println(message);
                                                    out.flush();
                                                }
                                                System.out.println("Client has stopped sending data!");
                                            } catch (IOException ioe) {
                                                ioe.printStackTrace();
                                            }
                                        }
                                    } catch (IOException ioe) {
                                        ioe.printStackTrace();
                                    }
                                }

                            };
                            serverStart.start();
                        }

                    }
                });
                serverUI.setStopActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TODO Auto-generated method stub
                        status = STOP;
                        serverUI.closeForm();
                        // Loi tat mainUI --> tat Server
                    }
                });
            }
        });
//        serverUI = new ServerUI(); // Let the constructor do the job

    }

    public static boolean isError(int port) {
        if (port == 0) {
            JOptionPane.showMessageDialog(null, " Please fill server address");
            return true;
        } else if (port == -1) {
            JOptionPane.showMessageDialog(null, " Please fill server port again ");
            return true;
        }
        return false;
    }
}
