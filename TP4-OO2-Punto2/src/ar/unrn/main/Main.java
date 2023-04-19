package ar.unrn.main;

import ar.unrn.domain.model.EmailNotificacion;
import ar.unrn.domain.model.EmpleadoRegistro;
import ar.unrn.domain.portsin.DomainException;
import ar.unrn.domain.portsin.Registro;

public class Main {

	public static void main(String[] args) {
		try {
			Registro registroEmpleados = new EmpleadoRegistro("C:\\Users\\ezehu\\git\\TP4-OO2-Punto2\\DataEmpleado.txt",
					new EmailNotificacion("524def57d07409", "a0f84bcbd4913c", "sandbox.smtp.mailtrap.io"));

//			System.out.println(registroEmpleados.toString());

			registroEmpleados.enviarMailDeFelicitacionesACumplañeros();
		} catch (DomainException e) {
			System.out.println(e.getMessage());
		}
	}

}
