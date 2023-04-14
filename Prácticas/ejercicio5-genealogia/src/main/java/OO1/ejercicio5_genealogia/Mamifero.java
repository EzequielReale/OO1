package OO1.ejercicio5_genealogia;

import java.time.LocalDate;

public class Mamifero {

	private String identificador, especie;
	private Mamifero padre, madre;
	private LocalDate fechaNacimiento;
	
	public Mamifero(String identificador) {
		this.identificador = identificador;
	}
	
	public Mamifero(){}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public Mamifero getPadre() {
		return padre;
	}

	public void setPadre(Mamifero padre) {
		this.padre = padre;
	}

	public Mamifero getMadre() {
		return madre;
	}

	public void setMadre(Mamifero madre) {
		this.madre = madre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Mamifero getAbueloMaterno() {
		return (this.madre != null) ? this.madre.getPadre() : null;
		//if (this.madre != null) return this.madre.getPadre();
		//return null;
	}
	
	public Mamifero getAbuelaMaterna() {
		return (this.madre != null) ? this.madre.getMadre() : null;
	}
	
	public Mamifero getAbueloPaterno() {
		return (this.padre != null) ? this.padre.getPadre() : null;
	}
	
	public Mamifero getAbuelaPaterna() {
		return (this.padre != null) ? this.padre.getMadre() : null;
	}
	
	
	//Original mejorado
	private boolean esAncestro(Mamifero unMamifero, Mamifero padre) {
		return padre != null && (padre.equals(unMamifero) || padre.tieneComoAncestroA(unMamifero));
	}
	
	public boolean tieneComoAncestroA(Mamifero unMamifero) {
		return this.esAncestro(unMamifero, this.getPadre()) || this.esAncestro(unMamifero, this.getMadre());
	}
	
	//Una linea
	/*public boolean tieneComoAncestroA(Mamifero unMamifero) {
		return ((this.getPadre() != null && this.getPadre().equals(unMamifero))
			 || (this.getMadre() != null && this.getMadre().equals(unMamifero))
			 || (this.getMadre() != null && this.getMadre().tieneComoAncestroA(unMamifero)) 
			 || (this.getPadre() != null && this.getPadre().tieneComoAncestroA(unMamifero)));
	}*/
	
	
	//Lautaro
	/*public boolean tieneComoAncestroA(Mamifero unMamifero) {
        return ((this.padre != null && this.tieneComoAncestroRec(this.padre, unMamifero)) || (this.madre != null && this.tieneComoAncestroRec(this.madre, unMamifero)));
    }

    private boolean tieneComoAncestroRec(Mamifero ancestro, Mamifero buscado) {
        return (ancestro.equals(buscado)) ? true : ancestro.tieneComoAncestroA(buscado);
    }*/
}
