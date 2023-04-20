package ar.unrn.main;

import ar.unrn.domain.model.EmpleadoRegistro;
import ar.unrn.domain.portsin.Registro;
import ar.unrn.domain.portsout.DomainException;
import ar.unrn.infrastructure.data.EmailNotificacion;
import ar.unrn.infrastructure.data.EnDiscoLectorArchivo;
import ar.unrn.infrastructure.data.InfrastructureException;

public class Main {

	public static void main(String[] args) {
		try {
			Registro registroEmpleados = new EmpleadoRegistro(
					new EnDiscoLectorArchivo("C:\\Users\\ezehu\\git\\TP4-OO2-Punto2\\DataEmpleado.txt"),
					new EmailNotificacion("524def57d07409", "a0f84bcbd4913c", "sandbox.smtp.mailtrap.io"));

//			System.out.println(registroEmpleados.toString());

			registroEmpleados.enviarMailDeFelicitacionesACumplañeros();
		} catch (DomainException | InfrastructureException e) {
			System.out.println(e.getMessage());
		}
	}

}
