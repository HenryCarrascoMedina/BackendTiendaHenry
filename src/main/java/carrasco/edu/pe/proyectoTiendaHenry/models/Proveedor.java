package carrasco.edu.pe.proyectoTiendaHenry.models;

import java.time.LocalDateTime;

import carrasco.edu.pe.proyectoTiendaHenry.models.Enums.TipoDocumento;
import jakarta.persistence.*;

@Entity
@Table(name = "proveedor")
public class Proveedor {
    
    @Id
    @Column(name = "id_proveedor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProveedor;
    private String nombre;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_documento")
    private TipoDocumento tipoDocumento;
    private String documento;
    private String telefono;
    private String correo;
    private String direccion;
    private String contacto;
    private boolean estado;
    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    public Proveedor() {
    }

    public Proveedor(Integer idProveedor, String nombre, TipoDocumento tipoDocumento, String documento, String telefono,
            String correo, String direccion, String contacto, boolean estado, LocalDateTime fechaRegistro) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.contacto = contacto;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
    }



    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    
}
