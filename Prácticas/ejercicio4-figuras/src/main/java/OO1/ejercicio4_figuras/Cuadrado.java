package OO1.ejercicio4_figuras;

public class Cuadrado implements Figura{

	private double lado;

	public void setLado(double lado) {
		this.lado = lado;
	}
	
	public double getLado() {
		return this.lado;
	}
	
	public double getPerimetro() {
		return this.lado * 4;
	}

	public double getArea() {
		return Math.pow(this.lado, 2);
	}

}
