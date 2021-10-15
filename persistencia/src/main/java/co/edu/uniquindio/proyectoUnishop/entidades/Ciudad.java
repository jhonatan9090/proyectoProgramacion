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


    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codCiudad;
    //nombre de la ciudad
    @Column(length = 80,nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "ciudadUsuario")
    @ToString.Exclude
    private List<Usuario>listaUsuarios;

    @OneToMany(mappedBy = "ciudadProducto")
    @ToString.Exclude
    private List<Producto>listaProductos;

    public Ciudad() {
    super();
    }

    public Ciudad(String nombre) {
        this.nombre = nombre;

    }
}
