package OO1.ejercicio18_liquidaciónDeHaberes;

import java.time.LocalDate;

public class ContratoDePlanta extends Contrato {

	private double sueldoMensual, montoPorConyuge, montoPorHijos;
	
	
	public ContratoDePlanta(Empleado empleado, LocalDate fechaInicio, double sueldoMensual, double montoPorConyuge, double montoPorHijos) {
		super(empleado, fechaInicio);
		this.sueldoMensual = sueldoMensual;
		this.montoPorConyuge = montoPorConyuge;
		this.montoPorHijos = montoPorHijos;
	}

	public double getSueldoMensual() {
		return sueldoMensual;
	}

	public double getMontoPorConyuge() {
		return montoPorConyuge;
	}

	public double getMontoPorHijos() {
		return montoPorHijos;
	}

	@Override
	public boolean estaVencido() {
		return false;
	}
	
	@Override
	public double calcularMonto() {
		double montoTotal = this.sueldoMensual;
		if (this.getEmpleado().tieneConyuge) montoTotal += this.montoPorConyuge; 
		if (this.getEmpleado().tieneHijos) montoTotal += this.montoPorHijos;
		
		return montoTotal;
	}
}
