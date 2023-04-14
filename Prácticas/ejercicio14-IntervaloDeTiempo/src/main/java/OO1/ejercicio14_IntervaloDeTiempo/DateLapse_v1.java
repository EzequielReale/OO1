package OO1.ejercicio14_IntervaloDeTiempo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapse_v1 implements IDateLapse {

	private LocalDate from, to;

	public DateLapse_v1(LocalDate from, LocalDate to) {
		this.from = from;
		this.to = to;
	}
	
	@Override
	public LocalDate getFrom() {
		return from;
	}

	@Override
	public LocalDate getTo() {
		return to;
	}

	@Override
	public long sizeInDays() {
		return ChronoUnit.DAYS.between(this.getFrom(), this.getTo());
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
