package carrasco.edu.pe.proyectoTiendaHenry.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import carrasco.edu.pe.proyectoTiendaHenry.models.Producto;
import carrasco.edu.pe.proyectoTiendaHenry.services.ProductoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/productos")
public class ProductoRestController {

    @Autowired
    private ProductoService service;

    @GetMapping
    public List<Producto> listarProductosPorCategoria(@RequestParam(required = false) Integer idCategoria) {
        return service.listarProductosPorCategoria(idCategoria);
    }

    @GetMapping("/listar/{idCategoria}")
    public List<Producto> listarProductosPorCategoriaPath(@PathVariable Integer idCategoria) {
        return service.listarProductosPorCategoria(idCategoria);
    }

    @GetMapping("id/{id}")
    public Producto obtenerProductoPorId(@PathVariable Integer id) {
        return service.buscarProductoPorId(id);
    }

    @GetMapping("/ordenCategoriaAsc/{idCategoria}")
    public List<Producto> listarProductosPorCategoriaOrdenadosAsc(@PathVariable Integer idCategoria) {
        return service.listarProductosPorCategoriaAscendente(idCategoria);
    }

    @GetMapping("/ordenCategoriaDesc/{idCategoria}")
    public List<Producto> listarProductosPorCategoriaOrdenadosDesc(@PathVariable Integer idCategoria) {
        return service.listarProductosPorCategoriaDescendente(idCategoria);
    }
    
    @GetMapping("/buscar/{nombre}")
    public List<Producto> buscarProductosPorNombre(@PathVariable String nombre) {
        return service.buscarProductosPorNombre(nombre);
    }

    @GetMapping("/ordenPorNombreAsc")
    public List<Producto> listarProductosOrdenadosPorNombreAsc() {
        return service.listarProductosOrdenadosPorNombreAscendente();
    }

    @GetMapping("/ordenPorNombreDesc")
    public List<Producto> listarProductosOrdenadosPorNombreDesc() {
        return service.listarProductosOrdenadosPorNombreDescendente();
    }

    @GetMapping("/categoriaPrecio-asc/{idCategoria}")
    public List<Producto> listarProductosPorCategoriaPrecioAsc(@PathVariable Integer idCategoria) {
        return service.listarProductosPorCategoriaPrecioAsc(idCategoria);
    }

    @GetMapping("/categoriaPrecio-desc/{idCategoria}")
    public List<Producto> listarProductosPorCategoriaPrecioDesc(@PathVariable Integer idCategoria) {
        return service.listarProductosPorCategoriaPrecioDesc(idCategoria);
    }

    @GetMapping("/categoriaStock-asc/{idCategoria}")
    public List<Producto> listarProductosPorCategoriaStockAsc(@PathVariable Integer idCategoria) {
        return service.listarProductosPorCategoriaStockAsc(idCategoria);
    }

    @GetMapping("/categoriaStock-desc/{idCategoria}")
    public List<Producto> listarProductosPorCategoriaStockDesc(@PathVariable Integer idCategoria) {
        return service.listarProductosPorCategoriaStockDesc(idCategoria);
    }

    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return service.crearProducto(producto);
    }

    // Actualizar un producto por ID
    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Integer id, @RequestBody Producto producto) {
        return service.actualizarProducto(id, producto);
    }

    // "Eliminar" un producto por ID (borrado lógico: estado = false)
    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Integer id) {
        service.eliminarProducto(id);
    }

}
