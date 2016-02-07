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
			e.printStackTrace();
		}
	}

	public String send(String message) {
		try {
			PrintStream stream = new PrintStream(cliente.getOutputStream());
			stream.print(message);
			return readDataReturn(cliente.getInputStream());

		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public String readDataReturn(InputStream stream) throws IOException {
		StringBuilder builder = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

		String str;

		while ((str = reader.readLine()) != null)
            builder.append(str + "\n" );

		return builder.toString();
	}
}
