package co.edu.uniquindio.proyectoUnishop.entidades;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import java.util.Map;

/**
 * Entidad administrador que se extiende se la entidad Persona
 */
@Entity
@Getter @Setter
@ToString

public class Administrador extends Persona {


    /**
     * Metodo constructor de la entidad Administrador
     * @param codPersona codigo del administrador
     * @param nombre nombre del administrador
     * @param email email del administrador
     * @param password contraseña del administrador
     * @param telefono telefonos del administrador
     */
    public Administrador(String codPersona, String nombre, String email, String password, Map<String, String> telefono) {
        super(codPersona, nombre, email, password, telefono);
    }


    public Administrador() {

    }
}
