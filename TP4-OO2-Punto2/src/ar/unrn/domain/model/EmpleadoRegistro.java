package ar.unrn.domain.model;

import ar.unrn.domain.portsin.DomainException;
import ar.unrn.domain.portsin.Registro;
import ar.unrn.domain.portsout.Empleado;
import ar.unrn.domain.portsout.InfrastructureExceptions;
import ar.unrn.domain.portsout.LeerDatos;
import ar.unrn.domain.portsout.Notificacion;

public class EmpleadoRegistro implements Registro {

	private Notificacion notificacion;
	private LeerDatos leerDatos;

	public EmpleadoRegistro(LeerDatos leerDatos, Notificacion notificacion) throws DomainException {
		super();
		this.notificacion = notificacion;
		this.leerDatos = leerDatos;
	}

	@Override
	public void enviarMailDeFelicitacionesACumplaneros() throws DomainException {
		try {
			enviarMailsACumplaneros();
		} catch (InfrastructureExceptions e) {
			throw new DomainException(e.getMessage());

		}

	}

	private void enviarMailsACumplaneros() throws InfrastructureExceptions {
		for (Empleado empleado : leerDatos.empleadosQueCumplenAniosHoy()) {
			notificacion.enviarCorreo("TP4-OO2-Punto2@unrn.com", empleado.email(),
					"Felicitaciones " + empleado.nombre(), "Que todos tus deseos se hagan realidad");
		}
	}
}
