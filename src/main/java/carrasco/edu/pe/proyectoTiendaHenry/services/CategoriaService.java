package carrasco.edu.pe.proyectoTiendaHenry.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import carrasco.edu.pe.proyectoTiendaHenry.models.Categoria;
import carrasco.edu.pe.proyectoTiendaHenry.repositories.CategoriaRepository;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository repository;

    public CategoriaService(){}

    //Listar las Categorias
    public List<Categoria> listarCategorias(){
        return repository.findAll();
    }

    //Listar Categorias por estado
    public List<Categoria> listarCategoriasPorEstado(boolean estado) {
        return repository.findByEstado(estado);
    }

    //Buscar una Categoria por ID
    public Categoria buscarCategoriaPorId(Integer id){
        return repository.findById(id).orElse(null);
    }

    //Crear una Categoria
    public Categoria crearCategoria(Categoria categoria){
        return repository.save(categoria);
    }

    //Actualizar una Categoria por ID
    public Categoria actualizarCategoria(Integer id, Categoria categoria) {
        Categoria existente = repository.findById(id).orElse(null);
        if (existente != null) {
            existente.setNombre(categoria.getNombre());
            existente.setDescripcion(categoria.getDescripcion());
            existente.setEstado(categoria.isEstado());
            existente.setFechaCreacion(categoria.getFechaCreacion());
            return repository.save(existente);
        }
        return null;
    }

    //Eliminar una Categoria por ID
    public void eliminarCategoria(Integer id) {
        Categoria existente = repository.findById(id).orElse(null);
        if (existente != null) {
            existente.setEstado(false);
            repository.save(existente);
        }
    }

}
