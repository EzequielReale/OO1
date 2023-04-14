package OO1.parcial_2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Usuario {

	private String nombre;
	private LocalDate fechaRegistracion;
	private List<Proyecto> proyectos;
	private List<Aporte> aportes;
	
	
	public Usuario(String nombre) {
		this.nombre = nombre;
		this.fechaRegistracion = LocalDate.now();
		this.proyectos = new ArrayList<>();
	}
	
	public Proyecto registrarProyecto(String titulo, String descripcion, double montoMin, LocalDate fechaLimite) {
		Proyecto proyecto = new Proyecto(titulo, descripcion, montoMin, fechaLimite);
		this.proyectos.add(proyecto);
		return proyecto;
	}
	
	public boolean esMiProyecto(Proyecto proyecto) {
		return this.proyectos.stream()
				.anyMatch(p->p.equals(proyecto));
	}
	
	public Aporte registrarAporte(Proyecto proyecto, double monto) {
		Aporte aporte = new Aporte(monto);
		proyecto.registrarAporte(aporte);
		this.aportes.add(aporte);
		return aporte;
	}
	
	public List<Proyecto> misProyectosVigentes() {
		return this.proyectos.stream()
				.filter(p->p.estaVigente())
				.collect(Collectors.toList());
	}
	
	public List<Proyecto> misProyectosVigentesConFinanciacionCompleta() {
		return this.proyectos.stream()
				.filter(p->p.tieneFinanciacionCompleta() && p.estaVigente())
				.collect(Collectors.toList());
	}
	
	public List<Proyecto> misProyectosConAportesEntre(LocalDate inicio, LocalDate fin) {
		return this.proyectos.stream()
				.filter(p->p.tengoAportesEntre(inicio, fin))
				.collect(Collectors.toList());
	}
	
	private long getDiasRegistrado() {
		return ChronoUnit.DAYS.between(fechaRegistracion, LocalDate.now());
	}
	
	public double misAportesDiarios() {
		return this.aportes.stream().mapToDouble(a->a.getMonto()).sum() / this.getDiasRegistrado();
	}
	
	public List<Proyecto> misProyectosPositivos(LocalDate inicio, LocalDate fin) {
		return this.misProyectosConAportesEntre(inicio, fin).stream()
				.filter(p->!p.aporteMayor(this.misAportesDiarios()))
				.collect(Collectors.toList());
	}
}
