package OO1.ejercicio17_facturacionDeLlamadas;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SistemaDeFacturacion {

	private List<String> numerosDisponibles;
	private List<Persona> clientes;
	
	
	public SistemaDeFacturacion() {
		this.numerosDisponibles = new ArrayList<>();
		this.clientes = new ArrayList<>();
	}

	public List<String> getNumerosDisponibles() {
		return numerosDisponibles;
	}

	public List<Persona> getClientes() {
		return clientes;
	}
	
	public void agregarNumero(String numero) {
		this.numerosDisponibles.add(numero);
	}
	
	private String getNumeroDisponible() {
		String numero = this.numerosDisponibles.get(0);
		this.numerosDisponibles.remove(0);
		return numero;
	}
	
	public Persona registrarPersonaFisica(String nombre, String direccion, String dni) {
		Persona cliente = new PersonaFisica(nombre, direccion, this.getNumeroDisponible(), dni);
		this.clientes.add(cliente);
		return cliente;
	}
	
	public Persona registrarPersonaJuridica(String nombre, String direccion, String cuit, String tipo) {
		Persona cliente = new PersonaJuridica(nombre, direccion, this.getNumeroDisponible(), cuit, tipo);
		this.clientes.add(cliente);
		return cliente;
	}
	
	public Persona getNroEmisor(String nro) {
		return this.clientes.stream().filter(persona -> persona.getTelefono().equals(nro))
			   .findFirst().orElse(null);
	}
	
	public Llamada registrarLlamadaLocal(LocalDateTime fechaYHora, int duracion, String nroEmisor, String nroReceptor) {
		Persona emisor = this.getNroEmisor(nroEmisor);
		return emisor.registrarLlamadaLocal(fechaYHora, duracion, nroEmisor, nroReceptor);
	}
	
	public Llamada registrarLlamadaInterurbana(LocalDateTime fechaYHora, int duracion, String nroEmisor, String nroReceptor, double km) {
		Persona emisor = this.getNroEmisor(nroEmisor);
		return emisor.registrarLlamadaInterurbana(fechaYHora, duracion, nroEmisor, nroReceptor, km);
	}
	
	public Llamada registrarLlamadaInternacional(LocalDateTime fechaYHora, int duracion, String nroEmisor, String nroReceptor, String paisOrigen, String paisDestino) {
		Persona emisor = this.getNroEmisor(nroEmisor);
		return emisor.registrarLlamadaInternacional(fechaYHora, duracion, nroEmisor, nroReceptor, paisOrigen, paisDestino);
	}
	
	public Factura facturar(Persona cliente, LocalDateTime inicio, LocalDateTime fin) {
		Factura factura = new Factura(cliente, inicio, fin);
		return factura;
	}
}
