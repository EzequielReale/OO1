package OO1.ejercicio15_alquilerDePropiedades;

public class Reserva {

	private Propiedad propiedad;
	private Usuario usuario;
	private DateLapse periodo;
	
	
	public Reserva(Propiedad propiedad, Usuario usuario, DateLapse periodo) {
		this.propiedad = propiedad;
		this.usuario = usuario;
		this.periodo = periodo;
	}


	public Propiedad getPropiedad() {
		return propiedad;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public DateLapse getPeriodo() {
		return periodo;
	}
	
	public double calcularPrecio() {
		return propiedad.getPrecioPorNoche() * periodo.sizeInDays();
	}
}
