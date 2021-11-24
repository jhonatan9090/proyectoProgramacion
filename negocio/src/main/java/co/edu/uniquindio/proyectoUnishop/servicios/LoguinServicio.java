package co.edu.uniquindio.proyectoUnishop.servicios;

import co.edu.uniquindio.proyectoUnishop.entidades.Persona;
import co.edu.uniquindio.proyectoUnishop.entidades.Usuario;

public interface LoguinServicio {


Usuario loguinPersona(String correo, String password) throws Exception;

Usuario recuperarPassword(String correo,String codigo)throws Exception;




}
