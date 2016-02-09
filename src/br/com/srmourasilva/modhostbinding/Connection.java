package br.com.srmourasilva.modhostbinding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

// http://www.devmedia.com.br/java-socket-entendendo-a-classe-socket-e-a-serversocket-em-detalhes/31894
public class Connection {
	
	private static int PORT = 5555;

	private Socket cliente;

	public Connection() {
		this(PORT);
	}

	public Connection(int socketPort) {
		try {
			this.cliente = new Socket("localhost", socketPort);

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public String send(String message) {
		try {
			PrintStream stream = new PrintStream(cliente.getOutputStream());
			stream.print(message);
			System.out.println("Sended: " + message);
			
			return readDataReturn(cliente.getInputStream());

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private String readDataReturn(InputStream stream) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
		
		char[] buffer = new char[1024];
		int read = 0;
		StringBuilder sb = new StringBuilder();
		
		while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
		    sb.append(buffer, 0, read);
		    break;
		}

		reader.close();

		return sb.toString().trim();
	}
}
