package OO1.ejercicio19_ecommerce;

public abstract class Persona {

	private String nombre, direccion;

	
	public Persona(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}
	
	public boolean equalsNombre(String nombre) {
		return this.nombre.equals(nombre);
	}
	
}
