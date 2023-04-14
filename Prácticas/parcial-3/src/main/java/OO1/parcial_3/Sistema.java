package OO1.parcial_3;

import java.util.ArrayList;
import java.util.List;

public class Sistema {

	private List<Cliente> clientes;
	private Tarifario tarifario;
	
	
	public Sistema(double montoResidencial, double montoIndustria) {
		this.clientes = new ArrayList<>();
		this.tarifario = new Tarifario(montoResidencial, montoIndustria);
	}
	
	public double getMontoResidencial() {
		return this.tarifario.getMontoResidencial();
	}

	public double getMontoIndustria() {
		return this.tarifario.getMontoIndustria();
	}
	
	public Tarifario getTarifario() {
		return this.tarifario;
	}
	
	public void setMontos(double montoResidencial, double montoIndustria) {
		this.tarifario.setMontos(montoResidencial, montoIndustria);
	}
	
	public Cliente registrarClienteResidencial(String nombre, String apellido, String domicilio) {
		Cliente residencial = new ClienteResidencial(nombre, apellido, domicilio);
		this.clientes.add(residencial);
		return residencial;
	}
	
	public Cliente registrarClienteIndustrial(String nombre, String domicilio) {
		Cliente industrial = new ClienteIndustrial(nombre, domicilio);
		this.clientes.add(industrial);
		return industrial;
	}
}
