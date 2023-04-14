package OO1.parcial_3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SistemaTest {

	private Sistema sistema;
	private Cliente residencial, industria;
	
	@BeforeEach
	void setUp() {
		this.sistema = new Sistema(2, 2);
		this.residencial = sistema.registrarClienteResidencial("Omar", "Amor", "Diagonal 80 2456");
		this.industria = sistema.registrarClienteIndustrial("La Sermonisima", "Calle Posadas 2454");
		this.residencial.registrarConsumo(12, LocalDate.of(2018, 04, 05));
		this.industria.registrarConsumo(414, LocalDate.of(2018, 04, 05));
	}
	
	@Test
	void calcularMontoTest() {
		assertEquals(24, this.residencial.calcularMonto(LocalDate.of(2018, 04, 01), this.sistema.getTarifario()));
		assertEquals(828, this.industria.calcularMonto(LocalDate.of(2018, 04, 01), this.sistema.getTarifario()));
	}
}
