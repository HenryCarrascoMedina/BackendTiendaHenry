package carrasco.edu.pe.proyectoTiendaHenry.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import carrasco.edu.pe.proyectoTiendaHenry.models.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Integer>{
    
    List<Categoria> findByEstado(boolean estado);
}
