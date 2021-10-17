package co.edu.uniquindio.proyectoUnishop.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Chat  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codChat;

    //Relacion usurario comprador
    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuarioComprador;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Producto chatProductoCompra;
    @ToString.Exclude
    @OneToMany(mappedBy = "chatUsuario")
    private List<Mensajes>listaMensajes;




    public  Chat(){

        super();
    }

    public Chat(Usuario usuarioComprador, Producto chatProductoCompra) {
        this.usuarioComprador = usuarioComprador;
        this.chatProductoCompra = chatProductoCompra;
    }
}
