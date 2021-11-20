package co.edu.uniquindio.proyectoUnishop.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import javax.validation.constraints.Future;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Entidad Para Mensaje
 */
@Entity
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Mensajes implements Serializable {

    @Id //llave primaria de la entidad
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codMensaje; //codigo de mensaje

    @Column(length = 200,nullable = false)
    private String mensaje;

    @Column(length = 80,nullable = false)
    private String emisor; //nombre de la persona que manda el mensaje

    //@Future
    @Column(nullable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaMensaje; //fecxha del envio del mensaje

    // Relacion entre mensaje y el chat del usuario
    @ManyToOne
    @JoinColumn(nullable = false)
    private Chat chatUsuario; //Chat del usuario que envia el mensaje


    /**
     * Constructor sin parametros de la entidad Mensajes
     */
    public Mensajes() {
        super();
    }

    /**
     * Constructor de la entidad Mensajes
     * @param mensaje mensaje
     * @param emisor nombre de la persona que manda el mensaje
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
