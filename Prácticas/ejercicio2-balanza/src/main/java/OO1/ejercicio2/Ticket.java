package OO1.ejercicio2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Ticket {

	private  LocalDate fecha;
	private List<Producto> productos;
	
	public Ticket(List<Producto> productos) {
		this.fecha = LocalDate.now();
		this.productos = new ArrayList<Producto>(productos);
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public List<Producto> getProductos() {
		return this.productos;
	}
	
	public int getCantidadDeProductos() {
		return this.productos.size();
	}

	public double getPesoTotal() {
		return this.productos.stream().mapToDouble(producto -> producto.getPeso()).sum();
	}
	
	public double getPrecioTotal() {
		return this.productos.stream().mapToDouble(producto -> producto.getPrecio()).sum();
	}
	
	public double impuesto() {
		return this.getPrecioTotal() * 0.21;
	}
	
}
