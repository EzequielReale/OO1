package OO1.parcial_1;

public class Servicio extends Item {

	private double costoMateriales, costoManoDeObra;
	
	
	public Servicio(String descripcion, double costoMateriales, double costoManoDeObra) {
		super(descripcion);
		this.costoMateriales = costoMateriales;
		this.costoManoDeObra = costoManoDeObra;
	}

	@Override
	public double calcularCosto() {
		return this.costoMateriales + this.costoManoDeObra;
	}
}
