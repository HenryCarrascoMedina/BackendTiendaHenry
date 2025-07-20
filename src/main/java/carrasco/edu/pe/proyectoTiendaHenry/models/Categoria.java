package carrasco.edu.pe.proyectoTiendaHenry.models;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name="categoria")
public class Categoria {
    
    @Id
    @Column(name="id_categoria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategoria;
    private String nombre;
    private String descripcion;
    private boolean estado;
    @Column(name="fecha_creacion")
    private LocalDateTime fechaCreacion;
    
    public Categoria() {
    }

    public Categoria(Integer idCategoria, String nombre, String descripcion, boolean estado,
            LocalDateTime fechaCreacion) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdProducto(Integer idCategoria) {
        this.idCategoria = idCategoria;
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    
}
