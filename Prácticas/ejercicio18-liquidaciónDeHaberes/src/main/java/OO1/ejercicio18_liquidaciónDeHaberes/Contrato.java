package OO1.ejercicio18_liquidaciónDeHaberes;

import java.time.LocalDate;

public abstract class Contrato {

	private LocalDate fechaInicio;
	private Empleado empleado;
	
	public Contrato(Empleado empleado, LocalDate fechaInicio) {
		this.empleado = empleado;
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	
	public Empleado getEmpleado() {
		return this.empleado;
	}
	
	public abstract boolean estaVencido();
	
	public abstract double calcularMonto();
}
