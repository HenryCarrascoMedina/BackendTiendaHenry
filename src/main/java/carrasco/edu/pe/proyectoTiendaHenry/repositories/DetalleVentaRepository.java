package carrasco.edu.pe.proyectoTiendaHenry.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import carrasco.edu.pe.proyectoTiendaHenry.models.DetalleVenta;

@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Integer> {
    // Aquí puedes definir métodos personalizados si es necesario
    
}
