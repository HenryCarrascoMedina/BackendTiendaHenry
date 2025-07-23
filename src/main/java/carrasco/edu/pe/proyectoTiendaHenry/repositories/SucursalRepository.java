package carrasco.edu.pe.proyectoTiendaHenry.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import carrasco.edu.pe.proyectoTiendaHenry.models.Sucursal;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {
    // Additional query methods can be defined here if needed
    
}
