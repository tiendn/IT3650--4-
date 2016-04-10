package tcpsocket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPEchoServer {
	public final static int DEFAULT_PORT = 5000;
	public static void main(String[] args) {
	try(ServerSocket servSocket = new
	ServerSocket(DEFAULT_PORT)){
	while (true){
	Socket connSocket = servSocket.accept();
	System.out.println("Accepted client: " + connSocket.getInetAddress().getHostAddress());
	try(BufferedReader in = new BufferedReader(new InputStreamReader(connSocket.getInputStream()));
	PrintWriter out = new PrintWriter(new
	OutputStreamWriter(connSocket.getOutputStream()))
	){
	
	String message;
	while((message = in.readLine()) != null){
	System.out.println("Receive from client:"
	+ message);
	out.println(message);
	out.flush();
	}
	System.out.println("Client has stopped sending data!");
	}catch (IOException e){
	System.out.println(e.getMessage());
	}
	}
	}catch (IOException e){
	System.out.println(e.getMessage());
	}
	}
	} 

