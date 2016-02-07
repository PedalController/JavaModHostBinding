package br.com.srmourasilva.test;

import java.util.ArrayList;
import java.util.List;

public class Lv2Effect implements Effect {

	private String uri;
	private int instanceNumber;
	private String inName;
	private String outName;

	private ArrayList<Param> params;

	public Lv2Effect(String uri) {
		this.uri = uri;
		this.instanceNumber = 0;
		this.inName = "";
		this.outName = "";
		this.params = new ArrayList<>();
	}

	public String getLv2Uri() {
		return uri;
	}

	public void setInstanceNumber(int instanceNumber) {
		this.instanceNumber = instanceNumber;
	}
	
	public int getInstanceNumber() {
		return instanceNumber;
	}

	public String getInName() {
		return inName;
	}

	public String getOutName() {
		return outName;
	}

	public List<Param> getParams() {
		return params;
	}
	
	public void addParam(Param param) {
		this.params.add(param);
	}
}
