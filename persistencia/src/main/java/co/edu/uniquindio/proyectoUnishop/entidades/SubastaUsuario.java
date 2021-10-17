package co.edu.uniquindio.proyectoUnishop.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString

public class SubastaUsuario implements Serializable {

    /**
     * Atributos de la entidad SubastaUsuario
     * @param codSubastaUsuario dicta el valor del producto, llave primaria
     * @param valor costo de la subasta
     * @param fechaSubasta fecha de publicacion de la subasta
     * @param usuarioSubasta  usuario que hace la subasta del producto
     * @param subastaUsuario subasta del producto
     */
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codSubastaUsuario;

    @Positive
    @Column(nullable = false)
    private Double valor;

    //@Future
    @Column(nullable = false)
    private LocalDateTime fechaSubasta;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuarioSubasta;

    /**
     * Relacion de usarios que subastaran
     */
    @ManyToOne
    @JoinColumn(nullable = false)
    private Subasta subastaUsuario;

    /**
     * Constructor sin parametrosde la entidad SubastaUsuario
     */
    public SubastaUsuario(){
        super();
    }

    /**
     * Constructor de la entidad SubastaUsuario
     * @param valor costo de la subasta
     * @param fechaSubasta fecha de publicacion de la subasta
     * @param usuarioSubasta  usuario que hace la subasta del producto
     * @param subastaUsuario subasta del producto
     */
    public SubastaUsuario(@Positive Double valor, @Future LocalDateTime fechaSubasta, Usuario usuarioSubasta, Subasta subastaUsuario) {
        this.valor = valor;
        this.fechaSubasta = fechaSubasta;
        this.usuarioSubasta = usuarioSubasta;
        this.subastaUsuario = subastaUsuario;
    }
}
