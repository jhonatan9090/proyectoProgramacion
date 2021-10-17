package co.edu.uniquindio.proyectoUnishop.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;



@Entity
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString

public class DetalleCompra implements Serializable {

    /**
     * Atributos de la entidad DetalleCompra
     * @param codDetalle
     * @param unidades
     * @param precioProducto
     * @param ProductoDetalle
     * @param compradetalle
     */
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codDetalle;

    @Positive
    @Column(nullable = false)
    private Integer unidades;

    @Positive
    @Column(nullable = false)
    private Double precioProducto;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Producto ProductoDetalle;
    //relacion de la compra con detalle
    @ManyToOne
    @JoinColumn(nullable = false)
    private Compra compradetalle;

    /**
     * Constructor sin parametros de la entidad DetalleCompra
     */
    public DetalleCompra(){
    super();
    }

    /**
     * Constructor de la entidad DetalleCompra
     * @param unidades Cantidad de la compra
     * @param precioProducto Costo del producto
     * @param productoDetalle Producto a detallar
     * @param compradetalle Compra a detallar
     */
    public DetalleCompra(@Positive Integer unidades, @Positive Double precioProducto, Producto productoDetalle, Compra compradetalle) {
        this.unidades = unidades;
        this.precioProducto = precioProducto;
        ProductoDetalle = productoDetalle;
        this.compradetalle = compradetalle;
    }
}
