package co.edu.uniquindio.proyectoUnishop.servicios;

/**
 * este metodo se encarga de listar los mensajes de email
 */
public interface ServicioEmail {

    void SendSimpleMessage(String to, String asunto, String text);
}
