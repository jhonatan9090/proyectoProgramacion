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






    public Administrador() {
    super();

    }

    public Administrador(String codPersona, String nombre, String email, String password, Map<String, String> telefono) {
        super(codPersona, nombre, email, password, telefono);
    }
}
