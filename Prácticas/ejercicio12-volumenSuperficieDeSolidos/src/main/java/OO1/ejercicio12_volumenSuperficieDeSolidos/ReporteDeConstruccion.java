package OO1.ejercicio12_volumenSuperficieDeSolidos;

import java.util.ArrayList;
import java.util.List;

public class ReporteDeConstruccion {

	private List<Pieza> piezas;
	
	
	public ReporteDeConstruccion() {
		this.piezas = new ArrayList<>();
	}
	
	public void agregarPieza(Pieza pieza) {
		this.piezas.add(pieza);
	}
	
	public List<Pieza> getPiezas() {
		return this.piezas;
	}
	
	public double volumenDeMaterial(String unMaterial) {
		return  this.piezas.stream()
				.filter(pieza -> pieza.getMaterial().equals(unMaterial))
				.mapToDouble((Pieza p) -> p.getVolumen()).sum();
	}
	
	public double superficieDeColor(String unColor) {
		return  this.piezas.stream()
				.filter(pieza -> pieza.getColor().equals(unColor))
				.mapToDouble((Pieza p) -> p.getSuperficie()).sum();
	}
}
