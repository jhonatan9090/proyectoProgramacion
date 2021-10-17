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

    /**
     * Atributos de la clase Producto
     * @param codProducto
     * @param nombre
     * @param unidades Cantidad de productos disponibles
     * @param descripcion Descripcion del producto
     * @param precio  precio del producto
     * @param fechaLimite Fecha limite del producto
     * @param descuento descuento del producto
     * @param imagenes Imagenes de un producto
     * @param usuarioProducto
     * @param ciudadProducto
     * @param listaSubasta
     * @param listaDetalles
     * @param ListaComentariosProductos
     */
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


   // @Future
    @Column(nullable = false)
    private LocalDate fechaLimite;


    @Positive
    @Column(nullable = false)
    private Double descuento;


    @JoinColumn(nullable = false)
    @ElementCollection
    private List<String> imagenes;

    /**
     * Relacion de la venta de un producto
     */
    @ManyToOne
    @JoinColumn(nullable = false)
    private  Usuario usuarioVendedor;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Ciudad ciudadProducto;

    /**
     * Relacion inversa entre subasta y producto
     */
    @OneToMany(mappedBy = "subastaProducto")
    @ToString.Exclude
    private List<Subasta>listaSubasta;

    /**
     * Relacion inversa de compra con detalle
     */
    @OneToMany(mappedBy = "ProductoDetalle")
    @ToString.Exclude
    private  List<DetalleCompra>listaDetalles;

    /**
     *Relacion inversa del comentario de un producto
     */
    @OneToMany(mappedBy = "comentarioProducto")
    @ToString.Exclude
    private List<Comentario>ListaComentariosProductos;

    /**
     * Relacion de productos favoritos
     */
    @ManyToMany(mappedBy = "listaProductoFavorito")
    @ToString.Exclude
    private List<Usuario>listaUsuariosProductosFavoritos;

    /**
     * Relacion con la lista de chat
     */
    @OneToMany(mappedBy = "chatProductoCompra")
    @ToString.Exclude
    private List<Chat>listaChatProducto;

    /**
     * Relacion con la lista de categorias
     */
    @ManyToMany
    @ToString.Exclude
    private List<Categoria>listaCategoria;

    /**
     * Constructor de la entidad Producto
     */
    public Producto(){
    super();

    }

    /**
     * Constructor de la entidad Producto
     * @param nombre Nombre del producto
     * @param unidades cantidad de unidades del producto
     * @param descripcion descripcion del producto
     * @param precio precio del producto
     * @param fechaLimite Fecha limite del produto
     * @param descuento Descuento del producto
     * @param imagenes Imagen del producto
     * @param usuarioProducto Usuario a comprar el producto
     * @param ciudadProducto Ciudad del producto
     */
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
