package carrasco.edu.pe.proyectoTiendaHenry.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carrasco.edu.pe.proyectoTiendaHenry.models.Cliente;
import carrasco.edu.pe.proyectoTiendaHenry.repositories.ClienteRepository;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository repository;

    // Crear un cliente
    public Cliente crearCliente(Cliente cliente) {
        return repository.save(cliente);
    }

    // Listar todos los clientes
    public List<Cliente> listarClientes() {
        return repository.findAll();
    }

    // Buscar un cliente por ID
    public Cliente buscarClientePorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    // Buscar cliente por correo
    public Cliente buscarClientePorCorreo(String correo) {
        return repository.findByCorreo(correo);
    }

    // Listar clientes por estado
    public List<Cliente> listarClientesPorEstado(Boolean estado) {
        return repository.findByEstado(estado);
    }

    // Actualizar un cliente
    public Cliente actualizarCliente(Integer id, Cliente clienteActualizado) {
        Cliente clienteExistente = repository.findById(id).orElse(null);
        if (clienteExistente != null) {
            clienteExistente.setNombre(clienteActualizado.getNombre());
            clienteExistente.setApellido(clienteActualizado.getApellido());
            clienteExistente.setTipoDocumento(clienteActualizado.getTipoDocumento());
            clienteExistente.setDocumento(clienteActualizado.getDocumento());
            clienteExistente.setTelefono(clienteActualizado.getTelefono());
            clienteExistente.setCorreo(clienteActualizado.getCorreo());
            clienteExistente.setDireccion(clienteActualizado.getDireccion());
            clienteExistente.setContrasena(clienteActualizado.getContrasena());
            clienteExistente.setEstado(clienteActualizado.getEstado());
            clienteExistente.setFechaRegistro(clienteActualizado.getFechaRegistro());
            return repository.save(clienteExistente);
        }
        return null;
    }

    // Eliminar un cliente (lógica)
    public Cliente eliminarCliente(Integer id) {
        Cliente cliente = repository.findById(id).orElse(null);
        if (cliente != null) {
            cliente.setEstado(false);
            return repository.save(cliente);
        }
        return null;
    }

}
