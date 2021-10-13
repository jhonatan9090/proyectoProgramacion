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

    //Cantidad de productos disponibles
    @Positive
    @Column(nullable = false)
    private Integer unidades;
    //Descripcion del producto
    @Column(length = 200,nullable = false)
    private String descripcion;

    //precio del producto
    @Positive
    @Column(nullable = false)
    private Double precio;

    //Fecha limite del producto
    @Future
    @Column(nullable = false)
    private LocalDate fechaLimite;

    //Precio del producto
    @Positive
    @Column(nullable = false)
    private Double descuento;

    //Imagenes de un producto
    @JoinColumn(nullable = false)
    @ElementCollection
    private List<String> imagenes;

    //Relacion de la venta de un producto
    @ManyToOne
    @JoinColumn(nullable = false)
    private  Usuario usuarioVendedor;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Ciudad ciudadProducto;

    //Relacion inversa entre subasta y producto
    @OneToMany(mappedBy = "subastaProducto")
    private List<Subasta>listaSubasta;

    //Relacion inversa de compra con detalle
    @OneToMany(mappedBy = "ProductoDetalle")
    private  List<DetalleCompra>listaDetalles;

    //Relacion inversa del comentario de un producto
    @OneToMany(mappedBy = "comentarioProducto")
    private List<Comentario>ListaComentariosProductos;

    //Relacion de productos favoritos
    @ManyToMany(mappedBy = "listaProductoFavorito")
    private List<Usuario>listaUsuariosProductosFavoritos;

    @OneToMany(mappedBy = "chatProductoCompra")
    private List<Chat>listaChatProducto;

    @ManyToMany
    private List<Categoria>listaCategoria;


    public Producto(){
    super();

    }


    public Producto(String nombre, @Positive Integer unidades, String descripcion, @Positive Double precio, @Future LocalDate fechaLimite, @Positive Double descuento, List<String> imagenes, Usuario usuarioProducto, Ciudad ciudadProducto) {
        this.nombre = nombre;
        this.unidades = unidades;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaLimite = fechaLimite;
        this.descuento = descuento;
        this.imagenes = imagenes;
        this.usuarioVendedor = usuarioProducto;
        this.ciudadProducto = ciudadProducto;

    }
}
