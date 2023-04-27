package ar.unrn.infrastructure.data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import ar.unrn.domain.portsout.Empleado;
import ar.unrn.domain.portsout.InfrastructureExceptions;
import ar.unrn.domain.portsout.LeerDatos;

public class EnDiscoLeerDatos implements LeerDatos {

	private Empleados empleados;

	public EnDiscoLeerDatos(String urlArchivo) throws InfrastructureExceptions {

		this.empleados = new Empleados();

		try {
			String cadena;

			FileReader f = new FileReader(urlArchivo);

			BufferedReader b = new BufferedReader(f);

			agregarEmpleados(b);

			b.close();
		} catch (FileNotFoundException e) {
			throw new InfrastructureExceptions("EnDiscoLectorArchivo FileNotFoundException");
		} catch (IOException e) {
			throw new InfrastructureExceptions("EnDiscoLectorArchivo IOException");
		} catch (NullPointerException e) {
			throw new InfrastructureExceptions("EnDiscoLectorArchivo NullPointerException");
		} catch (ParseException e) {
			throw new InfrastructureExceptions("EnDiscoLectorArchivo ParseException");
		}
	}

	private void agregarEmpleados(BufferedReader b) throws IOException, ParseException {
		String cadena;
		while ((cadena = b.readLine()) != null) {
			String[] parts = cadena.split(", ");
			empleados.agregar(new Empleado(parts[0], parts[1], new HelpDate(parts[2]), parts[3]));
		}
	}

	@Override
	public List<Empleado> empleadosQueCumplenAniosHoy() {
		return empleados.listaCumpleañerosDeLaFecha();
	}
}
