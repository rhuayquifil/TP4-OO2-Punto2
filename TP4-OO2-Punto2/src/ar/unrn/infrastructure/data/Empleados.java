package ar.unrn.infrastructure.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ar.unrn.domain.portsout.Empleado;

public class Empleados {

	private Set<Empleado> listaEmpleados;

	public Empleados() {
		super();
		this.listaEmpleados = new HashSet<Empleado>();
	}

	public void agregar(Empleado empleado) {
		listaEmpleados.add(empleado);
	}

	@Override
	public String toString() {
		return "Empleados [listaEmpleados=" + listaEmpleados + "]";
	}

	public List<Empleado> listaCumpleañerosDeLaFecha() {
		List<Empleado> listaCumpleañeros = new ArrayList<Empleado>();

		LocalDate fechaHoy = LocalDate.now();

		for (Empleado empleado : listaEmpleados) {
			if (fechaHoy.equals(empleado.fechaNacimiento())) {
				listaCumpleañeros.add(empleado);
			}
		}
		return listaCumpleañeros;
	}
}
