package co.edu.uniquindio.proyectoUnishop.bean;

import co.edu.uniquindio.proyectoUnishop.entidades.*;
import co.edu.uniquindio.proyectoUnishop.servicios.CategoriaServicio;
import co.edu.uniquindio.proyectoUnishop.servicios.CiudadServicio;
import co.edu.uniquindio.proyectoUnishop.servicios.ProductoServicio;
import co.edu.uniquindio.proyectoUnishop.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class ProductoBean implements Serializable {

    @Getter
    @Setter
    private Producto producto;



    private final CategoriaServicio categoriaServicio;

    private final ProductoServicio productoServicio;

    private final UsuarioServicio usuarioServicio;

    private  final CiudadServicio ciudadServicio;


    @Getter
    @Setter
    private List<Categoria> listaCategorias;

    //trae la lista de las ciudades
    @Getter
    @Setter
    private List<Ciudad>listaCiudad;


    private ArrayList<String> imagenes;

    @Value("${upload.url}")
    private String urlUploads;

    @Value("#{seguridadBean.persona}")
    private Persona personaSesion;

    /**
     *
     * @param productoServicio recibe por parametro el producto
     * @param usuarioServicio recibe por parametro usuario
     * @param categoriaServicio recibe por parametros las categorias de los productos
     * @param ciudadServicio recibe por parametros las ciudades
     */
    public ProductoBean(ProductoServicio productoServicio, UsuarioServicio usuarioServicio, CategoriaServicio categoriaServicio, CiudadServicio ciudadServicio) {
        this.productoServicio = productoServicio;
        this.usuarioServicio = usuarioServicio;
        this.categoriaServicio = categoriaServicio;
        this.ciudadServicio = ciudadServicio;
    }

    /**
     * est4e metodo sirve para inicializar
     */
    @PostConstruct
    public void inicializar(){

        this.producto = new Producto();
        listaCategorias= categoriaServicio.listarCategorias();
        listaCiudad=ciudadServicio.listaCiudad();
        this.imagenes = new ArrayList<>();
    }

    /**
     * este metodo sirve para crear los produtos y guardarlos
     * @return
     */
    public String crearProducto(){
        try {
            if(personaSesion!=null) {
                if (!imagenes.isEmpty()) {
                    producto.setUsuarioVendedor((Usuario) personaSesion);
                    producto.setImagenes(imagenes);
                    producto.setFechaLimite(LocalDate.now().plusMonths(1));
                    productoServicio.publicarProducto(producto);
                    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Producto Publicado con exito");
                    FacesContext.getCurrentInstance().addMessage("mensajeCP", msg);
                } else {
                    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", "Es necesario subir al menos una imagen");
                    FacesContext.getCurrentInstance().addMessage("mensajeCP", msg);
                }
            }
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensajeCP", msg);
        }
        return  null;
    }

    /**
     * este metodo sirve para subir y guardar la imagen del producto registrado
     * @param event
     */
    public void  subirImagenes(FileUploadEvent event){
        UploadedFile imagen = event.getFile();
        System.out.println(imagen.getFileName());
        System.out.println(imagen.getContentType());
        String nombreImagen = subirImagen(imagen);
        if (nombreImagen != null){
            imagenes.add(nombreImagen);
        }
    }

    /**
     * este metodo sirve para subir la imgen y guardarla
     * @param imagen aqui se recie la imagen que se desea cargar
     * @return
     */
    public String subirImagen(UploadedFile imagen){
        try{
            File archivo = new File(urlUploads+"/"+imagen.getFileName());
            OutputStream outputStream = new FileOutputStream(archivo);
            IOUtils.copy(imagen.getInputStream(), outputStream);
            return imagen.getFileName();
        }catch (Exception e){
            e.printStackTrace();
            }
        return null;
    }
}
