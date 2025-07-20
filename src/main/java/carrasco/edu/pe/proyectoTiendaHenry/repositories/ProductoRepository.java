package carrasco.edu.pe.proyectoTiendaHenry.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import carrasco.edu.pe.proyectoTiendaHenry.models.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    
    // Ordenar el nombre en orden alfabetico ascendente y descendente
    List<Producto> findAllByOrderByNombreAsc();
    List<Producto> findAllByOrderByNombreDesc();

    List<Producto> findByNombreContainingIgnoreCase(String nombre);

    List<Producto> findByCategoriaIdCategoria(Integer idCategoria);
    // Ordenar el nombre ascendente y descendente del producto por Categoria
    List<Producto> findByCategoriaIdCategoriaOrderByNombreAsc(Integer idCategoria);
    List<Producto> findByCategoriaIdCategoriaOrderByNombreDesc(Integer idCategoria);

    // Ordenar el precio ascendente y descendente
    List<Producto> findAllByOrderByPrecioUnitarioAsc();
    List<Producto> findAllByOrderByPrecioUnitarioDesc();

    // Ordenar el precio ascendente y descendente del producto por Categoria
    List<Producto> findByCategoriaIdCategoriaOrderByPrecioUnitarioAsc(Integer idCategoria);
    List<Producto> findByCategoriaIdCategoriaOrderByPrecioUnitarioDesc(Integer idCategoria);

    // Ordenar el stock ascendente y descendente
    List<Producto> findAllByOrderByStockAsc();
    List<Producto> findAllByOrderByStockDesc();

    // Ordenar el stock ascendente y descendente del producto por Categoria
    List<Producto> findByCategoriaIdCategoriaOrderByStockAsc(Integer idCategoria);
    List<Producto> findByCategoriaIdCategoriaOrderByStockDesc(Integer idCategoria);


}
