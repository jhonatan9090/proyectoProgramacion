package co.edu.uniquindio.proyectoUnishop.servicios;

import co.edu.uniquindio.proyectoUnishop.entidades.DetalleCompra;
import co.edu.uniquindio.proyectoUnishop.repositorios.DetalleCompraRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class DetalleCompraServicioImpl implements  DetalleCompraServicio{

    @Autowired
    private DetalleCompraRepo detalleCompraRepo;

    /**
     *
     * @param idDetalle este parametro es el identificador por el cual se va a buscar el detalle de la compra
     * @return este retorna el detalle de la compra buscado
     * @throws Exception
     */
    @Override
    public DetalleCompra buscarDetalleId(Integer idDetalle) throws Exception {

        return detalleCompraRepo.findById(idDetalle).get();
    }

    @Override
    public List<DetalleCompra> listarcompras() {
        return detalleCompraRepo.findAll();
    }
}
