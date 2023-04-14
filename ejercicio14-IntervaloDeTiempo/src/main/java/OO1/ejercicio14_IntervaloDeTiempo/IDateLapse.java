package OO1.ejercicio14_IntervaloDeTiempo;

import java.time.LocalDate;

public interface IDateLapse {

	public LocalDate getFrom();
	
	public LocalDate getTo();
	
	public long sizeInDays();
	
	public boolean includesDate(LocalDate other);

	public boolean overlaps(IDateLapse anotherDateLapse);
	
}
