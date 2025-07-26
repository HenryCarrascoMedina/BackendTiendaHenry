package carrasco.edu.pe.proyectoTiendaHenry.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import carrasco.edu.pe.proyectoTiendaHenry.models.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
    // Aquí puedes definir métodos personalizados si es necesario
    
}
