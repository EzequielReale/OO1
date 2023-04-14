package OO1.ejercicio16_politicasDeDevolucion;

import java.time.LocalDate;

public class CancelacionEstricta implements ICancelacion {

	@Override
	public double reembolsar(Reserva reserva, LocalDate fechaDeAviso) {
		return 0;
	}
}
