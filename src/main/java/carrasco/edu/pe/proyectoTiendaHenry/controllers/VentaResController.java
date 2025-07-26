package carrasco.edu.pe.proyectoTiendaHenry.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import carrasco.edu.pe.proyectoTiendaHenry.models.Venta;
import carrasco.edu.pe.proyectoTiendaHenry.services.VentaService;

@RestController
@RequestMapping("/api/ventas")
public class VentaResController {
    
    @Autowired
    private VentaService service;

    // Listar ventas
    @GetMapping
    public ResponseEntity<List<Venta>> listarVentas() {
        return ResponseEntity.ok(service.listarVentas());
    }

    // Obtener venta por ID
    @GetMapping("/{id}")
    public ResponseEntity<Venta> obtenerVentaPorId(@PathVariable Integer id) {
        Venta venta = service.obtenerVentaPorId(id);
        return (venta != null) ? ResponseEntity.ok(venta) : ResponseEntity.notFound().build();
    }

    // Guardar venta
    @PostMapping
    public ResponseEntity<Venta> guardarVenta(@RequestBody Venta venta) {
        Venta nuevaVenta = service.guardarVenta(venta);
        return ResponseEntity.ok(nuevaVenta);
    }

    // Actualizar venta
    @PutMapping("/{id}")
    public ResponseEntity<Venta> actualizarVenta(@PathVariable Integer id, @RequestBody Venta venta) {
        Venta actualizada = service.actualizarVenta(id, venta);
        return (actualizada != null) ? ResponseEntity.ok(actualizada) : ResponseEntity.notFound().build();
    }

    // Eliminar venta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVenta(@PathVariable Integer id) {
        service.eliminarVenta(id);
        return ResponseEntity.noContent().build();
    }

}
