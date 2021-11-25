package co.edu.uniquindio.proyectoUnishop.converter;

import co.edu.uniquindio.proyectoUnishop.entidades.Ciudad;
import co.edu.uniquindio.proyectoUnishop.servicios.CiudadServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.io.Serializable;


@Component
public class CiudadConverter implements Converter<Ciudad>, Serializable {

    @Autowired
    CiudadServicio ciudadServicio;

    @Override
    /**
     * metodo que convierte un componente de tipo ui en unn objeto ciudad
     */

    public Ciudad getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {

        Ciudad ciudad=null;
        try {
            ciudad=ciudadServicio.ObtenerCiudadCodigo(Integer.parseInt(s));
        } catch (Exception e) {
            e.printStackTrace();
        }


        return ciudad;
    }

    @Override

    /**
     * metodo que trae el codigo de una ciudad y lo compara con un componente ui
     *
     */
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Ciudad ciudad) {


        if(ciudad!=null){


            return ciudad.getCodCiudad().toString();
        }
        return "";
    }
}
