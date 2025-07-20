package carrasco.edu.pe.proyectoTiendaHenry.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carrasco.edu.pe.proyectoTiendaHenry.models.Proveedor;
import carrasco.edu.pe.proyectoTiendaHenry.models.Enums.TipoDocumento;
import carrasco.edu.pe.proyectoTiendaHenry.repositories.ProveedorRepository;

@Service
public class ProveedorService {
    
    @Autowired
    private ProveedorRepository repository;

    public ProveedorService() {}

    // Listar los Proveedores
    public List<Proveedor> listarProveedores() {
        return repository.findAll();
    }
    // Buscar un Proveedor por ID
    public Proveedor buscarProveedorPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }
    // Buscar Proveedor por tipoDocumento y Documento
    public Proveedor buscarProveedorPorDocumento(TipoDocumento tipoDocumento,String documento) {
        return repository.findByTipoDocumentoAndDocumento(tipoDocumento, documento);
    }

    // Crear un Proveedor
    public Proveedor crearProveedor(Proveedor proveedor) {
        // Validar tipo de documento
        if (proveedor.getTipoDocumento() == null) {
            throw new IllegalArgumentException("El tipo de documento es obligatorio.");
        }

        String documento = proveedor.getDocumento();
        switch (proveedor.getTipoDocumento().name()) {
            case "DNI":
                if (documento == null || !documento.matches("\\d{8}")) {
                    throw new IllegalArgumentException("El DNI debe tener exactamente 8 dígitos numéricos.");
                }
                break;
            case "RUC":
                if (documento == null || !documento.matches("(10|20)\\d{9}")) {
                    throw new IllegalArgumentException("El RUC debe tener 11 dígitos y empezar con 10 o 20.");
                }
                break;
            default:
                throw new IllegalArgumentException("El tipo de documento debe ser DNI o RUC.");
        }

        return repository.save(proveedor);
    }

    // Actualizar un Proveedor por ID
    public Proveedor actualizarProveedor(Integer id, Proveedor proveedor) {
        Proveedor existente = repository.findById(id).orElse(null);
        if (existente != null) {
            existente.setNombre(proveedor.getNombre());
            existente.setTipoDocumento(proveedor.getTipoDocumento());
            existente.setDocumento(proveedor.getDocumento());
            existente.setTelefono(proveedor.getTelefono());
            existente.setCorreo(proveedor.getCorreo());
            existente.setDireccion(proveedor.getDireccion());
            existente.setContacto(proveedor.getContacto());
            existente.setEstado(proveedor.isEstado());
            existente.setFechaRegistro(proveedor.getFechaRegistro());
            return repository.save(existente);
        }
        return null;
    }

    // Eliminar un Proveedor por ID
    public void eliminarProveedor(Integer id) {
        Proveedor proveedor = repository.findById(id).orElse(null);
        if (proveedor != null) {
            proveedor.setEstado(false);
            repository.save(proveedor);
        }
    }

}
