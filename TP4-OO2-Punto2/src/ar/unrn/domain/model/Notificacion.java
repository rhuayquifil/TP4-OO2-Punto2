package ar.unrn.domain.model;

public interface Notificacion {

	void enviarCorreo(String correoRemitente, String correoDestinatario, String contenidoSujeto,
			String contenidoMensaje);
}
