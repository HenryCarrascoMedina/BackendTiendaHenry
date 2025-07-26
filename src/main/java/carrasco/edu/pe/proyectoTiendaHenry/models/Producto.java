package carrasco.edu.pe.proyectoTiendaHenry.models;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @Column(name = "id_producto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;
    private String nombre;
    private String descripcion;
    @Column(name = "precio_unitario")
    private double precioUnitario;
    private int stock;
    @Column(name = "unidad_medida")
    private String unidadMedida;
    @Column(name = "imagen_url")
    private String imagenURL;
    private boolean estado;
    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private Proveedor proveedor;

    public Producto() {
    }

    public Producto(Integer idProducto, String nombre, String descripcion, double precioUnitario, int stock,
            String unidadMedida, String imagenURL, boolean estado, LocalDateTime fechaRegistro, Categoria categoria,
            Proveedor proveedor) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.stock = stock;
        this.unidadMedida = unidadMedida;
        this.imagenURL = imagenURL;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
        this.categoria = categoria;
        this.proveedor = proveedor;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
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

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getImagenURL() {
        return imagenURL;
    }

    public void setImagenURL(String imagenURL) {
        this.imagenURL = imagenURL;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @PrePersist
    public void prePersist() {
        this.fechaRegistro = LocalDateTime.now();
    }
    

    
}
