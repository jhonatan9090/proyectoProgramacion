package co.edu.uniquindio.proyectoUnishop.test;


import co.edu.uniquindio.proyectoUnishop.NegocioApplication;
import co.edu.uniquindio.proyectoUnishop.entidades.Producto;
import co.edu.uniquindio.proyectoUnishop.entidades.Usuario;
import co.edu.uniquindio.proyectoUnishop.servicios.ProductoServicio;
import co.edu.uniquindio.proyectoUnishop.servicios.UsuarioServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class ProductoServicioTest {

    @Autowired
    private ProductoServicio productoServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    /**
     * este metodo lista los productos por categoria
     * y se lista los datos de un usuario
     */
    @Test
    public void listarPorCategoria(){

        try {

            LocalDate fecha =  LocalDate.of(2029,10,12);
            Map<String,String> telefonos=new HashMap<>();
            telefonos.put("casa","321414");
            telefonos.put("celular","321452514");
            Usuario u= new Usuario("200", "Oscar", "oscar@gmail.com", "oscar1",telefonos,null);
            u.setTelefono(telefonos);
            usuarioServicio.registrarUsuario(u);
            List<String> imagenes = new ArrayList<>();
            imagenes.add("1");
            imagenes.add("2");
            Producto p=new Producto("computador",10,"bonito",1555555.0,fecha,0.0,imagenes,u,null);

        }catch (Exception e){

        }

    }

}
