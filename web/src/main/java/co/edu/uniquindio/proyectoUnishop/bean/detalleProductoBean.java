package co.edu.uniquindio.proyectoUnishop.bean;


import co.edu.uniquindio.proyectoUnishop.entidades.Comentario;
import co.edu.uniquindio.proyectoUnishop.entidades.Producto;
import co.edu.uniquindio.proyectoUnishop.servicios.ComentarioServicio;
import co.edu.uniquindio.proyectoUnishop.servicios.ProductoServicio;
import co.edu.uniquindio.proyectoUnishop.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;


@Component
@ViewScoped
public class detalleProductoBean implements Serializable {


    private final ProductoServicio productoServicio;
    private final UsuarioServicio usuarioServicio;
    private final ComentarioServicio comentarioServicio;


    @Value("#{param['producto']}")
    private String codProducto;


    @Getter
    @Setter
    private Producto producto;


    @Getter
    @Setter
    private Integer calificacionPromedio;

    @Getter
    @Setter
    private Comentario nuevoComentario;

    @Getter
    @Setter
    private List<Comentario>listaComentarios;

    public detalleProductoBean(ProductoServicio productoServicio, UsuarioServicio usuarioServicio, ComentarioServicio comentarioServicio) {
        this.productoServicio = productoServicio;
        this.usuarioServicio = usuarioServicio;
        this.comentarioServicio = comentarioServicio;
    }


    @PostConstruct
    public void inicializar() {

        nuevoComentario=new Comentario();

        if (codProducto != null && !codProducto.isEmpty()) {




            try {
                producto = productoServicio.buscarProducto(Integer.parseInt(codProducto));
                this.calificacionPromedio= 0;
                this.listaComentarios=producto.getListaComentariosProductos();
                Float calificacion=productoServicio.obtenerPromedioProducto(Integer.parseInt(codProducto));
                if(calificacion!=null){

                        this.calificacionPromedio=calificacion.intValue();

                }


            } catch (Exception e) {
                e.printStackTrace();
            }


        }


    }


    public void crearComentario(){


        try {
            nuevoComentario.setComentarioProducto(producto);
            nuevoComentario.setUsuarioComentario(usuarioServicio.obtenerUsuario("1"));
            productoServicio.comentarProducto(nuevoComentario);
            this.listaComentarios.add(nuevoComentario);
            nuevoComentario=new Comentario();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
