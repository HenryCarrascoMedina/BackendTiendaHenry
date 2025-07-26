package carrasco.edu.pe.proyectoTiendaHenry.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carrasco.edu.pe.proyectoTiendaHenry.models.Venta;
import carrasco.edu.pe.proyectoTiendaHenry.repositories.VentaRepository;

@Service
public class VentaService {
    
    @Autowired
    private VentaRepository repository;

    // Listar ventas
    public List<Venta> listarVentas() {
        return repository.findAll();
    }

    // Obtener venta por ID
    public Venta obtenerVentaPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    // Guardar venta
    public Venta guardarVenta(Venta venta) {
        return repository.save(venta);
    }

    // Actualizar venta
    public Venta actualizarVenta(Integer id, Venta venta) {
        Venta existente = repository.findById(id).orElse(null);
        if (existente != null) {
            existente.setIdVenta(venta.getIdVenta());
            existente.setFechaVenta(venta.getFechaVenta());
            existente.setSubtotal(venta.getSubtotal());
            existente.setIgv(venta.getIgv());
            existente.setTotal(venta.getTotal());
            existente.setEstado(venta.getEstado());
            existente.setCliente(venta.getCliente());
            existente.setEmpleado(venta.getEmpleado());
            existente.setSucursal(venta.getSucursal());
            existente.setMetodoPago(venta.getMetodoPago());
            return repository.save(existente);
        }
        return null;
    }

    // Eliminar venta
    public void eliminarVenta(Integer id) {
        Venta existente = repository.findById(id).orElse(null);
        if (existente != null) {
            existente.setEstado(false);
            repository.save(existente);
        }
    }
}
