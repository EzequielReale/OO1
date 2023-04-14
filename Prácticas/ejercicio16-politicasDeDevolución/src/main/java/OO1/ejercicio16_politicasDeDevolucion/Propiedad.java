package OO1.ejercicio16_politicasDeDevolucion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Propiedad {

	private String nombre, descripcion, direccion;
	private double precioPorNoche;
	private List<Reserva> reservas;
	private ICancelacion politica;
	
	
	public Propiedad(String nombre, String descripcion, String direccion, double precioPorNoche, ICancelacion politica) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.direccion = direccion;
		this.precioPorNoche = precioPorNoche;
		this.politica = politica;
		this.reservas = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public double getPrecioPorNoche() {
		return precioPorNoche;
	}

	public void setPrecioPorNoche(double precioPorNoche) {
		this.precioPorNoche = precioPorNoche;
	}
	
	public List<Reserva> getReservas() {
		return this.reservas;
	}
	
	public void agregarReserva(Reserva reserva) {
		this.reservas.add(reserva);
	}
	
	public boolean eliminarReserva(Reserva reserva) {
		return this.reservas.remove(reserva);
	}
	
	public double cancelarReserva(Reserva reserva, LocalDate fechaDeAviso) {
		double reembolso = politica.reembolsar(reserva, fechaDeAviso);
		this.eliminarReserva(reserva);
		return reembolso;
	}

	public double calcularIngresos(DateLapse periodo) {
		return this.reservas.stream().filter(reserva -> reserva.getPeriodo().overlaps(periodo)).mapToDouble(reserva -> reserva.calcularPrecio()).sum();
	}
	
	public boolean estaDisponible(DateLapse periodo) {
		return this.reservas.stream().noneMatch(reserva -> reserva.getPeriodo().overlaps(periodo));
	}
}
