package co.edu.uniquindio.proyectoUnishop.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Map;


@Entity
@Getter @Setter
@ToString
public class Administrador extends Persona implements Serializable {

    /**
     * Metodo constructor sin parámetros de la entidad Administrador
     */
    public Administrador() {
    super();
    }


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
}
