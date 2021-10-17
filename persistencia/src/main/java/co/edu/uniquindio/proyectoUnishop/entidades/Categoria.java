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


    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codCategoria;

    @Column(length = 30,nullable = false,unique = true)
    private String nombre;

    @ManyToMany(mappedBy = "listaCategoria")
    private List<Producto>listaProductosCategorias;

    public Categoria(String nombre) {
        this.nombre = nombre;

    }
}
