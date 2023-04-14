package OO1.ejercicio15_alquilerDePropiedades;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AlquilerDePropiedades {

	private List<Usuario> usuarios;
	
	public AlquilerDePropiedades() {
		this.usuarios = new ArrayList<>();
	}
	
	public Usuario registrarUsuario(String nombre, String direccion, long dni) {
		Usuario usuario = new Usuario(nombre, direccion, dni);
		this.usuarios.add(usuario);
		return usuario;
	}
	
	public Propiedad registrarPropiedad(String nombre, String descripcion, String direccion, double precioPorNoche, Usuario propietario) {
		Propiedad propiedad = new Propiedad(nombre, descripcion, direccion, precioPorNoche);
		propietario.agregarPropiedad(propiedad);
		return propiedad;
	}
	
	public List<Propiedad> propiedadesDisponibles(DateLapse periodo) {
		List<List<Propiedad>> listas = this.usuarios.stream().map(u->u.getPropiedadesDisponibles(periodo)).collect(Collectors.toList());
		return listas.stream().flatMap(List::stream).collect(Collectors.toList());
	}
	
	public Reserva hacerReserva(Propiedad propiedad, DateLapse periodo, Usuario inquilino) {
		if (propiedad.estaDisponible(periodo)) {
			Reserva reserva = new Reserva(propiedad, inquilino, periodo);
			propiedad.agregarReserva(reserva);
			inquilino.agregarReserva(reserva);
			return reserva;
		}
		return null;
	}
	
	public double calcularPrecioDeReserva(Reserva reserva) {
		return reserva.calcularPrecio();
	}
	
	public boolean eliminarReserva(Reserva reserva) {
		if (reserva.getPeriodo().laterFrom()) return reserva.getUsuario().eliminarReserva(reserva);
		else return false;
	}
	
	public List<Reserva> getReservas(Usuario usuario) {
		return usuario.getReservas();
	}
	
	public double calcularIngresos(Usuario usuario, DateLapse periodo) {
		return usuario.calcularIngresos(periodo);
	}
}
