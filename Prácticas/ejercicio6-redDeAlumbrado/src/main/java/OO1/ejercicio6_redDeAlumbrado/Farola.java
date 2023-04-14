package OO1.ejercicio6_redDeAlumbrado;

import java.util.ArrayList;
import java.util.List;

public class Farola {

	private List<Farola> neighbors;
	private boolean on;
	
	
	public Farola() {
		this.neighbors = new ArrayList<>();
		this.on = false;
	}
	
	public List<Farola> getNeighbors() {
		return neighbors;
	}

	public boolean isOn() {
		return on;
	}

	public void pairWithNeighbor(Farola aNeighbor) {
		if (!this.neighbors.contains(aNeighbor)) {
			this.neighbors.add(aNeighbor);
			aNeighbor.getNeighbors().add(this);
		}
	}
	
	public void turnOn() {
		if (!this.on) {
			this.on = true;
			this.neighbors.stream().forEach(farola -> farola.turnOn());
		}
	}
	
	public void turnOff() {
		if (this.on) {
			this.on = false;
			this.neighbors.stream().forEach(Farola -> Farola.turnOff());
		}
	}
}
