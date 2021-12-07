package co.edu.uniquindio.proyectoUnishop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import java.util.Properties;


@Configuration
public class configMail {


    @Bean
    /**
     * aqui se almacena la informacion para enviar el correo para restaurar la contraseña de usuario
     */
    public JavaMailSender getJavaMailSender() {

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
/**
 * este es el correo y la contraseña del correo para la r4estauracion
 */
        mailSender.setUsername("alfredogodofredopruebam@gmail.com");
        mailSender.setPassword("LaCosa12345");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

}
