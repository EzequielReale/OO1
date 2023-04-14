package OO1.parcial_2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sistema {

	private List<Usuario> usuarios;
	
	
	public Sistema() {
		this.usuarios = new ArrayList<>();
	}
	
	public Usuario registrarUsuario(String nombre) {
		Usuario usuario = new Usuario(nombre);
		this.usuarios.add(usuario);
		return usuario;
	}
	
	public Proyecto registrarProyecto(Usuario usuario, String titulo, String descripcion, double montoMin, LocalDate fechaLimite) {
		return usuario.registrarProyecto(titulo, descripcion, montoMin, fechaLimite);
	}
	
	public Aporte aportarAProyecto(Usuario usuario, Proyecto proyecto, double monto) {
		if (!usuario.esMiProyecto(proyecto)) {
			return usuario.registrarAporte(proyecto, monto);
		}
		return null;
	}
	
	public List<Proyecto> proyectosVigentes() {
		return this.usuarios.stream()
				.flatMap(u->u.misProyectosVigentes().stream())
				.collect(Collectors.toList());
	}
	
	public List<Proyecto> proyectosVigentesConFinanciacionCompleta() {
		return this.usuarios.stream()
				.flatMap(u->u.misProyectosVigentesConFinanciacionCompleta().stream())
				.collect(Collectors.toList());
	}
	
	public List<Proyecto> proyectosConAportesEntre(LocalDate inicio, LocalDate fin) {
		return this.usuarios.stream()
				.flatMap(u->u.misProyectosConAportesEntre(inicio, fin).stream())
				.collect(Collectors.toList());
	}
	
	public double aportesDiariosDe(Usuario usuario) {
		return usuario.misAportesDiarios();
	}
	
	public List<Proyecto> proyectosPositivosEntre(LocalDate inicio, LocalDate fin) {
		return this.usuarios.stream()
				.flatMap(u->u.misProyectosPositivos(inicio, fin).stream())
				.collect(Collectors.toList());
	}
}
