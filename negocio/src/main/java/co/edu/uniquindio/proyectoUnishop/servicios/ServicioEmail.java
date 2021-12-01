package co.edu.uniquindio.proyectoUnishop.servicios;

public interface ServicioEmail {

    void SendSimpleMessage(String to, String asunto, String text);
}
