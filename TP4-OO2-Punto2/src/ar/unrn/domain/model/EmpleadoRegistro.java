package ar.unrn.domain.model;

import ar.unrn.domain.portsin.Registro;
import ar.unrn.domain.portsout.DomainException;
import ar.unrn.domain.portsout.Empleado;
import ar.unrn.domain.portsout.LectorArchivo;
import ar.unrn.domain.portsout.Notificacion;

public class EmpleadoRegistro implements Registro {

	private Notificacion notificacion;
	private LectorArchivo lectorArchivo;

	public EmpleadoRegistro(LectorArchivo lectorArchivo, Notificacion notificacion) throws DomainException {
		super();
		this.notificacion = notificacion;
		this.lectorArchivo = lectorArchivo;
	}

	@Override
	public void enviarMailDeFelicitacionesACumplañeros() {
		for (Empleado empleado : lectorArchivo.empleadosQueCumplenAniosHoy()) {
			notificacion.enviarCorreo("TP4-OO2-Punto2@unrn.com", empleado.email(),
					"Felicitaciones " + empleado.nombre(), "Que todos tus deseos se hagan realidad");
		}
	}
}
