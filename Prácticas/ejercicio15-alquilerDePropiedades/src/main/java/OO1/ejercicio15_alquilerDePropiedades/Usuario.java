package OO1.ejercicio15_alquilerDePropiedades;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Usuario {

	private String nombre, direccion;
	private long dni;
	private List<Propiedad> propiedades;
	private List<Reserva> reservas;
	
	public Usuario(String nombre, String direccion, long dni) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.dni = dni;
		this.propiedades = new ArrayList<>();
		this.reservas = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public List<Propiedad> getPropiedades() {
		return propiedades;
	}

	public void agregarPropiedad(Propiedad propiedad) {
		this.propiedades.add(propiedad);
	}
	
	public boolean eliminarPropiedad(Propiedad propiedad) {
		return this.propiedades.remove(propiedad);
	}
	
	public List<Propiedad> getPropiedadesDisponibles(DateLapse periodo) {
		return this.propiedades.stream()
				.filter(p->p.estaDisponible(periodo))
				.collect(Collectors.toList());
	}
	
	public List<Reserva> getReservas() {
		return reservas;
	}

	public void agregarReserva(Reserva reserva) {
		this.reservas.add(reserva);
	}
	
	public boolean eliminarReserva(Reserva reserva) {
		return this.reservas.remove(reserva);
	}

	public double calcularIngresos(DateLapse periodo) {
		return this.propiedades.stream()
				.mapToDouble(propiedad -> propiedad.calcularIngresos(periodo))
				.sum();
	}
}
