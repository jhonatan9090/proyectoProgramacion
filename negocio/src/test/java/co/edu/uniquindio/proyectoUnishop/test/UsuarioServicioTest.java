package co.edu.uniquindio.proyectoUnishop.test;

import co.edu.uniquindio.proyectoUnishop.NegocioApplication;
import co.edu.uniquindio.proyectoUnishop.servicios.UsuarioServicio;
import co.edu.uniquindio.proyectoUnishop.entidades.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class UsuarioServicioTest {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Test
    public void RegistrarTest(){


        Map<String,String> telefonos=new HashMap<>();
        telefonos.put("casa","321414");
        telefonos.put("celular","321452514");
        Usuario u= new Usuario("200", "Oscar", "oscar@gmail.com", "oscar1",telefonos,null);
        u.setTelefono(telefonos);

        try {

            Usuario respuesta = usuarioServicio.registrarUsuario(u);

            Assertions.assertNotNull(respuesta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

