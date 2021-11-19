package co.edu.uniquindio.proyecto.proyectoUnishop.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;

/**
 * Entidad para Persona
 */
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
@AllArgsConstructor
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

    /**
     * Constructor sin parametros de la entidad Persona
     */
    public Persona(){
    super();
    }

}
