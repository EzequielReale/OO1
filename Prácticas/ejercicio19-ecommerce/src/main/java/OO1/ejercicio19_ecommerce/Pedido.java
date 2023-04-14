package OO1.ejercicio19_ecommerce;

public class Pedido {

	private Producto producto;
	private int cantidad;
	private FormaPago pago;
	private MetodoEnvio envio;
	
	
	public Pedido(Producto producto, int cantidad, FormaPago pago, MetodoEnvio envio) {
		this.producto = producto;
		this.cantidad = cantidad;
		this.pago = pago;
		this.envio = envio;
	}

	public Producto getProducto() {
		return producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public FormaPago getPago() {
		return pago;
	}

	public MetodoEnvio getEnvio() {
		return envio;
	}
	
	private double calcularCostoBasico() {
		return this.producto.getPrecio() * this.cantidad;
	}
	
	public double calcularCostoTotal() {
		double monto = this.calcularCostoBasico();
		return monto + this.pago.costoExtraPago(monto) + this.envio.costoExtraEnvio();
	}
	
}
