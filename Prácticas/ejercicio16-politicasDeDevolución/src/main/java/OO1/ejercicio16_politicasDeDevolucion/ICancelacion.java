package OO1.ejercicio16_politicasDeDevolucion;

import java.time.LocalDate;

public interface ICancelacion {

	public double reembolsar(Reserva reserva, LocalDate fechaDeAviso);
}
