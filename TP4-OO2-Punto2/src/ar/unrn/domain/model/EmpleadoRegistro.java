package ar.unrn.domain.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

import ar.unrn.domain.portsin.DomainException;
import ar.unrn.domain.portsin.Empleado;
import ar.unrn.domain.portsin.Registro;

public class EmpleadoRegistro implements Registro {

	private Empleados empleados;
	private Notificacion notificacion;

	public EmpleadoRegistro(String urlArchivo, Notificacion notificacion) throws DomainException {
		super();

		this.empleados = new Empleados();
		this.notificacion = notificacion;

		try {
			String cadena;

			FileReader f = new FileReader(urlArchivo);

			BufferedReader b = new BufferedReader(f);

			while ((cadena = b.readLine()) != null) {
				String[] parts = cadena.split(", ");
				empleados.agregar(new Empleado(parts[0], parts[1], new HelpDate(parts[2]), parts[3]));
			}

			b.close();
		} catch (FileNotFoundException e) {
			throw new DomainException("EmpleadoRegistro FileNotFoundException");
		} catch (IOException e) {
			throw new DomainException("EmpleadoRegistro IOException");
		} catch (NullPointerException e) {
			throw new DomainException("EmpleadoRegistro NullPointerException");
		} catch (ParseException e) {
			throw new DomainException("EmpleadoRegistro ParseException");
		}
	}

	@Override
	public String toString() {
		return "EmpleadoRegistro [empleados=" + empleados + "]";
	}

	@Override
	public void enviarMailDeFelicitacionesACumplañeros() {
		empleados.enviarMailDeFelizCumpleaños(notificacion);
	}
}
