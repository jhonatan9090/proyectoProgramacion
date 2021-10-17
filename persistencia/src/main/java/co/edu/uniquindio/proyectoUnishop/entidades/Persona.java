package co.edu.uniquindio.proyectoUnishop.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;


@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
@AllArgsConstructor
public class Persona implements Serializable {

    /**
     * Atributos de la entidad Persona
     * @param codPersona
     * @param nombre
     * @param email
     * @param password
     * @param telefono
     */
    @Id
    @EqualsAndHashCode.Include
    private String codPersona;

    @Column(length = 30,nullable = false)
    private String nombre;
    @Column(length = 100,nullable = false,unique = true)
    private String email;
    @Column(length = 10,nullable = false,unique = true)
    private String password;
    @ElementCollection
    private Map<String,String> telefono;

    /**
     * Constructor sin parametros de la entidad Persona
     */
    public Persona(){
    super();
    }




}
