package co.edu.uniquindio.proyectoUnishop.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Map;


@Entity
@Getter @Setter
@ToString

public class Usuario extends Persona implements Serializable {



    @ManyToOne
    @JoinColumn(nullable = false)
    private  Ciudad ciudadUsuario;

    @OneToMany(mappedBy = "usuarioComentario")
    private List<Comentario>listaComentarios;

    @OneToMany(mappedBy = "usuarioSubasta")
    private List<SubastaUsuario>listaSubastasUsuarios;

    @OneToMany(mappedBy = "usuarioProducto")
    private List<Producto>listaProductos;

    @OneToMany(mappedBy = "UsuarioCompra")
    private  List<Compra>listaCompras;

    @ManyToMany
    private List<Producto>listaProductoFavorito;

    @OneToMany(mappedBy = "usuarioComprador")
    private List<Chat>ListChatComprador;

    public Usuario() {
    super();
    }


    public Usuario(String codPersona, String nombre, String email, String password, Map<String, String> telefono, Ciudad ciudadUsuario, List<Comentario> listaComentarios, List<SubastaUsuario> listaSubastasUsuarios, List<Producto> listaProductos, List<Compra> listaCompras, List<Producto> listaProductoFavorito, List<Chat> listChatComprador) {
        super(codPersona, nombre, email, password, telefono);
        this.ciudadUsuario = ciudadUsuario;
        this.listaComentarios = listaComentarios;
        this.listaSubastasUsuarios = listaSubastasUsuarios;
        this.listaProductos = listaProductos;
        this.listaCompras = listaCompras;
        this.listaProductoFavorito = listaProductoFavorito;
        ListChatComprador = listChatComprador;
    }
}
