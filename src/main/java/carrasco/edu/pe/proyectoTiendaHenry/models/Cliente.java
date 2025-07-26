package carrasco.edu.pe.proyectoTiendaHenry.models;

import java.time.LocalDateTime;

import carrasco.edu.pe.proyectoTiendaHenry.models.Enums.TipoDocumento;
import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {
    
    @Id
    @Column(name = "id_cliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;
    private String nombre;
    private String apellido;
    @Column(name = "tipo_documento")
    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumento;
    private String documento;
    private String telefono;
    private String correo;
    private String direccion;
    private String contrasena;
    private Boolean estado;
    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    public Cliente() {
    }

    public Cliente(Integer idCliente, String nombre, String apellido, TipoDocumento tipoDocumento, String documento,
            String telefono, String correo, String direccion, String contrasena, Boolean estado,
            LocalDateTime fechaRegistro) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.contrasena = contrasena;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
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

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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
