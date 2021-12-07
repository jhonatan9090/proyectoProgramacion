package co.edu.uniquindio.proyectoUnishop.converter;

import co.edu.uniquindio.proyectoUnishop.entidades.Categoria;
import co.edu.uniquindio.proyectoUnishop.servicios.CategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.io.Serializable;


@Component
public class CategoriaConverter implements Converter<Categoria>, Serializable {

    @Autowired
    CategoriaServicio categoriaServicio;


    @Override
    public Categoria getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {

        Categoria categoria=null;

        try {
            categoria= categoriaServicio.obtenerCategoria(Integer.parseInt(s));
        } catch (Exception e) {
            e.printStackTrace();
        }


        return categoria;
    }

    /**
     * esge metodo se encarga de listar las categorias
     * @param facesContext
     * @param uiComponent
     * @param categoria
     * @return
     */
    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Categoria categoria) {

        if(categoria!=null){

            return categoria.getCodCategoria().toString();
        }
        return "";



    }
}
