package OO1.parcial_1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private String nombreEmpresa, destino;
	private LocalDate fechaExportacion;
	private List<Item> items;
	
	
	public Pedido(String nombreEmpresa, String destino, LocalDate fechaExportacion) {
		this.nombreEmpresa = nombreEmpresa;
		this.destino = destino;
		this.fechaExportacion = fechaExportacion;
		this.items= new ArrayList<>();
	}
	
	public void agregarItem(Item item) {
		this.items.add(item);
	}
	
	public Factura facturar() {
		Factura factura = new Factura(this.fechaExportacion, this.items);
		return factura;
	}
}
