package ar.unrn.infrastructure.data;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ar.unrn.domain.portsout.Fecha;

public class HelpDate implements Fecha {

	private LocalDate fecha;

	public HelpDate() {
		super();
		fecha = LocalDate.now();
	}

	public HelpDate(String string) throws ParseException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		fecha = LocalDate.parse(string, formatter);
	}

	@Override
	public String toString() {
		return "HelpDate [fecha=" + fecha + "]";
	}

	@Override
	public LocalDate fecha() {
		return fecha;
	}
}
