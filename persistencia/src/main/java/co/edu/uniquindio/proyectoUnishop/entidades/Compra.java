package co.edu.uniquindio.proyectoUnishop.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import javax.validation.constraints.Future;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Entity
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString

public class Compra implements Serializable {

    /**
     * Atributos de la entidad Compra
     * @param codCompra llave primaria de la entidad
     * @param fechaPago fecha de pago de la compra
     * @param medioPago medio de pago de la compra
     * @param usuarioCompra usuario a realizar la compra
     * @param listaDetalleCompra lista de detalle de la compra
     */
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codCompra;

    @Column(nullable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private @Future LocalDate fechaPago;

    @Column(length = 80,nullable = false)
    private String medioPago;

    /**
     * Relacion compra de un producto
     */
    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario UsuarioCompra;

    /**
     * Relacion con la lista de detalle de la compra
     */
    @ToString.Exclude
    @OneToMany(mappedBy = "compradetalle")
    private List<DetalleCompra>listaDetalleCompra;


    /**
     * Constructor sin parametros de la entidadad Compra
     */
    public Compra(){
    super();
    }

    /**
     * Constructor de la entidad Compra
     * @param fechaPago fecha de pago de la compra
     * @param medioPago medio de pago de la compra
     * @param usuarioCompra usuario a realizar la compra
     */
    public Compra(@Future LocalDate fechaPago, String medioPago, Usuario usuarioCompra) {

        this.fechaPago = fechaPago;
        this.medioPago = medioPago;
        UsuarioCompra = usuarioCompra;

    }
}
