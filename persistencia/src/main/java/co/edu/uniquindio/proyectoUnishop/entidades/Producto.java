package co.edu.uniquindio.proyectoUnishop.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


/**
 * Entidad para  Producto
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Producto implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codProducto; //Llave primaria

    @NotBlank(message = "el nombre no puede estar vacio")
    @Column(length = 80, nullable = false)
    private String nombre; // nombre del producto

    @PositiveOrZero
    @Column(nullable = false)
    private Integer unidades; //Cantidad de productos disponibles

    @Lob
    @NotBlank(message = "la descripcion no puede estar vacio")
    @Column(length = 200, nullable = false)
    private String descripcion; //Descripcion del producto

    @Positive
    @Column(nullable = false)
    private Double precio; //precio del producto

    @Future
    @Column(nullable = false)
    private LocalDate fechaLimite; //Fecha limite del producto

    @PositiveOrZero
    @Column(nullable = false)
    private Double descuento; //Descuento del producto

    //@JoinColumn(nullable = false)
    @ElementCollection
    private List<String> imagenes; //imagenes para el producto

    // Relacion de la venta de un producto
    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuarioVendedor;

    //Relacion con la ciudad del producto
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    //@JoinColumn(nullable = false)
    private Ciudad ciudadProducto;

    // Relacion inversa entre subasta y producto
    @OneToMany(mappedBy = "subastaProducto")
    @ToString.Exclude
    @JsonIgnore
    private List<Subasta> listaSubasta;

    // Relacion inversa de compra con detalla
    @OneToMany(mappedBy = "ProductoDetalle")
    @ToString.Exclude
    @JsonIgnore
    private List<DetalleCompra> listaDetalles;

    // Relacion inversa del comentario de un producto
    @OneToMany(mappedBy = "comentarioProducto", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @JsonIgnore
    private List<Comentario> ListaComentariosProductos;

    // Relacion de productos favoritos
    @ManyToMany(mappedBy = "listaProductoFavorito")
    @ToString.Exclude
    @JsonIgnore
    private List<Usuario> listaUsuariosProductosFavoritos;

    // Relacion con la lista de chat
    @OneToMany(mappedBy = "chatProductoCompra", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @JsonIgnore
    private List<Chat> listaChatProducto;

    // Relacion con la lista de categorias
    @ManyToMany
    @ToString.Exclude
    @JsonIgnore
    private List<Categoria> listaCategoria;


    /**
     * Constructor de la entidad Producto
     */
    public Producto() {
        super();

    }

    /**
     * Constructor de la entidad Producto
     *
     * @param nombre          Nombre del producto
     * @param unidades        cantidad de unidades del producto
     * @param descripcion     descripcion del producto
     * @param precio          precio del producto
     * @param fechaLimite     Fecha limite del produto
     * @param descuento       Descuento del producto
     * @param imagenes        Imagen del producto
     * @param usuarioProducto Usuario a comprar el producto
     * @param ciudadProducto  Ciudad del producto
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


    public String getImagenPrincipal() {

        if (imagenes != null && !imagenes.isEmpty()) {

            return imagenes.get(0);

        }
        return "default.png";
    }

    public String getCategoria(List<Categoria> listaCategoria) {

        String salida = "";

        for (Categoria c : listaCategoria) {

            salida = c.getNombre() + "," + salida;

        }
        return salida;

    }
}
