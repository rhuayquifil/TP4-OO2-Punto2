package ar.unrn.infrastructure.data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import ar.unrn.domain.portsout.DomainException;
import ar.unrn.domain.portsout.Empleado;
import ar.unrn.domain.portsout.LectorArchivo;

public class EnDiscoLectorArchivo implements LectorArchivo {

	private Empleados empleados;

	public EnDiscoLectorArchivo(String urlArchivo) throws DomainException {

		this.empleados = new Empleados();

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
			throw new DomainException("EnDiscoLectorArchivo FileNotFoundException");
		} catch (IOException e) {
			throw new DomainException("EnDiscoLectorArchivo IOException");
		} catch (NullPointerException e) {
			throw new DomainException("EnDiscoLectorArchivo NullPointerException");
		} catch (ParseException e) {
			throw new DomainException("EnDiscoLectorArchivo ParseException");
		}
	}

	@Override
	public List<Empleado> empleadosQueCumplenAniosHoy() {
		return empleados.listaCumpleañerosDeLaFecha();
	}
}
