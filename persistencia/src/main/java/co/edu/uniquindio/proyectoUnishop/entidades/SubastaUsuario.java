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

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codSubastaUsuario;

    @Positive
    @Column(nullable = false)
    private Double valor;

    @Future
    @Column(nullable = false)
    private LocalDateTime fechaSubasta;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuarioSubasta;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Subasta subastaUsuario;

    public SubastaUsuario(){
        super();

    }

    public SubastaUsuario(@Positive Double valor, @Future LocalDateTime fechaSubasta, Usuario usuarioSubasta, Subasta subastaUsuario) {
        this.valor = valor;
        this.fechaSubasta = fechaSubasta;
        this.usuarioSubasta = usuarioSubasta;
        this.subastaUsuario = subastaUsuario;
    }
}
