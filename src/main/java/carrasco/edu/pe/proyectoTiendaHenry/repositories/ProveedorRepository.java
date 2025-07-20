package carrasco.edu.pe.proyectoTiendaHenry.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import carrasco.edu.pe.proyectoTiendaHenry.models.Proveedor;
import carrasco.edu.pe.proyectoTiendaHenry.models.Enums.TipoDocumento;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
    
    Proveedor findByTipoDocumentoAndDocumento(TipoDocumento TipoDocumento, String documento);
}
