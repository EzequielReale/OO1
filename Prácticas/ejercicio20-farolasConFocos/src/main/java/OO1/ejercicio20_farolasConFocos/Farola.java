package OO1.ejercicio20_farolasConFocos;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Farola {

	private Foco bulb;
	private Set<Farola> neighbors;
	private boolean on;
	
	
	public Farola(String maker, int cicles) {
		this.bulb = new Foco(maker, cicles);
		this.neighbors = new HashSet<>();
		this.on = false;
	}
	
	public Set<Farola> getNeighbors() {
		return neighbors;
	}
	
	public Foco getBulb() {
		return bulb;
	}

	public boolean isOn() {
		return on;
	}

	public void pairWithNeighbor(Farola aNeighbor) {
		this.neighbors.add(aNeighbor);
		aNeighbor.getNeighbors().add(this);
	}
	
	public void turnOn() {
		if (!this.on && !this.bulb.isExpired()) {
			this.on = true;
			this.bulb.completeCicle();
			this.neighbors.stream().forEach(n -> n.turnOn());
		}
	}
	
	public void turnOff() {
		if (this.on) {
			this.on = false;
			this.neighbors.stream().forEach(n -> n.turnOff());
		}
	}
	
	public Set<Farola> streetlightsWithExpiredBulbs() {
		Set<Farola> expired = new HashSet<>();
		if (this.bulb.isExpired() && this.on) {
			this.on = false;
			expired = this.neighbors.stream().flatMap(n->n.streetlightsWithExpiredBulbs().stream()).collect(Collectors.toSet());
			expired.add(this);
		}
		return expired;
	}
}
