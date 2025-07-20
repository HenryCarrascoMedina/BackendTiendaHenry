package carrasco.edu.pe.proyectoTiendaHenry.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carrasco.edu.pe.proyectoTiendaHenry.models.Producto;
import carrasco.edu.pe.proyectoTiendaHenry.repositories.ProductoRepository;

@Service
public class ProductoService {
    
    @Autowired
    private ProductoRepository repository;

    // Listar todos los productos ordenados por nombre ascendente
    public List<Producto> listarProductosOrdenadosPorNombreAscendente() {
        return repository.findAllByOrderByNombreAsc();
    }

    // Listar todos los productos ordenados por nombre descendente
    public List<Producto> listarProductosOrdenadosPorNombreDescendente() {
        return repository.findAllByOrderByNombreDesc();
    }

    // Listar todos los productos o por categoría
    public List<Producto> listarProductosPorCategoria(Integer categoria) {
        if (categoria == null) {
            return repository.findAll();           
        }
        return repository.findByCategoriaIdCategoria(categoria);
    }

    // Buscar producto por ID
    public Producto buscarProductoPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    // Listar productos por categoria de forma ascendente
    public List<Producto> listarProductosPorCategoriaAscendente(Integer categoria) {
        return repository.findByCategoriaIdCategoriaOrderByNombreAsc(categoria);
    }

    // Listar productos por categoria de forma descendente
    public List<Producto> listarProductosPorCategoriaDescendente(Integer categoria) {
        return repository.findByCategoriaIdCategoriaOrderByNombreDesc(categoria);
    }

    // Buscar productos por nombre
    public List<Producto> buscarProductosPorNombre(String nombre) {
        return repository.findByNombreContainingIgnoreCase(nombre);
    }

    // Listar productos por categoría ordenados por precio unitario ascendente
    public List<Producto> listarProductosPorCategoriaPrecioAsc(Integer idCategoria) {
        return repository.findByCategoriaIdCategoriaOrderByPrecioUnitarioAsc(idCategoria);
    }

    // Listar productos por categoría ordenados por precio unitario descendente
    public List<Producto> listarProductosPorCategoriaPrecioDesc(Integer idCategoria) {
        return repository.findByCategoriaIdCategoriaOrderByPrecioUnitarioDesc(idCategoria);
    }

    // Listar productos por categoría ordenados por stock ascendente
    public List<Producto> listarProductosPorCategoriaStockAsc(Integer idCategoria) {
        return repository.findByCategoriaIdCategoriaOrderByStockAsc(idCategoria);
    }

    // Listar productos por categoría ordenados por stock descendente
    public List<Producto> listarProductosPorCategoriaStockDesc(Integer idCategoria) {
        return repository.findByCategoriaIdCategoriaOrderByStockDesc(idCategoria);
    }

    // Crear un producto
    public Producto crearProducto(Producto producto) {
        return repository.save(producto);
    }

    // Actualizar un producto por ID
    public Producto actualizarProducto(Integer id, Producto producto) {
        Producto existente = repository.findById(id).orElse(null);
        if (existente != null) {
            existente.setNombre(producto.getNombre());
            existente.setDescripcion(producto.getDescripcion());
            existente.setPrecioUnitario(producto.getPrecioUnitario());
            existente.setStock(producto.getStock());
            existente.setUnidadMedida(producto.getUnidadMedida());
            existente.setImagenURL(producto.getImagenURL());
            existente.setEstado(producto.isEstado());
            existente.setFechaRegistro(producto.getFechaRegistro());
            existente.setCategoria(producto.getCategoria());
            existente.setProveedor(producto.getProveedor());
            return repository.save(existente);
        }
        return null;
    }

    // "Eliminar" un producto por ID (borrado lógico: estado = false)
    public void eliminarProducto(Integer id) {
        Producto existente = repository.findById(id).orElse(null);
        if (existente != null) {
            existente.setEstado(false);
            repository.save(existente);
        }
    }

}
