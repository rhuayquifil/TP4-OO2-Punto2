package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ar.unrn.domain.model.EmpleadoRegistro;
import ar.unrn.domain.portsin.Registro;
import ar.unrn.domain.portsout.DomainException;

class PruebasUnitarias {

	@Test
	void envioDeEmailACumplañeros() {
		try {
			FakeEmailNotificacion fakeNotificacion = new FakeEmailNotificacion("524def57d07409", "a0f84bcbd4913c",
					"sandbox.smtp.mailtrap.io");

			Registro registroEmpleados = new EmpleadoRegistro(
					new FakeEnDiscoLectorArchivo("C:\\Users\\ezehu\\git\\TP4-OO2-Punto2\\DataEmpleado.txt"),
					fakeNotificacion);

			registroEmpleados.enviarMailDeFelicitacionesACumplañeros();

			assertEquals(3, fakeNotificacion.cantidadDeEmailsMandados());

		} catch (DomainException e) {
			System.out.println(e.getMessage());
		}
	}

}
