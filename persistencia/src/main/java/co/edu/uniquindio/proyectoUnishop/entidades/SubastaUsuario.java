package co.edu.uniquindio.proyectoUnishop.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Entidad para Subasta
 */
@Entity
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class SubastaUsuario implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codSubastaUsuario; //llave primaria, codigo de la subasta

    @Positive
    @Column(nullable = false)
    private Double valor; //costo de la subasta

    //@Future
    @Column(nullable = false)
    private LocalDateTime fechaSubasta; //fecha de publicacion de la subasta

    @ManyToOne
    @JoinColumn(nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Usuario usuarioSubasta; // usuario que hace la subasta del producto

    // Relacion de usarios que subastaran
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
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
