package co.edu.uniquindio.proyectoUnishop.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import java.io.Serializable;

@Scope("session")
@Component
public class SeguridadBean implements Serializable {

    @Getter @Setter
    private String valor;

    public void cambiarDato(){

    }
}
