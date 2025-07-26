package carrasco.edu.pe.proyectoTiendaHenry.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carrasco.edu.pe.proyectoTiendaHenry.models.DetalleVenta;
import carrasco.edu.pe.proyectoTiendaHenry.repositories.DetalleVentaRepository;

@Service
public class DetalleVentaService {
    
    @Autowired
    private DetalleVentaRepository repository;

    // Listar detalles de venta
    public List<DetalleVenta> listarDetallesVenta() {
        return repository.findAll();
    }

    // Buscar detalle de venta por ID
    public DetalleVenta buscarDetalleVentaPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    // Guardar un nuevo detalle de venta
    public DetalleVenta guardarDetalleVenta(DetalleVenta detalleVenta) {
        return repository.save(detalleVenta);
    }

    // Actualizar un detalle de venta existente
    public DetalleVenta actualizarDetalleVenta(Integer id, DetalleVenta detalleVenta) {
        DetalleVenta existente = repository.findById(id).orElse(null);
        if (existente != null) {
            existente.setIdDetalleVenta(detalleVenta.getIdDetalleVenta());
            existente.setCantidad(detalleVenta.getCantidad());
            existente.setPrecioUnitario(detalleVenta.getPrecioUnitario());
            existente.setSubtotal(detalleVenta.getSubtotal());
            existente.setProducto(detalleVenta.getProducto());
            existente.setVenta(detalleVenta.getVenta());
            return repository.save(existente);
        }
        return null;
    }

}
