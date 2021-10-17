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

    /**
     * Atributos de la entidad Mensaje
     * @param codMensaje
     * @param mensaje
     * @param emisor
     * @param fechaMensaje
     * @param chatUsuario
     */
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codMensaje;

    @Column(length = 200,nullable = false)
    private String mensaje;

    @Column(length = 80,nullable = false)
    private String emisor;

    //@Future
    @Column(nullable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaMensaje;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Chat chatUsuario;

    /**
     * Constructor sin parametros de la entidad Mensajes
     */
    public Mensajes() {
        super();
    }

    /**
     * Constructor de la entidad Mensajes
     * @param mensaje mensaje
     * @param emisor codigo de la persona que manda el mensaje
     * @param fechaMensaje fecxha del envio del mensaje
     * @param chatUsuario Chat del usuario que envia el mensaje
     */
    public Mensajes(String mensaje, String emisor, @Future LocalDateTime fechaMensaje, Chat chatUsuario) {
        this.mensaje = mensaje;
        this.emisor = emisor;
        this.fechaMensaje = fechaMensaje;
        this.chatUsuario = chatUsuario;
    }
}
