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

    //Relacion inversa entre usuario y comentario
    @OneToMany(mappedBy = "usuarioComentario")
    private List<Comentario>listaComentarios;

    @OneToMany(mappedBy = "usuarioSubasta")
    private List<SubastaUsuario>listaSubastasUsuarios;

    //Relacion inversa de la venta de un producto
    @OneToMany(mappedBy = "usuarioVendedor")
    private List<Producto>listaProductos;

    //Relacion inversi de compras de un producto
    @OneToMany(mappedBy = "UsuarioCompra")
    private  List<Compra>listaCompras;

    //relacion inversa producto favorito
    @ManyToMany
    private List<Producto>listaProductoFavorito;

    //Relacion inversa chat comprador
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
