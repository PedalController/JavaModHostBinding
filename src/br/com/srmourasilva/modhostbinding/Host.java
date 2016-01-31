package br.com.srmourasilva.modhostbinding;

import java.util.ArrayList;
import java.util.List;

import br.com.srmourasilva.test.Lv2Effect;

public class Host {
	private Connection connection;
	private List<Lv2Effect> effects;

	public Host() {
		this.connection = new Connection();
		this.effects = new ArrayList<>();
	}

	public void add(Lv2Effect effect) {
		effect.setInstanceNumber(effects.size());
		effects.add(effect);

		connection.sendMessage(ProtocolParser.add(effect));
	}

	public void connect(Lv2Effect effect, Lv2Effect anotherEffect) {
		if (!effects.contains(effect) || !effects.contains(anotherEffect))
			throw new RuntimeException("Has a effect not added!");

		connection.sendMessage(ProtocolParser.connect(effect, anotherEffect));
	}

	public void disconnect(Lv2Effect effect, Lv2Effect anotherEffect) {
		if (!effects.contains(effect) || !effects.contains(anotherEffect))
			throw new RuntimeException("Has a effect not added!");

		connection.sendMessage(ProtocolParser.disconnect(effect, anotherEffect));
	}
}
