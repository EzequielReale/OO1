package OO1.ejercicio2;

import java.time.LocalDate;

public class BalanzaVieja {

	private int cantidadDeProductos;
	private double precioTotal, pesoTotal;
	
	public BalanzaVieja() {
		this.ponerEnCero();
	}
	
	public int getCantidadDeProductos() {
		return cantidadDeProductos;
	}

	public void setCantidadDeProductos(int cantidadDeProductos) {
		this.cantidadDeProductos = cantidadDeProductos;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public double getPesoTotal() {
		return pesoTotal;
	}

	public void setPesoTotal(double pesoTotal) {
		this.pesoTotal = pesoTotal;
	}

	public void ponerEnCero() {
		this.cantidadDeProductos = 0;
		this.pesoTotal = 0;
		this.precioTotal = 0;
	}
	
	public void agregarProducto(Producto producto) {
		this.cantidadDeProductos++;
		this.pesoTotal += producto.getPeso();
		this.precioTotal += producto.getPrecio();
	}
	
	public TicketViejo emitirTicket() {
		TicketViejo ticket = new TicketViejo();
		ticket.setCantidadDeProductos(this.cantidadDeProductos);
		ticket.setFecha(LocalDate.now());
		ticket.setPesoTotal(this.pesoTotal);
		ticket.setPrecioTotal(this.precioTotal + ticket.impuesto());
		
		return ticket;
	}
	
}
