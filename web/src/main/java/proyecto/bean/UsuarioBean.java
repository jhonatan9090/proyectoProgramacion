package proyecto.bean;

import co.edu.uniquindio.proyecto.proyecto.servicios.UsuarioServicio;
import co.edu.uniquindio.proyecto.proyectoUnishop.entidades.Usuario;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

@Controller
@Component
@ViewScoped
@RequestMapping("/request")
public class UsuarioBean {
    @Getter
    @Setter
    private Usuario usuario;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @PostConstruct
    public void inicializar() {
        usuario = new Usuario();
    }

    @RequestMapping("/registrar")
    public void registrarUsuario() {
        try {
            usuarioServicio.registrarUsuario(usuario);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Registro exitoso");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
}
