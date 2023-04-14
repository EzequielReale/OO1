package OO1.ejercicio11_inversor;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PlazoFijo implements Inversion{

	private LocalDate fechaDeConstitucion;
	private double montoDepositado, porcentajeDeInteresDiario;
	
	
	public PlazoFijo(LocalDate fechaDeConstitucion, double montoDepositado, double porcentajeDeInteresDiario) {
		this.fechaDeConstitucion = fechaDeConstitucion;
		this.montoDepositado = montoDepositado;
		this.porcentajeDeInteresDiario = porcentajeDeInteresDiario;
	}


	public LocalDate getFechaDeConstitucion() {
		return fechaDeConstitucion;
	}

	public double getMontoDepositado() {
		return montoDepositado;
	}

	public double getPorcentajeDeInteresDiario() {
		return porcentajeDeInteresDiario;
	}

	@Override
	public double valorActual() {
		long dias = ChronoUnit.DAYS.between(fechaDeConstitucion, LocalDate.now());
		return this.montoDepositado + (this.montoDepositado * (this.porcentajeDeInteresDiario / 100)) * dias; 
	}
}
