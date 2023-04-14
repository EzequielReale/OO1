package OO1.ejercicio18_liquidaciónDeHaberes;

import java.time.LocalDate;

public class Recibo {

	private String nombre, apellido, cuil;
	private double monto;
	private int antiguedad;
	private LocalDate fecha;
	
	
	public Recibo(Empleado empleado, double monto, LocalDate fecha) {
		this.nombre = empleado.getNombre();
		this.apellido = empleado.getApellido();
		this.cuil = empleado.getCuil();
		this.monto = monto;
		this.antiguedad = empleado.getAntiguedad();
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getCuil() {
		return cuil;
	}

	public double getMonto() {
		return monto;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public LocalDate getFecha() {
		return fecha;
	}	
}
