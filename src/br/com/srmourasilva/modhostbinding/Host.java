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
	
	public void connectInputIn(Lv2Plugin plugin) {
		if (!plugins.contains(plugin))
			throw new RuntimeException("Plugin " + plugin.getLv2Uri() + " has'nt added!");
		
		connection.send(ProtocolParser.connectInputIn(plugin));
	}
	
	public void connectOnOutput(Lv2Plugin plugin) {
		if (!plugins.contains(plugin))
			throw new RuntimeException("Plugin " + plugin.getLv2Uri() + " has'nt added!");
		
		connection.send(ProtocolParser.connectOnOutput(plugin));
	}
	
	public void connect(Lv2Plugin plugin, Lv2Plugin anotherPlugin) {
		if (!plugins.contains(plugin) || !plugins.contains(anotherPlugin))
			throw new RuntimeException("An plugin has'nt added!");
		
		connection.send(ProtocolParser.connect(plugin, anotherPlugin));
	}

	public void disconnect(Lv2Plugin effect, Lv2Plugin anotherEffect) {
		if (!plugins.contains(effect) || !plugins.contains(anotherEffect))
			throw new RuntimeException("Has a effect not added!");

		connection.send(ProtocolParser.disconnect(effect, anotherEffect));
	}
}
