package carrasco.edu.pe.proyectoTiendaHenry.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import carrasco.edu.pe.proyectoTiendaHenry.models.Sucursal;
import carrasco.edu.pe.proyectoTiendaHenry.repositories.SucursalRepository;

public class SucursalService {
    
    @Autowired
    private SucursalRepository repository;

    // Listar todas las sucursales
    public List<Sucursal> listarSucursales() {
        return repository.findAll();
    }

    // Buscar una sucursal por ID
    public Sucursal buscarSucursalPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    // Guardar una nueva sucursal
    public Sucursal guardarSucursal(Sucursal sucursal) {
        return repository.save(sucursal);
    }

    // Actualizar una sucursal existente
    public Sucursal actualizarSucursal(Integer id, Sucursal sucursal) {
        Sucursal existente = repository.findById(id).orElse(null);
        if (existente != null) {
            existente.setNombre(sucursal.getNombre());
            existente.setDireccion(sucursal.getDireccion());
            existente.setTelefono(sucursal.getTelefono());
            existente.setEstado(sucursal.getEstado());
            existente.setFechaRegistro(sucursal.getFechaRegistro());
            return repository.save(existente);
        }
        return null;
    }
}
