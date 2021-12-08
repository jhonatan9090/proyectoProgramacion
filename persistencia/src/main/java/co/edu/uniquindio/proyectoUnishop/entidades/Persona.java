package co.edu.uniquindio.proyectoUnishop.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Map;

/**
 * Entidad para Persona
 */


@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
public class Persona implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String codPersona; //Llave primaria, codigo de Persona

    @Column(length = 30,nullable = false)
    @NotBlank(message = "el nombre no puede estar vacio")
    private String nombre; //Nombre de la persona

    @Column(length = 100,nullable = false,unique = true)
    @Email(message = "el email debe tener arroba")
    @NotEmpty(message = "el email no puede estar vacio")
    private String email; //email de la persona

    @Column(length = 10,nullable = false,unique = true)
    @NotBlank(message = "la contraseña no puede estar vacia")
    //@JsonIgnore
    private String password; //contraseña de persona

    @ElementCollection
    private Map<String,String> telefono; //Telefonos que tiene la persona

}
