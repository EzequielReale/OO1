package OO1.ejercicio17_facturacionDeLlamadas;

import java.time.LocalDateTime;

public class LlamadaInterurbana extends Llamada {

	private double km;
	
	
	public LlamadaInterurbana(LocalDateTime fechaYHora, int minutos, String emisor, String receptor, double km) {
		super(fechaYHora, minutos, emisor, receptor);
		this.km = km;
	}

	public double getKm() {
		return km;
	}

	@Override
	public double getCosto() {
		double monto = 5;
		if (this.km < 100) monto += super.calularCosto(2);
		else if (this.km >= 100 && this.km <= 500) monto += super.calularCosto(2.5);
		else monto += super.calularCosto(3);
		
		return monto;
	}
}
