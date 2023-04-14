package OO1.ejercicio2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Balanza {

	private List<Producto> productos;
	
	public Balanza() {
		this.productos = new ArrayList<Producto>();
	}

	public List<Producto> getProductos() {
		return this.productos;
	}
	
	public int getCantidadProductos() {
		return this.productos.size();
	}
	
	public double getPrecioTotal() {
		return this.productos.stream().mapToDouble(producto -> producto.getPrecio()).sum();
	}
	
	public double getPesoTotal() {
		return this.productos.stream().mapToDouble(producto -> producto.getPeso()).sum();
	}
	
	public void ponerEnCero() {
		this.productos.clear();
	}
	
	public void agregarProducto(Producto producto) {
		this.productos.add(producto);
	}
	
	public TicketViejo emitirTicket() {
		TicketViejo ticket = new TicketViejo();
		ticket.setCantidadDeProductos(this.getCantidadProductos());
		ticket.setFecha(LocalDate.now());
		ticket.setPesoTotal(this.getPesoTotal());
		ticket.setPrecioTotal(this.getPrecioTotal() + ticket.impuesto());
		
		return ticket;
	}
	
}
