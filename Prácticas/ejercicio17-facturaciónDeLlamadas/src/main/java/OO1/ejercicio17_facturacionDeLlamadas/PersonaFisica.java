package OO1.ejercicio17_facturacionDeLlamadas;

import java.time.LocalDateTime;

public class PersonaFisica extends Persona{

	private String dni;

	public PersonaFisica(String nombre, String direccion, String telefono, String dni) {
		super(nombre, direccion, telefono);
		this.dni = dni;
	}

	public String getDni() {
		return dni;
	}
	
	@Override
	public double getMonto(LocalDateTime inicio, LocalDateTime fin) {
		return super.getMonto(inicio, fin) * 0.9;
	}
}
