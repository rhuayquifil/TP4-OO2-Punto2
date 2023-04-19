package ar.unrn.domain.model;

import java.net.PasswordAuthentication;
import java.util.Properties;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailNotificacion implements Notificacion {

	private final String username;
	private final String password;
	private String hostAddress;

	public EmailNotificacion(String username, String password, String hostAddress) {
		super();
		this.username = username;
		this.password = password;
		this.hostAddress = hostAddress;
	}

	@Override
	public void enviarCorreo(String correoRemitente, String correoDestinatario, String contenidoSujeto,
			String contenidoMensaje) {

		// configure Mailtrap's SMTP server details
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", hostAddress);
		props.put("mail.smtp.port", "587");

		// create the Session object
		Session session = Session.getInstance(props, new jakarta.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {
			// create a MimeMessage object
			Message message = new MimeMessage(session);
			// set From email field
			message.setFrom(new InternetAddress(correoRemitente)); // remitente correo
			// set To email field
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(correoDestinatario)); // destinatario
																										// correo
			// set email subject field
			message.setSubject(contenidoSujeto);
			// set the content of the email message
			message.setText(contenidoMensaje);
			// send the email message
			Transport.send(message);

			// ACA LA EMAILEXCEPTIONS

//					System.out.println("Email Message Sent Successfully");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}
}
