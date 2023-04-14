package OO1.ejercicio13_clienteDeCorreo;

import java.util.ArrayList;
import java.util.List;

public class Carpeta {

	private String nombre;
	private List<Email> emails;
	
	
	public Carpeta(String nombre) {
		this.nombre = nombre;
		this.emails = new ArrayList<>();
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public List<Email> getEmails() {
		return this.emails;
	}
	
	public void agregarEmail(Email email) {
		this.emails.add(email);
	}
	
	public void eliminarEmail(Email email) {
		this.emails.remove(email);
	}
	
	public Email buscar(String texto) {
		return this.emails.stream().filter(email -> email.buscar(texto)).findFirst().orElse(null);
	}
	
	public double tamanio() {
		return this.emails.stream().mapToDouble(emails -> emails.tamanio()).sum();
	}
}
