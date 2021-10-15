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


    //ciudad del usuario
    @ManyToOne
    @JoinColumn(nullable = false)
    private  Ciudad ciudadUsuario;

    //Relacion inversa entre usuario y comentario
    @OneToMany(mappedBy = "usuarioComentario")
    @ToString.Exclude
    private List<Comentario>listaComentarios;

    @OneToMany(mappedBy = "usuarioSubasta")
    private List<SubastaUsuario>listaSubastasUsuarios;

    //Relacion inversa de la venta de un producto
    @OneToMany(mappedBy = "usuarioVendedor")
    @ToString.Exclude

    private List<Producto>listaProductos;

    //Relacion inversi de compras de un producto
    @OneToMany(mappedBy = "UsuarioCompra")
    @ToString.Exclude
    private  List<Compra>listaCompras;

    //relacion inversa producto favorito
    @ManyToMany
    @ToString.Exclude
    private List<Producto>listaProductoFavorito;

    //Relacion inversa chat comprador
    @OneToMany(mappedBy = "usuarioComprador")
    @ToString.Exclude
    private List<Chat>ListChatComprador;

    public Usuario() {
    super();
    }


    public Usuario(String codPersona, String nombre, String email, String password, Map<String, String> telefono, Ciudad ciudadUsuario) {
        super(codPersona, nombre, email, password, telefono);
        this.ciudadUsuario = ciudadUsuario;

    }

    @Override
    public String toString() {
        return super.toString()+", ciudad=" + ciudadUsuario;
    }
}
