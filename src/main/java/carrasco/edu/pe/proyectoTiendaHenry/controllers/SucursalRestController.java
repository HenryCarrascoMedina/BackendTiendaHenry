package carrasco.edu.pe.proyectoTiendaHenry.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import carrasco.edu.pe.proyectoTiendaHenry.models.Sucursal;
import carrasco.edu.pe.proyectoTiendaHenry.services.SucursalService;

@RestController
@RequestMapping("/api/sucursales")
public class SucursalRestController {

    @Autowired
    private SucursalService service;

    @GetMapping
    public ResponseEntity<List<Sucursal>> listarSucursales() {
        return ResponseEntity.ok(service.listarSucursales());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sucursal> buscarSucursalPorId(@PathVariable Integer id) {
        Sucursal sucursal = service.buscarSucursalPorId(id);
        return sucursal != null ? ResponseEntity.ok(sucursal) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Sucursal> guardarSucursal(@RequestBody Sucursal sucursal) {
        Sucursal nuevaSucursal = service.guardarSucursal(sucursal);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaSucursal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sucursal> actualizarSucursal(@PathVariable Integer id, @RequestBody Sucursal sucursal) {
        Sucursal actualizada = service.actualizarSucursal(id, sucursal);
        return actualizada != null ? ResponseEntity.ok(actualizada) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public void eliminarSucursal(@PathVariable Integer id) {
        service.eliminarSucursal(id);
    }
    
}
