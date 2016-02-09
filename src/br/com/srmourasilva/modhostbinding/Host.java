package br.com.srmourasilva.modhostbinding;

import java.util.ArrayList;
import java.util.List;

import br.com.srmourasilva.lv2library.Lv2Plugin;

public class Host {
	private Connection connection;
	private List<Lv2Plugin> plugins;

	public Host() {
		this.connection = new Connection();
		this.plugins = new ArrayList<>();
	}

	public void add(Lv2Plugin plugin) {
		plugin.setInstanceNumber(plugins.size());
		plugins.add(plugin);

		connection.send(ProtocolParser.add(plugin));
	}

	public void connect(Lv2Plugin plugin, Lv2Plugin anotherPlugin) {
		if (!plugins.contains(plugin) || !plugins.contains(anotherPlugin))
			throw new RuntimeException("An effect has'nt added!");
		
		connection.send(ProtocolParser.connect(plugin, anotherPlugin));
	}

	public void disconnect(Lv2Plugin effect, Lv2Plugin anotherEffect) {
		if (!plugins.contains(effect) || !plugins.contains(anotherEffect))
			throw new RuntimeException("Has a effect not added!");

		connection.send(ProtocolParser.disconnect(effect, anotherEffect));
	}
}
