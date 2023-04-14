package OO1.ejercicio18_liquidaciónDeHaberes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Empleado {

	String nombre, apellido, cuil;
	LocalDate fNacimiento, fInicioRelacionLaboral;
	boolean tieneConyuge, tieneHijos;
	List<Contrato> contratos;
	
	
	public Empleado(String nombre, String apellido, String cuil, LocalDate fNacimiento, boolean tieneConyuge, boolean tieneHijos) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cuil = cuil;
		this.fNacimiento = fNacimiento;
		this.fInicioRelacionLaboral = LocalDate.now();
		this.tieneConyuge = tieneConyuge;
		this.tieneHijos = tieneHijos;
		this.contratos = new ArrayList<>();
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

	public LocalDate getfechaDeNacimiento() {
		return fNacimiento;
	}

	public boolean tieneConyuge() {
		return tieneConyuge;
	}

	public boolean tieneHijos() {
		return tieneHijos;
	}
	
	public LocalDate getfechaDeInicioDeRelacionLaboral() {
		return fInicioRelacionLaboral;
	}

	public List<Contrato> getContratos() {
		return contratos;
	}

	public int getAntiguedad() {
		return (int) ChronoUnit.YEARS.between(this.fInicioRelacionLaboral, LocalDate.now());
	}
	
	public void agregarContrato(Contrato contrato) {
		this.contratos.add(contrato);
	}
	
	public Optional<Contrato> getContratoVigente() {
		return this.contratos.stream().
				max((Contrato c1, Contrato c2)->c1.getFechaInicio().
				compareTo(c2.getFechaInicio()));
	}
	
	public boolean tieneContratoVencido() {
		return this.getContratoVigente().map(c->c.estaVencido()).orElse(false);
	}
	
	public double calcularMonto() {
		double porcentaje;
		
		if (this.getAntiguedad() >= 20) porcentaje = 1;
		else if (this.getAntiguedad() >= 15) porcentaje = 0.7;
		else if (this.getAntiguedad() >= 10) porcentaje = 0.5;
		else if (this.getAntiguedad() >= 5) porcentaje = 0.3;
		else porcentaje = 0;
		
		return this.getContratoVigente().map(c->c.calcularMonto() + c.calcularMonto() * porcentaje).orElse(0d);
	}
	
	public Recibo generarRecibo() {
		Recibo recibo = new Recibo(this, this.calcularMonto(), LocalDate.now());
		return recibo;
	}
}
