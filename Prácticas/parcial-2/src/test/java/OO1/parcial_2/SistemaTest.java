package OO1.parcial_2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SistemaTest {

	private Sistema sistema;
	private Usuario usuarioConProyectos, usuarioSinProyectos;
	
	
	@BeforeEach
	void setUp() {
		this.sistema = new Sistema();
		this.usuarioConProyectos = this.sistema.registrarUsuario("Pepe");
		this.usuarioSinProyectos = this.sistema.registrarUsuario("Pablo");
	}
	
	@Test
	void testProyectosVigentes() {
		assertEquals(0, this.sistema.proyectosVigentes().size());
		Proyecto proyectoVigente = this.sistema.registrarProyecto(this.usuarioConProyectos, "Crea tu helado", "Hace tu propio helado", 1000, LocalDate.of(2023, 01, 01));
		Proyecto proyectoNoVigente = this.sistema.registrarProyecto(this.usuarioConProyectos, "Hace tu dron", "Hace tu propio dron", 1000, LocalDate.of(2022, 01, 01));
		assertTrue(this.sistema.proyectosVigentes().get(0).equals(proyectoVigente));
	}
}
