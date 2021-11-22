package co.edu.uniquindio.proyectoUnishop.bean;

import co.edu.uniquindio.proyectoUnishop.entidades.Usuario;
import co.edu.uniquindio.proyectoUnishop.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;



@Component
@ViewScoped
public class LoguinBean {

    @Getter
    @Setter
    private Usuario usuario;


    private final UsuarioServicio usuarioServicio;

    public LoguinBean(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @PostConstruct
    public void inicializar() {
        usuario = new Usuario();
    }

    public  void loguearUsuario(String correo,String password){


        try {
            usuarioServicio.loguearUsuario(correo,password);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
