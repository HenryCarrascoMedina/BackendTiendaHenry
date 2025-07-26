package carrasco.edu.pe.proyectoTiendaHenry.models;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "metodo_pago")
public class MetodoPago {

    @Id
    @Column(name = "id_metodo_pago")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMetodoPago;
    private String nombre;
    private String descripcion;
    private Boolean estado;
    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    public MetodoPago() {
    }

    public MetodoPago(Integer idMetodoPago, String nombre, String descripcion, Boolean estado,
            LocalDateTime fechaRegistro) {
        this.idMetodoPago = idMetodoPago;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(Integer idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
