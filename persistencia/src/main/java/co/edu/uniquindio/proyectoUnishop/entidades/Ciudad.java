package co.edu.uniquindio.proyectoUnishop.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Ciudad implements Serializable {

    /**
     * atributos de la clase Ciudad
     * @param codCiudad codigo de la ciudad
     *                  llave primaria de la entidad
     * @param nombre nombre de la ciudad
     *               se le asigna un tamaño maximo de 80 caracteres
     *               no puede ser null
     */
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codCiudad;

    @Column(length = 80,nullable = false)
    private String nombre;

    /**
     * Relacion con la lista de usuarios
     * Uno a muchos
     */
    @OneToMany(mappedBy = "ciudadUsuario")
    @ToString.Exclude
    private List<Usuario>listaUsuarios;

    /**
     * Relacion con la lista de productos
     * Uno a muchos
     */
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
