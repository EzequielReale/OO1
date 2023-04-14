package OO1.ejercicio17_facturacionDeLlamadas;

public class PersonaJuridica extends Persona{

	private String cuit, tipo;

	
	public PersonaJuridica(String nombre, String direccion, String telefono, String cuit, String tipo) {
		super(nombre, direccion, telefono);
		this.cuit = cuit;
		this.tipo = tipo;
	}

	public String getCuit() {
		return cuit;
	}

	public String getTipo() {
		return tipo;
	}
}
