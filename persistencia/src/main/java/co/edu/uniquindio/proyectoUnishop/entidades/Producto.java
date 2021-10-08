package co.edu.uniquindio.proyectoUnishop.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;



@Entity
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString

public class Producto implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codProducto;

    @Column(length = 80,nullable = false)
    private String nombre;

    @Positive
    @Column(nullable = false)
    private Integer unidades;

    @Column(length = 200,nullable = false)
    private String descripcion;

    @Positive
    @Column(nullable = false)
    private Double precio;

    @Future
    @Column(nullable = false)
    private LocalDate fechaLimite;

    @Positive
    @Column(nullable = false)
    private Double descuento;

    @ElementCollection
    private List<String> imagenes;

    @ManyToOne
    @JoinColumn(nullable = false)
    private  Usuario usuarioProducto;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Ciudad ciudadProducto;

    @OneToMany(mappedBy = "subastaProducto")
    private List<Subasta>listaSubasta;

    @OneToMany(mappedBy = "ProductoDetalle")
    private  List<DetalleCompra>listaDetalles;

    @OneToMany(mappedBy = "comentarioProducto")
    private List<Comentario>ListaComentariosProductos;

    @ManyToMany(mappedBy = "listaProductoFavorito")
    private List<Usuario>listaUsuariosProductosFavoritos;

    @ManyToMany
    private List<Categoria>listaCategoria;


    public Producto(){
    super();

    }


    public Producto(String nombre, @Positive Integer unidades, String descripcion, @Positive Double precio, @Future LocalDate fechaLimite, @Positive Double descuento, List<String> imagenes, Usuario usuarioProducto, Ciudad ciudadProducto, List<Subasta> listaSubasta, List<DetalleCompra> listaDetalles, List<Comentario> listaComentariosProductos, List<Usuario> listaUsuariosProductosFavoritos, List<Categoria> listaCategoria) {
        this.nombre = nombre;
        this.unidades = unidades;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaLimite = fechaLimite;
        this.descuento = descuento;
        this.imagenes = imagenes;
        this.usuarioProducto = usuarioProducto;
        this.ciudadProducto = ciudadProducto;
        this.listaSubasta = listaSubasta;
        this.listaDetalles = listaDetalles;
        ListaComentariosProductos = listaComentariosProductos;
        this.listaUsuariosProductosFavoritos = listaUsuariosProductosFavoritos;
        this.listaCategoria = listaCategoria;
    }
}
