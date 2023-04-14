package OO1.ejercicio16_politicasDeDevolucion;

import java.time.LocalDate;

public class CancelacionFlexible implements ICancelacion {

	@Override
	public double reembolsar(Reserva reserva, LocalDate fechaDeAviso) {
		if (fechaDeAviso.isBefore(reserva.getPeriodo().getFrom())) {
			return reserva.calcularPrecio();
		}
		return 0;
	}
}
