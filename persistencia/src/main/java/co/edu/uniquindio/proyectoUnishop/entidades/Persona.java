package co.edu.uniquindio.proyectoUnishop.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;

/**
 * Entidad para Persona
 */



@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@MappedSuperclass
public class Persona implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String codPersona; //Llave primaria, codigo de Persona

    @Column(length = 30,nullable = false)
    private String nombre; //Nombre de la persona

    @Column(length = 100,nullable = false,unique = true)
    private String email; //email de la persona

    @Column(length = 10,nullable = false,unique = true)
    private String password; //contraseña de persona

    @ElementCollection
    private Map<String,String> telefono; //Telefonos que tiene la persona

    public Persona(String codPersona, String nombre, String email, String password, Map<String, String> telefono) {
        this.codPersona = codPersona;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.telefono = telefono;
    }

    /**
     * Constructor sin parametros de la entidad Persona
     */


    public Persona()
    {
        super();
    }
}
