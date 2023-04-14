package OO1.ejercicio19_ecommerce;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sistema {

	public List<Vendedor> vendedores;
	public List<Cliente> clientes;
	
	
	public Sistema() {
		this.vendedores = new ArrayList<>();
		this.clientes = new ArrayList<>();
	}

	public List<Vendedor> getVendedores() {
		return vendedores;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}
	
	public Vendedor registrarVendedor(String nombre, String direccion) {
		Vendedor vendedor = new Vendedor(nombre, direccion);
		this.vendedores.add(vendedor);
		return vendedor;
	}
	
	public Vendedor buscarVendedor(String nombre) {
		return this.vendedores.stream().filter(v->v.equalsNombre(nombre))
			   .findFirst().orElse(null);
	}
	
	public Cliente registrarCliente(String nombre, String direccion) {
		Cliente cliente = new Cliente(nombre, direccion);
		this.clientes.add(cliente);
		return cliente;
	}
	
	public Cliente buscarCliente(String nombre) {
		return this.clientes.stream().filter(c->c.equalsNombre(nombre))
			   .findFirst().orElse(null);
	}
	
	public Producto ponerALaVenta(String nombre, String descripcion, double precio, int stock, Vendedor vendedor) {
		Producto producto = new Producto(nombre, descripcion, precio, stock);
		vendedor.agregarProducto(producto);
		return producto;
	}
	
	public List<Producto> buscarProducto(String nombre) {
		return this.vendedores.stream().flatMap(v->v.buscarProducto(nombre).stream())
			   .collect(Collectors.toList());
	}
	
	public Pedido crearPedido(Cliente cliente, Producto producto, int cantidad, FormaPago pago, MetodoEnvio envio) {
		Pedido pedido = null;
		if (producto.abastece(cantidad)) {
			pedido = new Pedido(producto, cantidad, pago, envio);
			cliente.agregarPedido(pedido);
			producto.reducirStock(cantidad);
		}
		return pedido;
	}
	
	public double calcularCostoPedido(Pedido pedido) {
		return pedido.calcularCostoTotal();
	}
}
