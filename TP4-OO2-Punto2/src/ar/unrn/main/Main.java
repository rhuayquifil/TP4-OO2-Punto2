package ar.unrn.main;

import ar.unrn.domain.model.EmpleadoRegistro;
import ar.unrn.domain.portsin.DomainException;
import ar.unrn.domain.portsin.Registro;
import ar.unrn.domain.portsout.InfrastructureExceptions;
import ar.unrn.infrastructure.data.EmailNotificacion;
import ar.unrn.infrastructure.data.EnDiscoLeerDatos;

public class Main {

	public static void main(String[] args) {
		try {
			Registro registroEmpleados = new EmpleadoRegistro(
					new EnDiscoLeerDatos("C:\\Users\\ezehu\\git\\TP4-OO2-Punto2\\DataEmpleado.txt"),
					new EmailNotificacion("524def57d07409", "a0f84bcbd4913c", "sandbox.smtp.mailtrap.io"));

			registroEmpleados.enviarMailDeFelicitacionesACumplaneros();
		} catch (DomainException | InfrastructureExceptions e) {
			System.out.println(e.getMessage());
		}
	}

}
