package test;

import ar.unrn.domain.portsout.Notificacion;

public class FakeEmailNotificacion implements Notificacion {

	private final String username;
	private final String password;
	private String hostAddress;
	private int cantidadDeEmailsMandados;

	public FakeEmailNotificacion(String username, String password, String hostAddress) {
		super();
		this.username = username;
		this.password = password;
		this.hostAddress = hostAddress;
		this.cantidadDeEmailsMandados = 0;
	}

	@Override
	public void enviarCorreo(String correoRemitente, String correoDestinatario, String contenidoSujeto,
			String contenidoMensaje) {
		this.cantidadDeEmailsMandados++;
	}

	int cantidadDeEmailsMandados() {
		return cantidadDeEmailsMandados;
	}
}
