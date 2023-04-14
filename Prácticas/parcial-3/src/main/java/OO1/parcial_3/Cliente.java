package OO1.parcial_3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {

	private String nombre, domicilio;
	private List<Consumo> consumos;
	
	
	public Cliente(String nombre, String domicilio) {
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.consumos = new ArrayList<>();
	}
	
	public List<Consumo> getConsumos() {
		return consumos;
	}

	public void registrarConsumo(double medicion, LocalDate fecha) {
		Consumo consumo = new Consumo(medicion, fecha);
		this.consumos.add(consumo);
	}
	
	protected Consumo obtenerConsumoMes(LocalDate fecha) {
		return this.consumos.stream().
				filter(c->c.mesCoincide(fecha)).
				findFirst()
				.orElse(null);
	}
	
	protected abstract double calcularDescuento(LocalDate fecha, double monto, double medicionActual);
	
	public abstract double calcularMonto(LocalDate fecha, Tarifario tarifario);
}
