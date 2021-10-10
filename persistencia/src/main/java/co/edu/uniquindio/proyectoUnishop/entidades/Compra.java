package co.edu.uniquindio.proyectoUnishop.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import javax.validation.constraints.Future;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString

public class Compra implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codCompra;

    @Future
    @Column(nullable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaPago;

    @Column(length = 80,nullable = false)
    private String medioPago;

    //Relacion compra de un producto
    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario UsuarioCompra;

    @OneToMany(mappedBy = "compradetalle")
    private List<DetalleCompra>listaDetalleCompra;

    public Compra(){
    super();
    }


    public Compra(@Future LocalDateTime fechaPago, String medioPago, Usuario usuarioCompra, List<DetalleCompra> listaDetalleCompra) {
        this.fechaPago = fechaPago;
        this.medioPago = medioPago;
        UsuarioCompra = usuarioCompra;
        this.listaDetalleCompra = listaDetalleCompra;
    }
}
