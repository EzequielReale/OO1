package OO1.ejercicio17_facturacionDeLlamadas;

import java.time.LocalDateTime;

public abstract class Llamada {

	private LocalDateTime fechaYHora;
	private int duracion;
	private String nroEmisor, nroReceptor;
	
	
	public Llamada(LocalDateTime fechaYHora, int duracion, String nroEmisor, String nroReceptor) {
		this.fechaYHora = fechaYHora;
		this.duracion = duracion;
		this.nroEmisor = nroEmisor;
		this.nroReceptor = nroReceptor;
	}

	public LocalDateTime getFechaYHora() {
		return fechaYHora;
	}

	public int getDuracion() {
		return duracion;
	}

	public String getNroEmisor() {
		return nroEmisor;
	}

	public String getNroReceptor() {
		return nroReceptor;
	}
		
	public boolean incluyeFecha(LocalDateTime inicio, LocalDateTime fin) {
		return this.fechaYHora.isAfter(inicio) && this.fechaYHora.isBefore(fin)
			   || this.fechaYHora.isEqual(inicio) || this.fechaYHora.isEqual(fin);
	}
	
	protected double calularCosto(double precio) {
		return this.duracion * precio;
	}
	
	public abstract double getCosto();
}
