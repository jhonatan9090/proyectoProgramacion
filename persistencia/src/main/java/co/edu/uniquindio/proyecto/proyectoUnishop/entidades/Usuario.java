package co.edu.uniquindio.proyecto.proyectoUnishop.entidades;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Entidad para Usuario
 */
@Entity
@Getter @Setter
@ToString
public class Usuario extends Persona implements Serializable {

    @ManyToOne
   // @JoinColumn(nullable = false)
    private  Ciudad ciudadUsuario; //ciudad del usuario

    // Relacion inversa entre usuario y comentario
    @OneToMany(mappedBy = "usuarioComentario")
    @ToString.Exclude
    private List<Comentario>listaComentarios;

    @OneToMany(mappedBy = "usuarioSubasta")
    private List<SubastaUsuario>listaSubastasUsuarios;

    // Relacion inversa de la venta de un producto
    @OneToMany(mappedBy = "usuarioVendedor")
    @ToString.Exclude

    // lista de productos del usuario
    private List<Producto>listaProductos;

    //  Relacion inversi de compras de un producto
    @OneToMany(mappedBy = "UsuarioCompra")
    @ToString.Exclude
    private  List<Compra>listaCompras;

    // relacion inversa producto favorito
    @ManyToMany
    @ToString.Exclude
    private List<Producto>listaProductoFavorito;

    // Relacion inversa chat comprador
    @OneToMany(mappedBy = "usuarioComprador")
    @ToString.Exclude
    private List<Chat>ListChatComprador;

    /**
     * Metodo constructor sin parámetros de la entidad Usuario
     */
    public Usuario() {
    super();
    }

    /**
     * Metodo constructor de la entidad Usuario
     * @param codPersona codigo del usuario
     * @param nombre nombre del usuario
     * @param email email del usuario
     * @param password contraseña del usuario
     * @param telefono telefonos del usuario
     * @param ciudadUsuario ciudad del usuario
     */
    public Usuario(String codPersona, String nombre, String email, String password, Map<String, String> telefono, Ciudad ciudadUsuario) {
        super(codPersona, nombre, email, password, telefono);
        this.ciudadUsuario = ciudadUsuario;
    }

    @Override
    public String toString() {
        return super.toString()+", ciudad=" + ciudadUsuario;
    }
}
