package OO1.ejercicio13_clienteDeCorreo;

public class Archivo {

	private String nombre;
	
	
	public Archivo(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double tamanio() {
		return this.nombre.length();
	}
}
