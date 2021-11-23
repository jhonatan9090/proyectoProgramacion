package co.edu.uniquindio.proyectoUnishop.servicios;

import co.edu.uniquindio.proyectoUnishop.entidades.Persona;

public interface LoguinServicio {


Persona loguinPersona(String correo,String password) throws Exception;

Persona recuperarPassword(String correo,String codigo)throws Exception;




}
