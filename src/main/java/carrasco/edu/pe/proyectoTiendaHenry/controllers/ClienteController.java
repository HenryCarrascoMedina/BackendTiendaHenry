package carrasco.edu.pe.proyectoTiendaHenry.controllers;

import carrasco.edu.pe.proyectoTiendaHenry.models.Cliente;
import carrasco.edu.pe.proyectoTiendaHenry.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Crear un nuevo cliente
    @PostMapping
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        Cliente nuevo = clienteService.crearCliente(cliente);
        return ResponseEntity.ok(nuevo);
    }

    // Obtener todos los clientes
    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        return ResponseEntity.ok(clienteService.listarClientes());
    }

    // Buscar cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Integer id) {
        Cliente cliente = clienteService.buscarClientePorId(id);
        return (cliente != null) ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
    }

    // Buscar cliente por correo
    @GetMapping("/buscar")
    public ResponseEntity<Cliente> buscarPorCorreo(@RequestParam String correo) {
        Cliente cliente = clienteService.buscarClientePorCorreo(correo);
        return (cliente != null) ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
    }

    // Listar por estado (activo/inactivo)
    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Cliente>> listarPorEstado(@PathVariable Boolean estado) {
        return ResponseEntity.ok(clienteService.listarClientesPorEstado(estado));
    }

    // Actualizar un cliente
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Integer id, @RequestBody Cliente cliente) {
        Cliente actualizado = clienteService.actualizarCliente(id, cliente);
        return (actualizado != null) ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    // Eliminar (desactivar) un cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> eliminarCliente(@PathVariable Integer id) {
        Cliente eliminado = clienteService.eliminarCliente(id);
        return (eliminado != null) ? ResponseEntity.ok(eliminado) : ResponseEntity.notFound().build();
    }
}

