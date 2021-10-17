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

    /**
     * @param codChat codigo del chat, es la llave primaria de la clase
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codChat;

    /**
     * Relacion usurario comprador
     */
    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuarioComprador;

    /**
     * Relación con producto a comprar
     */
    @ManyToOne
    @JoinColumn(nullable = false)
    private Producto chatProductoCompra;

    /**
     * Relación con lista de mensajes
     */
    @ToString.Exclude
    @OneToMany(mappedBy = "chatUsuario")
    private List<Mensajes>listaMensajes;

    /**
     * Metodo constructor sin parámetros de la entidad Chat
     */
    public  Chat(){
        super();
    }

    /**
     * Metodo constructor de la entidad Chat
     * @param usuarioComprador usuario a comprar
     * @param chatProductoCompra producto por comprar
     */
    public Chat(Usuario usuarioComprador, Producto chatProductoCompra) {
        this.usuarioComprador = usuarioComprador;
        this.chatProductoCompra = chatProductoCompra;
    }
}
