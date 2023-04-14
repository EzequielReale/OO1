package OO1.parcial_3;

import java.time.LocalDate;

public class Consumo {

	private double medicion;
	private LocalDate fecha;
	
	
	public Consumo(double medicion, LocalDate fecha) {
		this.medicion = medicion;
		this.fecha = fecha;
	}

	public double getMedicion() {
		return medicion;
	}

	public LocalDate getFecha() {
		return fecha;
	}
	
	public boolean mesCoincide(LocalDate fechaParam) {
		return this.fecha.getYear() == fechaParam.getYear()
				&& this.fecha.getMonth() == fechaParam.getMonth();
	}
	
	public boolean mesAñoAnteriorCoincide(LocalDate fechaParam) {
		return this.fecha.getYear() == fechaParam.getYear()-1
				&& this.fecha.getMonth() == fechaParam.getMonth();
	}
	
	public boolean mesAnteriorCoincide(LocalDate fechaParam) {
		return this.fecha.getYear() == fechaParam.getYear()
				&& this.fecha.getMonth() == fechaParam.getMonth().minus(1);
	}
}
