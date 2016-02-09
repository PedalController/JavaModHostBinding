package br.com.srmourasilva.modhostbinding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

// http://www.devmedia.com.br/java-socket-entendendo-a-classe-socket-e-a-serversocket-em-detalhes/31894
public class Connection {
	
	private static int PORT = 5555;

	private Socket client;

	private PrintStream sendStream;
	private BufferedReader receivedReader;

	public Connection() {
		this(PORT);
	}

	public Connection(int socketPort) {
		try {
			this.client = new Socket("localhost", socketPort);
			this.sendStream = new PrintStream(client.getOutputStream());
			this.receivedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public String send(String message) {
		try {
			sendStream.print(message);
			String received = readDataReturn(receivedReader);
			System.out.println("Sended: " + message);
			System.out.println("Received: " + received);
			
			return received;

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private String readDataReturn(BufferedReader reader) throws IOException {
		char[] buffer = new char[1024];
		int read = 0;
		StringBuilder sb = new StringBuilder();
		
		while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
		    sb.append(buffer, 0, read);
		    break;
		}

		return sb.toString().trim();
	}
}
