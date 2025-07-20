package carrasco.edu.pe.proyectoTiendaHenry.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import carrasco.edu.pe.proyectoTiendaHenry.models.Proveedor;
import carrasco.edu.pe.proyectoTiendaHenry.models.Enums.TipoDocumento;
import carrasco.edu.pe.proyectoTiendaHenry.services.ProveedorService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/api/proveedores")
public class ProveedorRestController {

    @Autowired
    private ProveedorService service;

    @GetMapping
    public List<Proveedor> listarProveedores() {
        return service.listarProveedores();
    }

    @GetMapping("/id/{id}")
    public Proveedor buscarProveedorPorId(@PathVariable Integer id) {
        return service.buscarProveedorPorId(id);
    }

    @GetMapping("/documento/{tipoDocumento}/{documento}")
    public Proveedor buscarProveedorPorDocumento(@PathVariable TipoDocumento tipoDocumento, @PathVariable String documento) {
        return service.buscarProveedorPorDocumento(tipoDocumento, documento);
    }

    @PostMapping
    public Proveedor crearProveedor(@RequestBody Proveedor proveedor) {       
        return service.crearProveedor(proveedor);
    }

    @PutMapping("/{id}")
    public Proveedor actualizarProveedor(@PathVariable Integer id, @RequestBody Proveedor proveedor) {
        return service.actualizarProveedor(id, proveedor);
    }
    
    @DeleteMapping("/{id}")
    public void eliminarProveedor(@PathVariable Integer id) {
        service.eliminarProveedor(id);
    }
    
}
