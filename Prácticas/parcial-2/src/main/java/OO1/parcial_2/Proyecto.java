package OO1.parcial_2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Proyecto {

	private String titulo, descripcion;
	private double montoMin, montoAlcanzado;
	private LocalDate fechaLimite;
	private List<LocalDate> fechasAportes;
	
	
	public Proyecto(String titulo, String descripcion, double montoMin, LocalDate fechaLimite) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.montoMin = montoMin;
		this.montoAlcanzado = 0;
		this.fechaLimite = fechaLimite;
		this.fechasAportes = new ArrayList<>();
	}
	
	public void registrarAporte(Aporte aporte) {
		this.fechasAportes.add(LocalDate.now());
		this.montoAlcanzado += aporte.getMonto();
	}
	
	public boolean estaVigente() {
		return this.fechaLimite.isAfter(LocalDate.now());
	}
	
	public boolean tieneFinanciacionCompleta() {
		return this.montoAlcanzado >= this.montoMin;
	}
	
	public boolean aporteMayor(double monto) {
		return this.montoAlcanzado >= monto;
	}
	
	/*
	private Optional<LocalDate> pTengoAportesEntre(LocalDate inicio, LocalDate fin) {
		return this.fechasAportes.stream()
				.filter(f->((f.isAfter(inicio)|| f.isEqual(inicio))
				&& (f.isBefore(fin) || f.isEqual(fin))))
				.findFirst();
	}
	
	//Acá no sé qué poner en el map
	public boolean tengoAportesEntre(LocalDate inicio, LocalDate fin) {
		return this.pTengoAportesEntre(inicio, fin).map(a->a!=null).orElse(false);
	}
	*/
	
	private boolean tengoAportesEntre(LocalDate inicio, LocalDate fin) {
		return this.fechasAportes.stream()
		        .anyMatch(f->((f.isAfter(inicio)|| f.isEqual(inicio))
				&& (f.isBefore(fin) || f.isEqual(fin))));
	}
}
