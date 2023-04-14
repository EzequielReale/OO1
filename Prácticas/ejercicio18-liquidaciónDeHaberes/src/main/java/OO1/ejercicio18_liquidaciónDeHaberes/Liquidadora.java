package OO1.ejercicio18_liquidaciónDeHaberes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Liquidadora {

	private List<Empleado> empleados;
	
	
	public Liquidadora() {
		this.empleados = new ArrayList<>();
	}
	
	public List<Empleado> getEmpleados() {
		return this.empleados;
	}
	
	public Empleado darDeAlta(String nombre, String apellido, String cuil, LocalDate fNacimiento, boolean tieneConyuge, boolean tieneHijos) {
		Empleado empleado = new Empleado(nombre, apellido, cuil, fNacimiento, tieneConyuge, tieneHijos);
		this.empleados.add(empleado);
		return empleado;
	}
	
	public void darDeBaja(Empleado empleado) {
		this.empleados.remove(empleado);
	}
	
	public Empleado buscarEmpleado(String cuil) {
		return this.empleados.stream().filter(e -> e.getCuil().equals(cuil)).findFirst().orElse(null);
	}
	
	public Contrato cargarContratoDePlanta(Empleado empleado, LocalDate fechaInicio, double sueldoMensual, double montoPorConyuge, double montoPorHijos) {
		Contrato contrato = new ContratoDePlanta(empleado, fechaInicio, sueldoMensual, montoPorConyuge, montoPorHijos);
		empleado.agregarContrato(contrato);
		return contrato;
	}
	
	public Contrato cargarContratoPorHoras(Empleado empleado, LocalDate fechaInicio, LocalDate fechaFin, double valorHora, int horasMensuales) {
		Contrato contrato = new ContratoPorHoras(empleado, fechaInicio, fechaFin, valorHora, horasMensuales);
		empleado.agregarContrato(contrato);
		return contrato;
	}
	
	public List<Empleado> empleadosConContratosVencidos() {
		return this.empleados.stream().filter(e->e.tieneContratoVencido()).collect(Collectors.toList());
	}
	
	public List<Recibo> generarRecibos() {
		return this.empleados.stream().map(e->e.generarRecibo()).collect(Collectors.toList());
	}
}
