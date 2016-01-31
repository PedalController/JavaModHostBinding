package br.com.srmourasilva.modhostbinding;

import java.io.IOException;
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
			e.printStackTrace();
		}
	}

	public void sendMessage(String message) {
		try {
			PrintStream stream = new PrintStream(cliente.getOutputStream());
			stream.print(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
