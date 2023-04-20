package ar.unrn.infrastructure.data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

import ar.unrn.domain.model.Empleados;
import ar.unrn.domain.model.HelpDate;
import ar.unrn.domain.portsout.Empleado;
import ar.unrn.domain.portsout.LectorArchivo;

public class EnDiscoLectorArchivo implements LectorArchivo {

	private Empleados empleados;

	public EnDiscoLectorArchivo(String urlArchivo) throws InfrastructureException {

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
			throw new InfrastructureException("EnDiscoLectorArchivo FileNotFoundException");
		} catch (IOException e) {
			throw new InfrastructureException("EnDiscoLectorArchivo IOException");
		} catch (NullPointerException e) {
			throw new InfrastructureException("EnDiscoLectorArchivo NullPointerException");
		} catch (ParseException e) {
			throw new InfrastructureException("EnDiscoLectorArchivo ParseException");
		}
	}

	@Override
	public Empleados empleadosQueCumplenAniosHoy() {
//		Empleados listaCumpleañeros = new Empleados();
//	
//		return listaCumpleañeros;
		return empleados.listaCumpleañeros();
	}
}
