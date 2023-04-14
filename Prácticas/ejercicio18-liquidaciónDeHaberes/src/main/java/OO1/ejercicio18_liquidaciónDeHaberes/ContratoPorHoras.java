package OO1.ejercicio18_liquidaciónDeHaberes;

import java.time.LocalDate;

public class ContratoPorHoras extends Contrato {

	private LocalDate fechaFin;
	private double valorHora;
	private int horasMensuales;
	
	
	public ContratoPorHoras(Empleado empleado, LocalDate fechaInicio, LocalDate fechaFin, double valorHora, int horasMensuales) {
		super(empleado, fechaInicio);
		this.fechaFin = fechaFin;
		this.valorHora = valorHora;
		this.horasMensuales = horasMensuales;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public double getValorHora() {
		return valorHora;
	}

	public int getHorasMensuales() {
		return horasMensuales;
	}

	@Override
	public boolean estaVencido() {
		return this.fechaFin.isBefore(LocalDate.now());
	}

	@Override
	public double calcularMonto() {
		return this.valorHora * this.horasMensuales;
	}
	
}
