package carrasco.edu.pe.proyectoTiendaHenry.controllers;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import carrasco.edu.pe.proyectoTiendaHenry.models.Categoria;
import carrasco.edu.pe.proyectoTiendaHenry.services.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
@RequestMapping("/api/categorias")
public class CategoriaRestController {
    
    @Autowired
    private CategoriaService service;

    @GetMapping  
    public List<Categoria> listarCategorias() {
        return service.listarCategorias();
    }

    @GetMapping("/id/{id}")
    public Categoria buscarCategoriaPorId(@PathVariable Integer id) {
        return service.buscarCategoriaPorId(id);
    }

    @GetMapping("/estado/{estado}")
    public List<Categoria> listarCategoriasPorEstado(@PathVariable boolean estado) {
        return service.listarCategoriasPorEstado(estado);
    }

    @PostMapping
    public Categoria crearCategoria(@RequestBody Categoria categoria) {  
        return service.crearCategoria(categoria);
    }

    @PutMapping("/{id}")
    public Categoria actualizarCategoria(@PathVariable Integer id, @RequestBody Categoria categoria) {
        return service.actualizarCategoria(id, categoria);
    }

    @DeleteMapping("/{id}")
    public void eliminarCategoria(@PathVariable Integer id) {
        service.eliminarCategoria(id);
    }    

}
