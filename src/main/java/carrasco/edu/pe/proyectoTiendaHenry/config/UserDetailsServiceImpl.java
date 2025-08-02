package carrasco.edu.pe.proyectoTiendaHenry.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import carrasco.edu.pe.proyectoTiendaHenry.models.Empleado;
import carrasco.edu.pe.proyectoTiendaHenry.repositories.EmpleadoRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Empleado empleado = empleadoRepository.findByCorreo(correo)
            .orElseThrow(() -> new UsernameNotFoundException("Empleado no encontrado: " + correo));

        String rol = "ROLE_" + empleado.getRol(); // Convierte a formato Spring

        return new User(
            empleado.getCorreo(),
            empleado.getContrasena(), // Debe estar encriptada con BCrypt
            List.of(new SimpleGrantedAuthority(rol))
        );
    }
}

