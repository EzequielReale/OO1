package OO1.ejercicio19_ecommerce;

public class Contado implements FormaPago {

	@Override
	public double costoExtraPago(double monto) {
		return 0;
	}
}
