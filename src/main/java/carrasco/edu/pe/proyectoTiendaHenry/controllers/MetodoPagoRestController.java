package carrasco.edu.pe.proyectoTiendaHenry.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import carrasco.edu.pe.proyectoTiendaHenry.models.MetodoPago;
import carrasco.edu.pe.proyectoTiendaHenry.services.MetodoPagoService;

@RestController
@RequestMapping("/api/metodosPago")
public class MetodoPagoRestController {
    
    @Autowired
    MetodoPagoService service;

    // Crear
    @PostMapping
    public MetodoPago crearMetodoPago(MetodoPago metodoPago) {
        return service.crearMetodoPago(metodoPago);
    }

    @GetMapping
    public List<MetodoPago> listarMetodosPago() {
        return service.listarMetodosPago();
    }

    @GetMapping("/id/{id}")
    public MetodoPago obtenerMetodoPagoPorId(Integer id) {
        return service.buscarMetodoPagoPorId(id);
    }

    // Actualizar
    @PutMapping("/{id}")
    public MetodoPago actualizarMetodoPago(Integer id, MetodoPago metodoPago) {
        return service.actualizarMetodoPago(id, metodoPago);
    }

    @DeleteMapping("/{id}")
    public MetodoPago eliminarMetodoPago(Integer id) {
        return service.eliminarMetodoPaago(id);
    }

}
