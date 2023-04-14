package OO1.ejercicio7_lookUpEmpleado;

public class Empleado {

	private String nombre;
	
	public Empleado(String nombre) {
		this.nombre = nombre;
	}
	
	public Empleado() {}
	
	public double montoBasico() {
		return 35000;
	}
	
	public double aportes() {
		return 13500;
	}
	
	public double sueldoBasico() {
		return this.montoBasico() + this.aportes();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
