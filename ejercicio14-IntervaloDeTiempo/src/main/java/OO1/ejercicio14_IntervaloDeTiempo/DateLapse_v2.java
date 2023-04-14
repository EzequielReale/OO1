package OO1.ejercicio14_IntervaloDeTiempo;

import java.time.LocalDate;

public class DateLapse_v2 implements IDateLapse {

	private LocalDate from;
	private long sizeInDays;
	
	public DateLapse_v2(LocalDate from, long sizeInDays) {
		this.from = from;
		this.sizeInDays = sizeInDays;
	}
	
	@Override
	public LocalDate getFrom() {
		return this.from;
	}

	@Override
	public LocalDate getTo() {
		return this.from.plusDays(this.sizeInDays);
	}

	@Override
	public long sizeInDays() {
		return this.sizeInDays();
	}

	@Override
	public boolean includesDate(LocalDate other) {
		return other.isAfter(this.getFrom()) && other.isBefore(this.getTo())
			   || other.equals(this.getFrom()) || other.equals(this.getTo());
	}

	@Override
	public boolean overlaps(IDateLapse anotherDateLapse) {
		return !(anotherDateLapse.getFrom().isBefore(this.getFrom()) && anotherDateLapse.getTo().isBefore(this.getFrom())
			   || anotherDateLapse.getFrom().isAfter(this.getTo()) && anotherDateLapse.getTo().isAfter(this.getTo()));
	}
}
