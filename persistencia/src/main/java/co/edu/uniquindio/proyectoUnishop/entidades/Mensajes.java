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

public class Mensajes implements Serializable {


    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codMensaje;

    @Column(length = 200,nullable = false)
    private String mensaje;

    @Column(length = 80,nullable = false)
    private String emisor;

    @Future
    @Column(nullable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaMensaje;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Chat chatUsuario;

    public Mensajes() {
        super();
    }


    public Mensajes(String mensaje, String emisor, @Future LocalDateTime fechaMensaje, Chat chatUsuario) {
        this.mensaje = mensaje;
        this.emisor = emisor;
        this.fechaMensaje = fechaMensaje;
        this.chatUsuario = chatUsuario;
    }
}
