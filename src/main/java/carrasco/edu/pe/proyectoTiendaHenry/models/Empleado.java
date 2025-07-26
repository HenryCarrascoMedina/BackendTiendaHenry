package carrasco.edu.pe.proyectoTiendaHenry.models;

import java.time.LocalDateTime;

import carrasco.edu.pe.proyectoTiendaHenry.models.Enums.RolEmpleado;
import jakarta.persistence.*;

@Entity
@Table(name = "empleado")
public class Empleado {
    
    @Id
    @Column(name = "id_empleado")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmpleado;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;
    private String telefono;
    @Enumerated(EnumType.STRING)
    private RolEmpleado rol;
    private Boolean estado;
    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;
    @ManyToOne
    @JoinColumn(name = "id_sucursal")
    private Sucursal sucursal;

    public Empleado() {
    }

    public Empleado(Integer idEmpleado, String nombre, String apellido, String correo, String contrasena, String telefono, RolEmpleado rol, Boolean estado, LocalDateTime fechaRegistro, Sucursal sucursal) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.rol = rol;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
        this.sucursal = sucursal;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public RolEmpleado getRol() {
        return rol;
    }

    public void setRol(RolEmpleado rol) {
        this.rol = rol;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    @PrePersist
    public void prePersist() {
        this.fechaRegistro = LocalDateTime.now();
    }

    
}
