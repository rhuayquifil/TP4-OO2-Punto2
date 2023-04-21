package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ar.unrn.domain.model.EmpleadoRegistro;
import ar.unrn.domain.portsin.Registro;
import ar.unrn.domain.portsout.DomainException;
import ar.unrn.domain.portsout.Notificacion;
import ar.unrn.infrastructure.data.EnDiscoLectorArchivo;
import ar.unrn.infrastructure.data.InfrastructureException;

class PruebasUnitarias {

	// PREGUNTAR
	// 1. si es viable preguntarle el resultado a fakeNotificacion, y si es asi como
	// resuelvo el problema de que no reconoce el metodo

	// 2. si la cobertura esta bien

	// 3. como hacer para que no tenga que cambiar la fecha yo del documento y
	// funcione siempre el test

	@Test
	void envioDeEmailACumplañeros() {
		try {
			Notificacion fakeNotificacion = new FakeEmailNotificacion("524def57d07409", "a0f84bcbd4913c",
					"sandbox.smtp.mailtrap.io");

			Registro registroEmpleados = new EmpleadoRegistro(
					new EnDiscoLectorArchivo("C:\\Users\\ezehu\\git\\TP4-OO2-Punto2\\DataEmpleado.txt"),
					fakeNotificacion);

			registroEmpleados.enviarMailDeFelicitacionesACumplañeros();

			assertEquals(1, registroEmpleados.cantidadDeCumpleañerosDeHoy());
//			assertEquals(1, fakeNotificacion.cantidadDeEmailsMandados());

		} catch (DomainException | InfrastructureException e) {
			System.out.println(e.getMessage());
		}
	}

}
