package OO1.ejercicio17_facturacionDeLlamadas;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Persona {

	private String nombre, direccion, telefono;
	private List<Llamada> llamadas;
	
	
	public Persona(String nombre, String direccion, String telefono) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.llamadas = new ArrayList<>();
	}


	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public List<Llamada> getLlamadas() {
		return llamadas;
	}
	
	public Llamada registrarLlamadaLocal(LocalDateTime fechaYHora, int duracion, String nroEmisor, String nroReceptor) {
		Llamada llamada = new LlamadaLocal(fechaYHora, duracion, nroEmisor, nroReceptor);
		this.llamadas.add(llamada);
		return llamada;
	}
	
	public Llamada registrarLlamadaInterurbana(LocalDateTime fechaYHora, int duracion, String nroEmisor, String nroReceptor, double km) {
		Llamada llamada = new LlamadaInterurbana(fechaYHora, duracion, nroEmisor, nroReceptor, km);
		this.llamadas.add(llamada);
		return llamada;
	}
	
	public Llamada registrarLlamadaInternacional(LocalDateTime fechaYHora, int duracion, String nroEmisor, String nroReceptor, String paisOrigen, String paisDestino) {
		Llamada llamada = new LlamadaInternacional(fechaYHora, duracion, nroEmisor, nroReceptor, paisOrigen, paisDestino);
		this.llamadas.add(llamada);
		return llamada;
	}
	
	public double getMonto(LocalDateTime inicio, LocalDateTime fin) {
		return this.llamadas.stream().filter(llamada -> llamada.incluyeFecha(inicio, fin))
			   .mapToDouble(llamada -> llamada.getCosto()).sum();
	}
}
