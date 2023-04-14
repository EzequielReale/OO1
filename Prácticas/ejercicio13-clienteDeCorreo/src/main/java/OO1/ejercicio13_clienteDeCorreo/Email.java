package OO1.ejercicio13_clienteDeCorreo;

import java.util.ArrayList;
import java.util.List;

public class Email {

	private String titulo, cuerpo;
	private List<Archivo> adjuntos;
	
	
	public Email(String titulo, String cuerpo) {
		this.titulo = titulo;
		this.cuerpo = cuerpo;
		this.adjuntos = new ArrayList<>();
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public String getCuerpo() {
		return cuerpo;
	}
	
	public List<Archivo> adjuntos() {
		return adjuntos;
	}
	
	public void adjuntarArchivo(Archivo archivo) {
		this.adjuntos.add(archivo);
	}
	
	public double tamanio() {
		return this.titulo.length() + this.cuerpo.length() +
			   this.adjuntos.stream().mapToDouble(archivo -> archivo.tamanio()).sum();
	}
	
	public boolean buscar(String texto) {
		return this.titulo.contains(texto) || this.cuerpo.contains(texto);
	}
}
