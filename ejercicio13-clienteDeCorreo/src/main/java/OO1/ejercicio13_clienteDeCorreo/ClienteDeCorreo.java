package OO1.ejercicio13_clienteDeCorreo;

import java.util.HashSet;
import java.util.Set;

public class ClienteDeCorreo {

	private Carpeta inbox;
	private Set<Carpeta> carpetas; //Es un set porque normalmente no deberían haber carpetas iguales 
	
	
	public ClienteDeCorreo() {
		this.inbox = new Carpeta("inbox");
		this.carpetas = new HashSet<>();
		this.carpetas.add(inbox);
	}
	
	public void agregarCarpeta(Carpeta carpeta) {
		this.carpetas.add(carpeta);
	}
	
	public void recibir(Email email) {
		this.inbox.agregarEmail(email);
	}
	
	public void mover(Email email, Carpeta origen, Carpeta destino) {
		if (this.carpetas.contains(origen) && this.carpetas.contains(destino) && origen.buscar(email.getTitulo()) != null) {
			destino.agregarEmail(email);
			origen.eliminarEmail(email);
		}
	}
	
	public Email buscar(String texto) {
		return this.carpetas.stream().map(carpeta -> carpeta.buscar(texto)).filter(email -> email != null).findFirst().orElse(null);
	}
	
	public int espacioOcupado() {
		return (int) this.carpetas.stream().mapToDouble(carpeta -> carpeta.tamanio()).sum();
	}
}
