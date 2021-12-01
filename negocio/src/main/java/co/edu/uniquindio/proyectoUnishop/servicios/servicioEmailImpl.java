package co.edu.uniquindio.proyectoUnishop.servicios;



import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;


@Component
public class servicioEmailImpl implements ServicioEmail {


    private final JavaMailSender mailSender;

    public servicioEmailImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void SendSimpleMessage(String to, String asunto, String text) {


        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(to);
        msg.setSubject(asunto);
        msg.setText(text);

        mailSender.send(msg);

    }
}
