package OO1.parcial_1;

public class Bien extends Item {

	private int cantidad;
	private double peso, valor;
	
	
	public Bien(String descripcion, int cantidad, double peso, double valor) {
		super(descripcion);
		this.cantidad = cantidad;
		this.peso = peso;
		this.valor = valor;
	}

	@Override
	public double calcularCosto() {
		double monto = this.valor * this.cantidad;
		if (this.peso > 1000) monto += monto * 0.1;
		return monto;
	}
}
