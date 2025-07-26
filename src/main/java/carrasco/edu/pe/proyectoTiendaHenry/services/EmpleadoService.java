package carrasco.edu.pe.proyectoTiendaHenry.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carrasco.edu.pe.proyectoTiendaHenry.models.Empleado;
import carrasco.edu.pe.proyectoTiendaHenry.repositories.EmpleadoRepository;

@Service
public class EmpleadoService {
    
    @Autowired
    private EmpleadoRepository repository;

    // Listar empleados
    public List<Empleado> listarEmpleados() {
        return repository.findAll();
    }

    // Obtener empleado por ID
    public Empleado obtenerEmpleadoPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    // Guardar empleado
    public Empleado guardarEmpleado(Empleado empleado) {
        return repository.save(empleado);
    }

    // Actualizar empleado
    public Empleado actualizarEmpleado(Integer id,Empleado empleado){
        Empleado existe = repository.findById(id).orElse(null);
        if (existe != null) {
            existe.setIdEmpleado(empleado.getIdEmpleado());
            existe.setNombre(empleado.getNombre());
            existe.setApellido(empleado.getApellido());
            existe.setCorreo(empleado.getCorreo());
            existe.setContrasena(empleado.getContrasena());
            existe.setTelefono(empleado.getTelefono());
            existe.setRol(empleado.getRol());
            existe.setEstado(empleado.getEstado());
            existe.setFechaRegistro(empleado.getFechaRegistro());
            existe.setSucursal(empleado.getSucursal());
            return repository.save(existe);          
        }
        return null;
    }

    // Eliminar empleado
    public void eliminarEmpleado(Integer id){
        Empleado existe = repository.findById(id).orElse(null);
        if (existe != null) {
            existe.setEstado(false);
            repository.save(existe);
        }
    }
}
