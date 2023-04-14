package OO1.parcial_3;

import java.time.LocalDate;

public class ClienteResidencial extends Cliente {

	private String apellido;
	
	
	public ClienteResidencial(String nombre, String apellido, String domicilio) {
		super(nombre, domicilio);
		this.apellido = apellido;
	}
	
	@Override
	protected double calcularDescuento(LocalDate fecha, double monto, double medicionActual) {
		Consumo consumo = this.getConsumos().stream()
							.filter(c->c.mesAñoAnteriorCoincide(fecha))
							.findFirst()
							.orElse(null);
		double descuento = 0;
		if (consumo != null && consumo.getMedicion() < medicionActual) descuento = monto * 0.1;
		return descuento;
	}
	
	@Override
	public double calcularMonto(LocalDate fecha, Tarifario tarifario) {
		Consumo consumo = this.obtenerConsumoMes(fecha);
		double monto = 0;
		if (consumo != null) {
			monto = consumo.getMedicion()
					* tarifario.getMontoResidencial()
					- this.calcularDescuento(fecha, monto, consumo.getMedicion());
		}
								
		return monto;
	}
}
