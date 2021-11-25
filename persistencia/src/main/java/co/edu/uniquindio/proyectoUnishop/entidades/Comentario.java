package co.edu.uniquindio.proyectoUnishop.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Entidad Comentario
 */
@Entity
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Comentario implements Serializable {

    @Id //llave primaria
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codComentario; //codigo del comentario

    @NotBlank(message = "el mensaje no puede estar vacio")
    @Lob
    @Column(length = 200)
    private String mensaje; //mensaje del comentario

    @Column(length = 200)
    @NotBlank(message = "la respuesta no puede estar vacia")
    @Lob
    private String respuesta; //respuesta al comentario

    @Column(nullable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private @Future LocalDate fechaComentario; //fecha del Comentario

    @Positive
    @Max(5)
    @Column(nullable = false)
    private Integer calificacion;


    // Relacion de comentarios y usuario
    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuarioComentario;


    // Relacion del comentario sobre un producto
    @ManyToOne
    @JoinColumn(nullable = false)
    private Producto comentarioProducto;


    /**
     * Constructor sin parametros de la entidad Comentario
     */
    public Comentario(){
    super();
    }

    /**
     * Constructor de la entidad Comentario
     * @param mensaje comentario
     * @param respuesta respuesta al comentario
     * @param fechaComentario fecha del Comentario
     * @param calificacion calificacion
     * @param usuarioComentario usuario que realiza el comentario
     * @param comentarioProducto Producto a comentare
     */
    public Comentario(String mensaje, String respuesta, @Future LocalDate fechaComentario, @Positive Integer calificacion
            , Usuario usuarioComentario, Producto comentarioProducto) {
        this.mensaje = mensaje;
        this.respuesta = respuesta;
        this.fechaComentario = fechaComentario;
        this.calificacion = calificacion;
        this.usuarioComentario = usuarioComentario;
        this.comentarioProducto = comentarioProducto;
    }
}
