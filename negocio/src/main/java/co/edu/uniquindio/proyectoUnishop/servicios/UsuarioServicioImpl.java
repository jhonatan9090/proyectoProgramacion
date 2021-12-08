package co.edu.uniquindio.proyectoUnishop.servicios;

import co.edu.uniquindio.proyectoUnishop.entidades.DetalleCompra;
import co.edu.uniquindio.proyectoUnishop.entidades.Producto;
import co.edu.uniquindio.proyectoUnishop.entidades.Usuario;
import co.edu.uniquindio.proyectoUnishop.repositorios.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 */
@Service
public class UsuarioServicioImpl implements UsuarioServicio {


    private final UsuarioRepo usuarioRepo;


    public UsuarioServicioImpl(UsuarioRepo usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    /**
     *
     * @param u este paramaetro es para guardar el usuario registrado y compararlo con el codigo de los demas usuarios
     * @return
     * @throws Exception
     */
    @Override
    public Usuario registrarUsuario(Usuario u) throws Exception {
        Optional<Usuario> buscado = usuarioRepo.findById(u.getCodPersona());

        if (buscado.isPresent()) throw new Exception("El codigo " + u.getCodPersona() + " ya está registrado.");

        buscado = usuarioRepo.findByEmail(u.getEmail());

        if (buscado.isPresent()) throw new Exception("El correo " + u.getEmail() + " ya está registrado.");

        return usuarioRepo.save(u);
    }

    /**
     *
     * @param u este paramaetro es para guardar el usuario registrado y compararlo con el codigo de los demas usuarios
     * @return
     * @throws Exception
     */
    @Override
    public Usuario actualizarUsuario(Usuario u) throws Exception {
        Optional<Usuario> buscado = usuarioRepo.findById(u.getCodPersona());

        if (buscado.isEmpty())
            throw new Exception("El usuario con codigo " + u.getCodPersona() + " no está registrado.");

        return usuarioRepo.save(u);
    }

    /**
     *
     * @param codigo se utiliza para buscar el codigo del usuario registrado y poder eliminarlo
     * @throws Exception
     */
    @Override
    public void eliminarUsuario(String codigo) throws Exception {
        Optional<Usuario> buscado = usuarioRepo.findById(codigo);
        if (buscado.isEmpty()) {
            throw new Exception("El codigo del usuario no existe");
        }
        usuarioRepo.deleteById(codigo);
    }

    /**
     * Este metodo sirve para listar los usuarios
     * @return
     */
    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepo.findAll();
    }

    /**
     *
     * @param codigo sirve para buscar al usuario buscado por su codigo
     * @return
     * @throws Exception
     */
    @Override
    public Usuario obtenerUsuario(String codigo) throws Exception {
        Optional<Usuario> usuario = usuarioRepo.findById(codigo);
        if (usuario.isEmpty()) {
            throw new Exception("No existe un usuario con el id dado");
        }
        return usuario.get();
    }

    /**
     *
     * @param email se utuliza para buscar los productos favoritos  del usuario
     * @return
     * @throws Exception
     */
    @Override
    public List<Producto> listarProductosFavoritos(String email) throws Exception {
          Optional<Usuario> buscado = usuarioRepo.findByEmail(email);

       // List<Producto> productoListFav = usuarioRepo.obtenerProductosFavoritos(email);

        //if (productoListFav.isEmpty()) {
           // throw new Exception("El usuario no tiene productos favoritos");
        //}

        if (buscado.isEmpty()) {
            throw new Exception("El correo no existe");
        }

        return usuarioRepo.obtenerProductosFavoritos(email);
    }

    /**
     *
     * @param email sirve para listar los productos escogidos por el usuario
     * @return
     */
    @Override
    public List<Producto> listarProductoUsuario(String email) {


       return usuarioRepo.listarProductosUsuario(email);
    }

    @Override
    public List<DetalleCompra> listarComprasUsuario(String email) {
        return usuarioRepo.listarComprasUsuario(email);
    }


}
