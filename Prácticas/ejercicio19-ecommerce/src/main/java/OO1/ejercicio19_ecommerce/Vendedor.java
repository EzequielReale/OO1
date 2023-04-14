package OO1.ejercicio19_ecommerce;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Vendedor extends Persona {

	private List<Producto> productos; 
	
	
	public Vendedor(String nombre, String direccion) {
		super(nombre, direccion);
		this.productos = new ArrayList<>();
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void agregarProducto(Producto producto) {
		this.productos.add(producto);
	}
	
	public List<Producto> buscarProducto(String nombre) {
		return this.productos.stream().filter(p->p.equalsNombre(nombre))
			   .collect(Collectors.toList());
	}
	
}
