package ar.unrn.domain.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import ar.unrn.domain.portsout.Empleado;
import ar.unrn.domain.portsout.Notificacion;

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

	public void enviarMailDeFelizCumpleaños(Notificacion notificacion) {
		LocalDate fechaHoy = LocalDate.now();

		for (Empleado empleado : listaEmpleados) {
			if (fechaHoy.equals(empleado.fechaNacimiento())) {
				notificacion.enviarCorreo("", "", "", "");
			}
		}
	}

	public Empleados listaCumpleañeros() {
		// TODO Auto-generated method stub
		return null;
	}

}
