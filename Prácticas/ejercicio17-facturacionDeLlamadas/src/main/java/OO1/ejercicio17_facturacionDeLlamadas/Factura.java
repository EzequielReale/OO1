package OO1.ejercicio17_facturacionDeLlamadas;

import java.time.LocalDateTime;

public class Factura {

	private double monto;
	private Persona cliente;
	private LocalDateTime fecha, inicio, fin;
	
	
	public Factura(Persona cliente, LocalDateTime inicio, LocalDateTime fin) {
		this.cliente = cliente;
		this.fecha = LocalDateTime.now();
		this.inicio = inicio;
		this.fin = fin;
		this.monto = cliente.getMonto(inicio, fin);
	}


	public double getMonto() {
		return monto;
	}

	public Persona getCliente() {
		return cliente;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public LocalDateTime getInicio() {
		return inicio;
	}

	public LocalDateTime getFin() {
		return fin;
	}
}
