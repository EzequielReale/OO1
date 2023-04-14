package OO1.ejercicio19_ecommerce;

public class SeisCuotas implements FormaPago {

	@Override
	public double costoExtraPago(double monto) {
		return monto * 0.2;
	}
}
