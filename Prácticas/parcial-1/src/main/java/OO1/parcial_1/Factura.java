package OO1.parcial_1;

import java.time.LocalDate;
import java.util.List;

public class Factura {

	private LocalDate fechaExportacion, fechaFacturacion;
	private List<Item> items;
	
	
	public Factura(LocalDate fechaExportacion, List<Item> items) {
		this.fechaExportacion = fechaExportacion;
		this.fechaFacturacion = LocalDate.now();
		this.items = items;
	}
	
	public List<Item> getItems() {
		return this.items;
	}
	
	private double getCostoBasico() {
		return this.items.stream().mapToDouble(i->i.calcularCosto()).sum();
	}
	
	private double getCostoDeExportacion() {
		return this.getCostoBasico() * 0.05;
	}
	
	public double getCostoFinal() {
		return this.getCostoBasico() + this.getCostoDeExportacion();
	}
	
	public boolean estaEntre(LocalDate inicio, LocalDate fin) {
		return (inicio.isBefore(this.fechaFacturacion) || inicio.isEqual(this.fechaFacturacion))
				&& (fin.isAfter(this.fechaFacturacion) || fin.isEqual(this.fechaFacturacion));
	}
}
