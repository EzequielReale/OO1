package OO1.ejercicio17_facturacionDeLlamadas;

import java.time.LocalDateTime;

public class LlamadaInternacional extends Llamada {

	private String paisOrigen, paisDestino;
	
	
	public LlamadaInternacional(LocalDateTime fechaYHora, int minutos, String emisor, String receptor, String paisOrigen, String paisDestino) {
		super(fechaYHora, minutos, emisor, receptor);
		this.paisOrigen = paisOrigen;
		this.paisDestino = paisDestino;
	}

	public String getPaisOrigen() {
		return paisOrigen;
	}

	public String getPaisDestino() {
		return paisDestino;
	}

	@Override
	public double getCosto() {
		return (this.getFechaYHora().getHour() >= 8 && this.getFechaYHora().getHour() < 20)
			   ? super.calularCosto(4) : super.calularCosto(3);
	}
}
