package OO1.parcial_1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sistema {

	private List<Pedido> pedidos;
	private List<Factura> facturas;
	
	
	public Sistema() {
		this.pedidos = new ArrayList<>();
		this.facturas = new ArrayList<>();
	}
	
	public Pedido darAltaPedido(String nombreEmpresa, String destino, LocalDate fechaExportacion) {
		Pedido pedido = new Pedido(nombreEmpresa, destino, fechaExportacion);
		this.pedidos.add(pedido);
		return pedido;
	}
	
	public Item agregarBien(Pedido pedido, String descripcion, int cantidad, double peso, double valor) {
		Item bien = new Bien(descripcion, cantidad, peso, valor);
		pedido.agregarItem(bien);
		return bien;
	}
	
	public Item agregarServicio(Pedido pedido, String descripcion, double costoMateriales, double costoManoDeObra) {
		Item servicio = new Servicio(descripcion, costoMateriales, costoManoDeObra);
		pedido.agregarItem(servicio);
		return servicio;
	}
	
	public Factura facturar(Pedido pedido) {
		return pedido.facturar();
	}
	
	public Factura mayorValor(LocalDate inicio, LocalDate fin) {
		return this.facturas.stream()
				.filter(f->f.estaEntre(inicio, fin))
				.max((f1, f2)->Double.compare(f1.getCostoFinal(), f2.getCostoFinal()))
				.orElse(null);
	}
}
