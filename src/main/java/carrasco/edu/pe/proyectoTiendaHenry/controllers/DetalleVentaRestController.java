package carrasco.edu.pe.proyectoTiendaHenry.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import carrasco.edu.pe.proyectoTiendaHenry.models.DetalleVenta;
import carrasco.edu.pe.proyectoTiendaHenry.services.DetalleVentaService;

@RestController
@RequestMapping("/api/detalles-venta")
public class DetalleVentaRestController {

    @Autowired
    private DetalleVentaService service;

    // Listar detalles de venta
    @GetMapping
    public ResponseEntity<List<DetalleVenta>> listarDetallesVenta() {
        return ResponseEntity.ok(service.listarDetallesVenta());
    }

    // Obtener detalle de venta por ID
    @GetMapping("/{id}")
    public ResponseEntity<DetalleVenta> obtenerDetalleVentaPorId(@PathVariable Integer id) {
        DetalleVenta detalleVenta = service.buscarDetalleVentaPorId(id);
        return (detalleVenta != null) ? ResponseEntity.ok(detalleVenta) : ResponseEntity.notFound().build();
    }

    // Guardar detalle de venta
    @PostMapping
    public ResponseEntity<DetalleVenta> guardarDetalleVenta(@RequestBody DetalleVenta detalleVenta) {
        DetalleVenta nuevoDetalle = service.guardarDetalleVenta(detalleVenta);
        return ResponseEntity.ok(nuevoDetalle);
    }

    // Actualizar detalle de venta
    @PutMapping("/{id}")
    public ResponseEntity<DetalleVenta> actualizarDetalleVenta(@PathVariable Integer id, @RequestBody DetalleVenta detalleVenta) {
        DetalleVenta actualizado = service.actualizarDetalleVenta(id, detalleVenta);
        return (actualizado != null) ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }
    
}
