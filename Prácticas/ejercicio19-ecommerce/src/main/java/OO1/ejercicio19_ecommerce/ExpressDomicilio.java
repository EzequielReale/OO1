package OO1.ejercicio19_ecommerce;

public class ExpressDomicilio implements MetodoEnvio {

	private Mapa mapa;
	private String dir1, dir2;
	
	public ExpressDomicilio(String dir1, String dir2) {
		this.mapa = new Mapa();
		this.dir1 = dir1;
		this.dir2 = dir2;
	}
	
	@Override
	public double costoExtraEnvio() {
		return 0.5 * this.mapa.distanciaEntre(this.dir1, this.dir2);
	}
}
