package carrasco.edu.pe.proyectoTiendaHenry.models;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "sucursal")
public class Sucursal {
    
    @Id
    @Column(name = "id_sucursal")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSucursal;
    private String nombre;
    private String direccion;
    private String telefono;
    private Boolean estado;
    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    public Sucursal() {
    }

    public Sucursal(Integer idSucursal, String nombre, String direccion, String telefono, Boolean estado, LocalDateTime fechaRegistro) {
        this.idSucursal = idSucursal;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    @PrePersist
    public void prePersist() {
        this.fechaRegistro = LocalDateTime.now();
    }
    
}
