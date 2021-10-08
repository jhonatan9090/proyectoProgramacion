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
import java.util.List;


@Entity
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString

public class Comentario implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codComentario;

    @Column(length = 200)
    private String mensaje;

    @Column(length = 200)
    private String respuesta;

    @Future
    @Column(nullable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaComentario;

    @Positive
    @Column(nullable = false)
    private Integer calificacion;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuarioComentario;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Producto comentarioProducto;


    public Comentario(){
    super();
    }


    public Comentario(String mensaje, String respuesta, @Future LocalDateTime fechaComentario, @Positive Integer calificacion, Usuario usuarioComentario, Producto comentarioProducto) {
        this.mensaje = mensaje;
        this.respuesta = respuesta;
        this.fechaComentario = fechaComentario;
        this.calificacion = calificacion;
        this.usuarioComentario = usuarioComentario;
        this.comentarioProducto = comentarioProducto;
    }
}
