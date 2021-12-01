package co.edu.uniquindio.proyectoUnishop.servicios;

import co.edu.uniquindio.proyectoUnishop.entidades.Persona;
import co.edu.uniquindio.proyectoUnishop.entidades.Usuario;

public interface PersonaServicio
{


    Persona iniciarSesion(String email, String password) throws Exception;

    Persona recuperarPassword(String codPersona,String correo)throws Exception;
}
