package OO1.parcial_3;

public class Tarifario {

	private double montoResidencial, montoIndustria;

	public Tarifario(double montoResidencial, double montoIndustria) {
		this.montoResidencial = montoResidencial;
		this.montoIndustria = montoIndustria;
	}

	public double getMontoResidencial() {
		return montoResidencial;
	}

	public double getMontoIndustria() {
		return montoIndustria;
	}

	public void setMontos(double montoResidencial, double montoIndustria) {
		this.montoResidencial = montoResidencial;
		this.montoIndustria = montoIndustria;
	}
}
