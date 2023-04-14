package OO1.parcial_1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SistemaTest {

	private Sistema sistema;
	private Pedido pedido1, pedido2;
	
	
	@BeforeEach
	public void setUp() {
		this.sistema = new Sistema();
		this.pedido1 = new Pedido("Dia%", "Japón", LocalDate.of(2022, 10, 28));
		this.pedido2 = new Pedido("Constructora Pablito", "India", LocalDate.of(2022, 10, 1));
		this.sistema.agregarBien(pedido1, "Dulce de leche", 2, 1, 500);
		this.sistema.agregarServicio(pedido1, "Empaquetado", 1000, 100);
	}
	
	@Test
	public void testCostoFinal() {
		Factura factura1 = this.sistema.facturar(pedido1);
		Factura factura2 = this.sistema.facturar(pedido2);
		assertEquals(2205, factura1.getCostoFinal());
		assertEquals(0, factura2.getCostoFinal());
	}
}
