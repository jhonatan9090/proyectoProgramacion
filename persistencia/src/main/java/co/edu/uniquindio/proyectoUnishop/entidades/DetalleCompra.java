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

    @ManyToOne
    @JoinColumn(nullable = false)
    private Compra compradetalle;

    public DetalleCompra(){
    super();
    }


    public DetalleCompra(@Positive Integer unidades, @Positive Double precioProducto, Producto productoDetalle, Compra compradetalle) {
        this.unidades = unidades;
        this.precioProducto = precioProducto;
        ProductoDetalle = productoDetalle;
        this.compradetalle = compradetalle;
    }
}
