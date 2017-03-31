package br.com.alura.enviadorEmail;

import java.util.HashMap;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailService {
  public void enviar(String nome, String emailConvidado, HashMap<String, String> rootCredentials) {
    try {
      Email email = new SimpleEmail();
      email.setHostName("smtp.googlemail.com");
      email.setSslSmtpPort("465");
      email.setAuthenticator(new DefaultAuthenticator(String.valueOf(rootCredentials.get(
        "usuario")), String.valueOf(rootCredentials.get("senha"))));
      email.setSSLOnConnect(true);

      email.setFrom(emailConvidado);
      email.setSubject("Você foi convidado pela lista VIP");
      email.setMsg("Olá " + nome + " Você acaba de ser convidado pelo ListaVIP.");
      email.addTo(emailConvidado);
      email.send();
    } catch (EmailException e) {
      e.printStackTrace();
    }
  }
}
