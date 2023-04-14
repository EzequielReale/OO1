package OO1.ejercicio8_distribuidora;

import java.time.LocalDate;

public class Factura {
	private double montoEnergiaActiva, descuento;
	private LocalDate fecha;
	private Usuario usuario;

	public Factura(double montoEnergiaActiva, double descuento, Usuario usuario) {
		this.montoEnergiaActiva = montoEnergiaActiva;
		this.descuento = descuento;
		this.fecha = LocalDate.now();
		this.usuario = usuario;
	}

	public double getMontoEnergiaActiva() {
		return montoEnergiaActiva;
	}

	public double getDescuento() {
		return descuento;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public double montoTotal() {
		return this.montoEnergiaActiva - this.montoEnergiaActiva * (this.descuento / 100);
	}
}
