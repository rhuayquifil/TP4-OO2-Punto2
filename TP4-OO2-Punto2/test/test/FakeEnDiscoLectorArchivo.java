package test;

import java.text.ParseException;
import java.util.List;

import ar.unrn.domain.portsin.DomainException;
import ar.unrn.domain.portsout.Empleado;
import ar.unrn.domain.portsout.LeerDatos;
import ar.unrn.infrastructure.data.Empleados;
import ar.unrn.infrastructure.data.HelpDate;

public class FakeEnDiscoLectorArchivo implements LeerDatos {

	private Empleados empleados;

	public FakeEnDiscoLectorArchivo(String urlArchivo) throws DomainException {

		this.empleados = new Empleados();

		try {
			empleados.agregar(new Empleado("rodrigo", "huayquifil", new HelpDate("2000/08/30"), "eze@hotmail.com"));
			empleados.agregar(new Empleado("octavio", "gonzalez", new HelpDate(), "eze@hotmail.com"));
			empleados.agregar(new Empleado("franco", "carranza", new HelpDate(), "eze@hotmail.com"));
			empleados.agregar(new Empleado("manuel", "fernandez", new HelpDate("2000/08/30"), "eze@hotmail.com"));
			empleados.agregar(new Empleado("maxi", "esteban", new HelpDate(), "eze@hotmail.com"));
		} catch (ParseException e) {
			throw new DomainException("FakeEnDiscoLectorArchivo ParseException");
		}
	}

	@Override
	public List<Empleado> empleadosQueCumplenAniosHoy() {
		return empleados.listaCumpleañerosDeLaFecha();
	}
}
