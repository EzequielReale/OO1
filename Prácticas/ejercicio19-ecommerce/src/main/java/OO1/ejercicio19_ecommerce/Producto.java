package OO1.ejercicio19_ecommerce;

public class Producto {

	private String nombre, descripcion;
	private double precio;
	private int stock;
	
	
	public Producto(String nombre, String descripcion, double precio, int stock) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public int getStock() {
		return stock;
	}
	
	public boolean equalsNombre(String nombre) {
		return this.nombre.equals(nombre);
	}
	
	public boolean abastece(int cantidad) {
		return this.stock >= cantidad;
	}
	
	public void reducirStock(int cantidad) {
		this.stock -= cantidad;
	}
}
