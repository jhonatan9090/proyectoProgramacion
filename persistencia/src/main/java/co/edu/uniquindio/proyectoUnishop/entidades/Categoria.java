package co.edu.uniquindio.proyectoUnishop.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;


@Entity
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Categoria implements Serializable {

    /**
     * atributos de la clase Categoria
     *
     * @param codCategoria codigo de la categoria
     *                     es la llave primaria de la entidad categoria
     *
     * @param nombre nombre de la categoria
     *               se le asigna un tamaño maximo de 30 caracteres
     *               no puede ser null
     *               el nombre no se puede repetir
     *
     * @param listaProductosCategorias
     */

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codCategoria;

    @Column(length = 30,nullable = false,unique = true)
    private String nombre;


    /**
     * Relacion con lista de productos
     * MUchos a muchos
     */
    @ManyToMany(mappedBy = "listaCategoria")
    @ToString.Exclude
    private List<Producto>listaProductosCategorias;


    /**
     * Metodo constructor sin parámetros de la entidad Categoria
     */
    public Categoria() {
        super();
    }

    /**
     * Metodo constructor de la entidad Categoria
     * @param nombre nombre de la categoria
     */
    public Categoria(String nombre) {
        this.nombre = nombre;

    }
}
