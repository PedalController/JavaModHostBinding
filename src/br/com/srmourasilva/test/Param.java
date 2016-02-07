package br.com.srmourasilva.test;

public class Param {
	private float min;
	private float max;
	private float current;

	public Param(int min, int max, int current) {
		this.min = min;
		this.max = max;
		this.current = current;
	}

	public float getMin() {
		return min;
	}
	
	public float getMax() {
		return max;
	}
	
	public float getCurrent() {
		return current;
	}
}
