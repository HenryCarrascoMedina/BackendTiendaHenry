package carrasco.edu.pe.proyectoTiendaHenry.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import carrasco.edu.pe.proyectoTiendaHenry.models.Cliente;
import java.util.List;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario
    public Cliente findByCorreo(String correo);
    public List<Cliente> findByEstado(Boolean estado);
}
