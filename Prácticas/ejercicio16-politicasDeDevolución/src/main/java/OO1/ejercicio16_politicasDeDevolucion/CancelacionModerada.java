package OO1.ejercicio16_politicasDeDevolucion;

import java.time.LocalDate;

public class CancelacionModerada implements ICancelacion {

	@Override
	public double reembolsar(Reserva reserva, LocalDate fechaDeAviso) {
		if (fechaDeAviso.isBefore(reserva.getPeriodo().getFrom().minusWeeks(1))) {
			return reserva.calcularPrecio();
		}
		else if (fechaDeAviso.isBefore(reserva.getPeriodo().getFrom().minusDays(2))) {
			return reserva.calcularPrecio() / 2;
		}
		return 0;
	}
}
