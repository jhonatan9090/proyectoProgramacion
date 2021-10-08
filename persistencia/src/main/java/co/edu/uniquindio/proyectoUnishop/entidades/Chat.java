package co.edu.uniquindio.proyectoUnishop.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Chat  implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String codChat;


    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuarioComprador;

    @OneToMany(mappedBy = "chatUsuario")
    private List<Mensajes>listaMensajes;


    public Chat(Usuario usuarioComprador, List<Mensajes> listaMensajes) {
        this.usuarioComprador = usuarioComprador;
        this.listaMensajes = listaMensajes;
    }
}
