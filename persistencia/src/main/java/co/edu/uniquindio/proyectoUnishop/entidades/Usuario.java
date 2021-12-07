package co.edu.uniquindio.proyectoUnishop.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

/**
 * Entidad para Usuario
 */
@Entity
@Getter @Setter
@ToString
public class Usuario extends Persona  {

    @ManyToOne
    @JoinColumn(nullable = true)
    private  Ciudad ciudadUsuario; //ciudad del usuario

    // Relacion inversa entre usuario y comentario
    @OneToMany(mappedBy = "usuarioComentario",cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @JsonIgnore
    private List<Comentario>listaComentarios;

    @OneToMany(mappedBy = "usuarioSubasta",cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<SubastaUsuario>listaSubastasUsuarios;

    // Relacion inversa de la venta de un producto
    @OneToMany(mappedBy = "usuarioVendedor")
    @ToString.Exclude
    @JsonIgnore
    private List<Producto>listaProductos;

    //  Relacion inversi de compras de un producto
    @OneToMany(mappedBy = "UsuarioCompra",cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @JsonIgnore
    private  List<Compra>listaCompras;

    // relacion inversa producto favorito
    @ManyToMany
    @ToString.Exclude
    @JsonIgnore
    private List<Producto>listaProductoFavorito;

    // Relacion inversa chat comprador
    @OneToMany(mappedBy = "usuarioComprador",cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @JsonIgnore
    private List<Chat>ListChatComprador;

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

    public Usuario() {

    }

    @Override
    public String toString() {
        return super.toString()+", ciudad=" + ciudadUsuario;
    }
}
