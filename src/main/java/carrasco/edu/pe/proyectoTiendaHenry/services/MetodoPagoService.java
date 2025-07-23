package carrasco.edu.pe.proyectoTiendaHenry.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carrasco.edu.pe.proyectoTiendaHenry.models.MetodoPago;
import carrasco.edu.pe.proyectoTiendaHenry.repositories.MetodoPagoRepository;

@Service
public class MetodoPagoService {
    
    @Autowired
    private MetodoPagoRepository repository;

    //Listar todos los métodos de pago
    public List<MetodoPago> listarMetodosPago() {
        return repository.findAll();
    }

    //Buscar método de pago por ID
    public MetodoPago buscarMetodoPagoPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    // Actualizar método de pago
    public MetodoPago actualizarMetodoPago(Integer id, MetodoPago metodoPago) {
        MetodoPago existe = repository.findById(id).orElse(null);
        if (existe != null) {
            existe.setIdMetodoPago(metodoPago.getIdMetodoPago());
            existe.setNombre(metodoPago.getNombre());
            existe.setDescripcion(metodoPago.getDescripcion());
            existe.setEstado(metodoPago.getEstado());
            existe.setFechaRegistro(metodoPago.getFechaRegistro());
            return repository.save(existe);
        }
        return null;
    }

    // Crear nuevo método de pago
    public MetodoPago crearMetodoPago(MetodoPago metodoPago) {
        return repository.save(metodoPago);
    }

    // Eliminar metodo de pago por logica
    public MetodoPago eliminarMetodoPaago(Integer id){
        MetodoPago metodoPago = repository.findById(id).orElse(null);
        if (metodoPago != null) {
            metodoPago.setEstado(false);
            return repository.save(metodoPago);
        }
        return null;
    }
}
