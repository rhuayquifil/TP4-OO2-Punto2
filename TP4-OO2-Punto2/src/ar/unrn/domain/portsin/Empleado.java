package ar.unrn.domain.portsin;

import java.time.LocalDate;

import ar.unrn.domain.model.Fecha;

public record Empleado(String nombre, String apellido, Fecha fecha, String email) {

	public LocalDate fechaNacimiento() {
		return fecha.fecha();
	}

}
