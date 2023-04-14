package OO1.ejercicio16_politicasDeDevolucion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
	
	public Propiedad registrarPropiedad(String nombre, String descripcion, String direccion, double precioPorNoche, Usuario propietario, ICancelacion politica) {
		Propiedad propiedad = new Propiedad(nombre, descripcion, direccion, precioPorNoche, politica);
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
		return (reserva.getPeriodo().laterFrom()) ? reserva.getUsuario().eliminarReserva(reserva) : false;
	}
	
	public double cancelarReserva(Reserva reserva, LocalDate fechaDeAviso) {
		return reserva.cancelar(reserva, fechaDeAviso);
	}
	
	public List<Reserva> getReservas(Usuario usuario) {
		return usuario.getReservas();
	}
	
	public double calcularIngresos(Usuario usuario, DateLapse periodo) {
		return usuario.calcularIngresos(periodo);
	}
}
