package co.edu.uniquindio.proyecto.proyectoUnishop.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * Entidad Ciudad
 */
@Entity
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Ciudad implements Serializable {

    @Id //llave primaria de la entidad
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codCiudad; //codigo de la ciudad

    @Column(length = 80,nullable = false)
    private String nombre; //nombre de la ciudad


    // Relacion con la lista de usuarios
    @OneToMany(mappedBy = "ciudadUsuario")
    @ToString.Exclude
    private List<Usuario>listaUsuarios;


    //  Relacion con la lista de productos
    @OneToMany(mappedBy = "ciudadProducto")
    @ToString.Exclude
    private List<Producto>listaProductos;

    /**
     * Constructor de la entidad Ciudad
     */
    public Ciudad() {
    super();
    }

    /**
     * Constructor de la entidad Ciudad
     * @param nombre nombre de la ciudad
     */
    public Ciudad(String nombre) {
        this.nombre = nombre;

    }
}
