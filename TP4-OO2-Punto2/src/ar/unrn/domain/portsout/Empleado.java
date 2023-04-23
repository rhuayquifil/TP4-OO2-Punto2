package ar.unrn.domain.portsout;

import java.time.LocalDate;

public record Empleado(String nombre, String apellido, Fecha fecha, String email) {

	public LocalDate fechaNacimiento() {
		return fecha.fecha();
	}

}
