package co.edu.uniquindio.proyectoUnishop.servicios;

import co.edu.uniquindio.proyectoUnishop.entidades.Persona;
import co.edu.uniquindio.proyectoUnishop.entidades.Usuario;

public interface PersonaServicio
{

    /**
     *
     * @param email este parametro es el correo del usuario previamente registrado para buscarlo
     * @param password este paramerto es el correo que coincide con el correo previamente registrado
     * @throws Exception
     */
    Persona iniciarSesion(String email, String password) throws Exception;

    Persona recuperarPassword(String codPersona,String correo)throws Exception;
}
