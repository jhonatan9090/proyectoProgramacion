package co.edu.uniquindio.proyectoUnishop.bean;

import co.edu.uniquindio.proyectoUnishop.dto.ProductoCarrito;
import co.edu.uniquindio.proyectoUnishop.entidades.Administrador;
import co.edu.uniquindio.proyectoUnishop.entidades.Persona;
import co.edu.uniquindio.proyectoUnishop.entidades.Usuario;
import co.edu.uniquindio.proyectoUnishop.servicios.PersonaServicio;
import co.edu.uniquindio.proyectoUnishop.servicios.ProductoServicio;
import co.edu.uniquindio.proyectoUnishop.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;


@Component
@Scope("session")
public class SeguridadBean implements Serializable {

    @Getter
    @Setter
    private boolean autenticado;

    @Getter
    @Setter
    private String email, password;
    @Getter
    @Setter
    private Persona persona;
    @Getter
    @Setter
    String rol;

    @Getter
    @Setter
    private ArrayList<ProductoCarrito>productosCarrito;

    @Getter
    @Setter
    private Double subtotal;

    @Autowired
    private PersonaServicio personaServicio;

    @Autowired
    private ProductoServicio productoServicio;

    @PostConstruct
    public void inicializar(){

        this.subtotal=0.0;
        this.productosCarrito=new ArrayList<>();


    }

    public String iniciarSesion() {
        if (!email.isEmpty() && !password.isEmpty()) {
            try {
                persona = personaServicio.iniciarSesion(email, password);
                if(persona instanceof Usuario){
                    rol = "usuario";
                } else if(persona instanceof Administrador){
                    rol = "administrador";
                }

                autenticado = true;
                return "index?faces-redirect=true";
            } catch (Exception e) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
                FacesContext.getCurrentInstance().addMessage("login-bean", fm);
            }
        }

        return null;
    }

    public String cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index?faces-redirect=true";
    }

    public String recuperar() {
        return "/recuperarContrasenia.xhtml?faces-redirect=true";
    }


    public void agragarCarrito(Integer id,Double precio,String nombre,String imagen){

           ProductoCarrito pc= new ProductoCarrito(id,nombre,imagen,1,precio);

           if(!productosCarrito.contains(pc)) {
               productosCarrito.add(pc);
               subtotal+=precio;

               FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Producto agregado al carrito");
               FacesContext.getCurrentInstance().addMessage("add-cart", fm);
           }
    }

    public void actualizarSubtotal(){

        subtotal=0.0;
        for(ProductoCarrito p :productosCarrito){

            subtotal+=p.getPrecio()*p.getUnidades();

        }
    }

    public void eliminarCarrito(int indice){

        subtotal-=productosCarrito.get(indice).getPrecio();
        productosCarrito.remove(indice);
    }


    public void comprar(){


        if(persona!=null&&!productosCarrito.isEmpty()) {
            try {
                productoServicio.compraProductos((Usuario) persona,productosCarrito,"PSE");
                productosCarrito.clear();
                subtotal=0.0;

                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "La compra se realizo satisfactoriamente");
                FacesContext.getCurrentInstance().addMessage("compra-msj", fm);
            } catch (Exception e) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
                FacesContext.getCurrentInstance().addMessage("compra-msj", fm);
            }

        }
    }
}
