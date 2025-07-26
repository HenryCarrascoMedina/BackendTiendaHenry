package carrasco.edu.pe.proyectoTiendaHenry.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import carrasco.edu.pe.proyectoTiendaHenry.models.Empleado;
import carrasco.edu.pe.proyectoTiendaHenry.services.EmpleadoService;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoRestController {
    
    @Autowired
    private EmpleadoService service;

    // Listar empleados
    @GetMapping
    public List<Empleado> listarEmpleados() {
        return service.listarEmpleados();
    }

    // Obtener empleado por ID
    @GetMapping("/{id}")
    public ResponseEntity<Empleado> obtenerEmpleadoPorId(Integer id) {
        Empleado empleado = service.obtenerEmpleadoPorId(id);
        return (empleado != null) ? ResponseEntity.ok(empleado) : ResponseEntity.notFound().build();
    }

    // Guardar empleado
    @PostMapping
    public ResponseEntity<Empleado> guardarEmpleado(@RequestBody Empleado empleado) {
        Empleado nuevoEmpleado = service.guardarEmpleado(empleado);
        return ResponseEntity.ok(nuevoEmpleado);
    }

    // Actualizar empleado
    @PutMapping("/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(Integer id, @RequestBody Empleado empleado) {
        Empleado actualizado = service.actualizarEmpleado(id, empleado);
        return (actualizado != null) ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    // Eliminar empleado
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmpleado(Integer id) {
        service.eliminarEmpleado(id);
        return ResponseEntity.noContent().build();
    }
}
