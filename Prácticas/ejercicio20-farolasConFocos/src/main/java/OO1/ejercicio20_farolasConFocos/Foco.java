package OO1.ejercicio20_farolasConFocos;

public class Foco {

	private String maker;
	private int cicles;
	
	
	public Foco(String maker, int cicles) {
		this.maker = maker;
		this.cicles = cicles;
	}
	
	public String getMaker() {
		return maker;
	}

	public int getCicles() {
		return cicles;
	}
	
	public void completeCicle() {
		if (!this.isExpired()) this.cicles--;
	}
	
	public boolean isExpired() {
		return this.cicles == 0;
	}
}
