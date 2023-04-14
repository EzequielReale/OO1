package OO1.ejercicio17_facturacionDeLlamadas;

import java.time.LocalDateTime;

public class LlamadaLocal extends Llamada {

	public LlamadaLocal(LocalDateTime fechaYHora, int minutos, String emisor, String receptor) {
		super(fechaYHora, minutos, emisor, receptor);
	}
	
	@Override
	public double getCosto() {
		return super.calularCosto(1);
	}
}
