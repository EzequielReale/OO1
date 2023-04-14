package OO1.ejercicio7_lookUpEmpleado;

public class Gerente extends EmpleadoJerarquico{

	public Gerente(String nombre) {
		super(nombre);
	}
	
	public Gerente() {}
	
	@Override
	public double aportes() {
		return this.montoBasico() * 0.05d;
	}
	
	@Override
	public double montoBasico() {
		return 57000;
	}
}
