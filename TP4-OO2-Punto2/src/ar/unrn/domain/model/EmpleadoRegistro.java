package ar.unrn.domain.model;

import ar.unrn.domain.portsin.Registro;
import ar.unrn.domain.portsout.DomainException;
import ar.unrn.domain.portsout.LectorArchivo;
import ar.unrn.domain.portsout.Notificacion;

public class EmpleadoRegistro implements Registro {

	private Empleados empleados;
	private Notificacion notificacion;
	private LectorArchivo lectorArchivo;

	public EmpleadoRegistro(LectorArchivo lectorArchivo, Notificacion notificacion) throws DomainException {
		super();
		this.notificacion = notificacion;
		this.empleados = new Empleados();
		this.lectorArchivo = lectorArchivo;
	}

	@Override
	public String toString() {
		return "EmpleadoRegistro [empleados=" + empleados + "]";
	}

	@Override
	public void enviarMailDeFelicitacionesACumplañeros() {
		lectorArchivo.empleadosQueCumplenAniosHoy();
	}
}
